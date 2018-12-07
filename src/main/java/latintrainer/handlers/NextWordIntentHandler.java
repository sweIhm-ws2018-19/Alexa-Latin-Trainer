package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Map;
import java.util.Optional;
import main.java.latintrainer.model.*;
import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.model.LatinTrainerTools.*;


public class NextWordIntentHandler implements RequestHandler{

    public static Session currentSession;
    public static Query currentQuery;
    private static boolean isFirst = true;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NextWordIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        // dummy values to avoid bug - if
        Mode sessionMode = Mode.PROGRESS;
        Direction sessionDir = Direction.GERMAN;
        int savedChapter = 0;
        int savedHighscore = 0;

        if (isChangingSession) {
            Map<String, Object> persistentAttributes = getAttributes(input);
            String savedMode = (String) persistentAttributes.get(MODE);
            String savedDir = (String) persistentAttributes.get(DIRECTION);
            savedChapter = Integer.parseInt((String)persistentAttributes.get(CHAPTER));
            savedHighscore = Integer.parseInt((String) persistentAttributes.get(HIGHSCORE));

            switch (savedMode) {
                case PROGRESS:
                    sessionMode = Mode.PROGRESS;
                    break;
                case RANDOM:
                    sessionMode = Mode.CHAPTER;
                    break;
                case CHAPTER:
                    sessionMode = Mode.RANDOM;
                    break;
                default:
                    throw new RuntimeException();
            }
            switch (savedDir) {
                case GERMAN:
                    sessionDir = Direction.GERMAN;
                    currentDirIsGerman = true;
                    break;
                case LATIN:
                    sessionDir = Direction.LATIN;
                    currentDirIsGerman = false;
                    break;
                case RANDOM:
                    sessionDir = Direction.RANDOM;
                    currentDirIsGerman = Math.random() < 0.5;
                    break;
                default:
                    throw new RuntimeException();
            }
            if (isFirst) {
                currentSession = new Session(sessionDir, sessionMode, savedChapter, savedHighscore);
                isFirst = false;
            } else {
                currentSession.setDir(sessionDir);
                currentSession.setMode(sessionMode);
                currentSession.setChapter(savedChapter);
                currentSession.setAllTimeHighscore(savedHighscore);
            }
            isChangingSession = false;
        }
        // check mode
        currentQuery = currentSession.getCurrentWord();
        // check direction
        // String toTranslate = currentQuery.getLatinWord(); //old
        String toTranslate = currentDirIsGerman ? currentQuery.getLatinWord(): currentQuery.getGermanWord();
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