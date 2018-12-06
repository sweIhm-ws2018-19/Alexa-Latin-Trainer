package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class SetConfigIntentHandler implements RequestHandler {
    public static String MODE_SLOT = "mode";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetConfigIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Okay, wir konfigurieren den Latein Trainer neu. Zuerst kannst du den Modus waehlen. Du " +
                "kannst zwischen den Modi Zufall, Fortschritt und Kapitel entscheiden. Sage zum Beispiel: Waehle Modus " +
                "Fortschritt";
        String repromptText = "Du kannst zwischen den Modi Zufall, Fortschritt und Kapitel entscheiden. Sage zum " +
                "Beispiel: Waehle Modus Fortschritt";
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
