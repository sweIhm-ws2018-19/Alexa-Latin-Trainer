package main.java.latintrainer.handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.currentSession;
public class TellMeIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("TellMeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String answer = currentSession.getCurrentQuery().getGermanWord();
        String speechText = "Die Antwort ist " + answer + ". Sage Neues Wort um ein neues Wort zu bekommen.";
        String repromptText = "Sage Neues Wort um ein neues Wort zu bekommen.";
        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}