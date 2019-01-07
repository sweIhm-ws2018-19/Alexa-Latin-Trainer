package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import main.java.latintrainer.model.Direction;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;

public class TellMeIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("TellMeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.answeredCorrectly();
        CURRENT_SESSION.updateHighscore();
        String answer = CURRENT_SESSION.getDir().equals(Direction.GERMAN) ? CURRENT_SESSION.getCurrentWord().getGermanWord(): CURRENT_SESSION.getCurrentWord().getLatinWord();
        String speechText = "Die Antwort ist " + answer + ". Sage Neues Wort um ein neues Wort zu bekommen.";
        String repromptText = "Sage Neues Wort um ein neues Wort zu bekommen.";
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}