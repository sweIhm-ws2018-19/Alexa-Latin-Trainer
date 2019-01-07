package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Map;
import java.util.Optional;
import main.java.latintrainer.model.*;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;
import static main.java.latintrainer.model.LatinTrainerTools.*;


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
            if(persistentAttributes.isEmpty()){
                CURRENT_SESSION.highscoreUpdated(true);
                saveData(DIRECTION, "deutsch", input);
                saveData(MODE, "zufall", input);
                saveData(CHAPTER, "1", input);
                saveData(HIGHSCORE, "0", input);
            }
            String savedMode = (String) persistentAttributes.get(MODE);
            String savedDir = (String) persistentAttributes.get(DIRECTION);
            int savedChapter = Integer.parseInt((String)persistentAttributes.get(CHAPTER));
            int savedHighscore = Integer.parseInt((String) persistentAttributes.get(HIGHSCORE));

            Mode savedModeValue = Mode.CHAPTER;

            if(savedMode.equalsIgnoreCase(Mode.PROGRESS.getModeName()))
                savedModeValue = Mode.PROGRESS;
            else if(savedMode.equalsIgnoreCase(Mode.RANDOM.getModeName()))
                savedModeValue = Mode.RANDOM;


            Direction savedDirValue = Direction.RANDOM;

            if(savedDir.equalsIgnoreCase(Direction.LATIN.getDirection()))
                savedDirValue = Direction.LATIN;
            else if(savedDir.equalsIgnoreCase(Direction.GERMAN.getDirection()))
                savedDirValue = Direction.GERMAN;

            CURRENT_SESSION.setMode(savedModeValue).setDir(savedDirValue).setChapter(savedChapter-1).setAllTimeHighscore(savedHighscore).setIsChangingSession(false);
        }

        Query currentQuery = CURRENT_SESSION.nextQuery();

        String toTranslate = CURRENT_SESSION.getDir().equals(Direction.GERMAN) ? currentQuery.getLatinWord(): currentQuery.getGermanWord();
        String speechText = String.format("Das zu übersetzende Wort lautet %s. Bitte sage, die Antwort ist x y, " +
                "oder wenn du es nicht weißt, keine Ahnung.", toTranslate) +
                (CURRENT_SESSION.getAlreadyAskedAsInt() % 5 == 0? " Vergiss nicht: Du kannst auch jederzeit " +
                "deinen Highscore oder deinen Fortschritt abrufen. Sage dafür einfach Highscore beziehungsweise Fortschritt.":"");

        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .withShouldEndSession(false)
                .build();
    }
}