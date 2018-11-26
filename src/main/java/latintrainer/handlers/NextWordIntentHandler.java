package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

import main.java.latintrainer.model.Query;
import static main.java.latintrainer.model.QueryList.WORDS;

public class NextWordIntentHandler implements RequestHandler{
    public static final String ANSWER_KEY = "ANSWER";
    public static final String ANSWER_SLOT = "Answer";
    public static Query currentQuery;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NextWordIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        currentQuery = WORDS.get((int) (Math.random()*20));
        String toTranslate = currentQuery.getLatinWord();
        String speechText = String.format("Das zu übersetzende Wort lautet %s. Bitte sage, die Antwort ist x y, " +
                "oder wenn du es nicht weißt, keine Ahnung.", toTranslate);
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .withShouldEndSession(false)
                .build();
    }
}