package main.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

import main.java.latintrainer.model.Query;
import main.java.latintrainer.model.Session;
import main.java.latintrainer.model.*;


import static main.java.latintrainer.model.QueryList.WORDS;

public class NextWordIntentHandler implements RequestHandler{
    public static final String ANSWER_KEY = "ANSWER";
    public static final String ANSWER_SLOT = "Answer";
    public static Session currentSession;
    public static Query currentQuery;
    Mode sessionMode;
    Direction sessionDir;
    public static boolean currentDirIsGerman;
    public static boolean isFirst = true;
    String savedMode;
    String savedDir;
    int savedChapter;
    int savedHighscore;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NextWordIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        if (isFirst) {
            AttributesManager attributesManager = input.getAttributesManager();
            Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
            persistentAttributes.put("kapitel", 1);
            persistentAttributes.put("highscore", 4);
            attributesManager.setPersistentAttributes(persistentAttributes);
            attributesManager.savePersistentAttributes();
            savedMode = (String) persistentAttributes.get("modus");
            savedDir = (String) persistentAttributes.get("richtung");
            savedChapter = (Integer) persistentAttributes.get("kapitel");
            savedHighscore = (Integer) persistentAttributes.get("highscore");


            switch (savedMode) {
                case "Fortschritt":
                    sessionMode = Mode.PROGRESS;
                    break;
                case "Zufall":
                    sessionMode = Mode.CHAPTER;
                    break;
                case "Kapitel":
                    sessionMode = Mode.RANDOM;
                    break;
                default:
                    throw new RuntimeException();
            }
            switch (savedDir) {
                case "deutsch":
                    sessionDir = Direction.GERMAN;
                    currentDirIsGerman = true;
                    break;
                case "lateinisch":
                    sessionDir = Direction.LATIN;
                    currentDirIsGerman = false;
                    break;
                case "zufall":
                    sessionDir = Direction.RANDOM;
                    currentDirIsGerman = Math.random() < 0.5;
                    break;
                default:
                    throw new RuntimeException();
            }

            currentSession = new Session(sessionDir, sessionMode, savedChapter, savedHighscore);
            isFirst = false;
        }
        // check mode
        currentQuery = WORDS.get((int) (Math.random()*20));
        // check direction
        // String toTranslate = currentQuery.getLatinWord(); //old
        String toTranslate = currentDirIsGerman ? currentQuery.getLatinWord(): currentQuery.getGermanWord();
        String speechText = String.format("Das zu übersetzende Wort lautet %s. Bitte sage, die Antwort ist x y, " +
                "oder wenn du es nicht weißt, keine Ahnung. Session: %s, %s, %d, %d", toTranslate, sessionDir.getDirection(),
                sessionMode.getModeName(), savedChapter, savedHighscore);

        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .withShouldEndSession(false)
                .build();
    }
}