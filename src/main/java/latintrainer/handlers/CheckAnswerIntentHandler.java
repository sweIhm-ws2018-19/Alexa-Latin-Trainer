package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.NextWordIntentHandler.currentQuery;
import static main.java.latintrainer.handlers.NextWordIntentHandler.currentSession;
import static main.java.latintrainer.model.LatinTrainerTools.*;


public class CheckAnswerIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("CheckAnswerIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        // Get the color slot from the list of slots.
        Slot answerSlot = slots.get(ANSWER_SLOT);
        String answer = currentDirIsGerman ? currentQuery.getGermanWord(): currentQuery.getLatinWord();
        String speechText;
        String repromptText;
        boolean isAskResponse = false;

        // Check for favorite color and create output to user.
        if (answerSlot != null) {
            // Store the user's favorite color in the Session and create response.
            String userAnswer = answerSlot.getValue();
            if (userAnswer.equalsIgnoreCase(answer)) {
                speechText = "Richtig. Sage Neues Wort um weiterzumachen";
                currentSession.getCurrentHighscore().addToHighscore(2);
                currentSession.answeredCorrectly();
                repromptText = "Sage Neues Wort um weiterzumachen";
            } else{
                speechText = String.format("Falsch. Es ist nicht %s. Willst du das Wort wiederholen, überspringen oder auflösen?", userAnswer);
                currentSession.getCurrentHighscore().addToHighscore(-2);
                currentSession.answeredCorrectly();
                repromptText = "Willst du das Wort wiederholen, überspringen oder auflösen?";
            }
        } else {
            // Render an error since we don't know what the users answer is.
            speechText = "Das habe ich leider nicht verstanden. Bitte versuche es noch einmal.";
            repromptText = "Bitte versuche es noch einmal.";
            isAskResponse = true;
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);

        if (isAskResponse) {
            responseBuilder.withShouldEndSession(false)
                    .withReprompt(repromptText);
        }

        return responseBuilder.build();
    }

}

