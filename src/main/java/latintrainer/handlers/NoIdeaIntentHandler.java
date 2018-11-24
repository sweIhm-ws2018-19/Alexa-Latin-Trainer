package main.java.latintrainer.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class NoIdeaIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NoIdeaIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Kein Problem. Willst du das Wort wiederholen, ueberspringen oder aufloesen?";
        String repromptText = "Willst du das Wort wiederholen, ueberspringen oder aufloesen?";
        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
