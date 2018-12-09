package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Map;
import java.util.Optional;
import main.java.latintrainer.model.*;
import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.model.LatinTrainerTools.*;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;


public class NextWordIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NextWordIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.setCurrentHandler("NextWord");
        if (CURRENT_SESSION.isChangingSession()) {
            Map<String, Object> persistentAttributes = getAttributes(input);
            String savedMode = (String) persistentAttributes.get(MODE);
            String savedDir = (String) persistentAttributes.get(DIRECTION);
            int savedChapter = Integer.parseInt((String)persistentAttributes.get(CHAPTER));
            int savedHighscore = Integer.parseInt((String) persistentAttributes.get(HIGHSCORE));

            Mode savedModeValue = savedMode.equalsIgnoreCase(Mode.PROGRESS.getModeName())?
                    Mode.PROGRESS : savedMode.equalsIgnoreCase(Mode.CHAPTER.getModeName())?
                    Mode.CHAPTER : Mode.RANDOM;

            Direction savedDirValue = savedDir.equalsIgnoreCase(Direction.LATIN.getDirection())?
                    Direction.LATIN : savedDir.equalsIgnoreCase(Direction.GERMAN.getDirection())?
                    Direction.GERMAN : Direction.RANDOM;

            CURRENT_SESSION.setMode(savedModeValue).setDir(savedDirValue).setIsChangingSession(false);

            if (CURRENT_SESSION.isFirstRound()) {
                CURRENT_SESSION.setChapter(0).setAllTimeHighscore(0).setIsFirstRound(false);
            } else {
                CURRENT_SESSION.setChapter(savedChapter).setAllTimeHighscore(savedHighscore);
            }
        }

        Query currentQuery = CURRENT_SESSION.nextQuery();

        String toTranslate = CURRENT_SESSION.getDir().equals(Direction.GERMAN) ? currentQuery.getLatinWord(): currentQuery.getGermanWord();
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