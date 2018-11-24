package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class SetDirectionIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetDirectionIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Danke für das Öffnen von Latein Trainer. Latein Trainer hilft dir, deine lateinischen " +
                "Vokabeln besser zu verinnerlichen. Außerdem kannst du selber festlegen, wie du abgefragt werden " +
                "willst. Möchtest du die Erfahrung beginnen?";
        String repromptText = "Sage Start, um loszulegen.";
        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}

