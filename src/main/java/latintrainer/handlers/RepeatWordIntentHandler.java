package main.java.latintrainer.handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.model.LatinTrainerTools.*;
import static main.java.latintrainer.handlers.NextWordIntentHandler.currentQuery;

public class RepeatWordIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RepeatWordIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String toTranslate = currentDirIsGerman ? currentQuery.getLatinWord(): currentQuery.getGermanWord();
        String speechText = "Das zu übersetzende Wort lautet " + toTranslate + ". Bitte sage, die Antwort ist x y, " +
                "oder wenn du es nicht weißt, keine Ahnung.";
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .withShouldEndSession(false)
                .build();
    }
}

