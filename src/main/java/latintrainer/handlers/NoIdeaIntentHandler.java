package main.java.latintrainer.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;

public class NoIdeaIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NoIdeaIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.updateHighscore();
        String speechText = "Kein Problem. Willst du das Wort wiederholen, überspringen oder auflösen?";
        String repromptText = "Willst du das Wort wiederholen, überspringen oder auflösen?";
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
