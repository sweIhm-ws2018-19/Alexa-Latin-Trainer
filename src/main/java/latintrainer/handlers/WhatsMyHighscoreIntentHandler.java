package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.LatinTrainerStreamHandler.CURRENT_SESSION;

public class WhatsMyHighscoreIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsMyHighscoreIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.setCurrentHandler("Highscore");
        int allTimeHighscore = CURRENT_SESSION.getAllTimeHighscore().getHighscoreValue();
        int currentScore = CURRENT_SESSION.getCurrentHighscore().getHighscoreValue();
        String speechText;
        String repromptText;
        if (allTimeHighscore>currentScore) {
            speechText = String.format("Dein jetziger Punktestand ist %s. Dein HighScore ist %s. Beantworte mehr Fragen, um " +
                    "deinen Highscore zu verbessern. Sage Neues Wort, um weiterzumachen.", currentScore,allTimeHighscore);
            repromptText = String.format("Deine jetziger Punktestand ist %s. Dein HighScore ist %s. " +
                    "Sage Neues Wort, um weiterzumachen.", currentScore,allTimeHighscore);
        } else {
            speechText = String.format("Diese Session ist bis jetzt deine beste! Du hast gerade %s Punkte. " +
                    " Sage Neues Wort, um weiterzumachen.", currentScore);
            repromptText = String.format("Deine jetziger Punktestand ist %s." +
                    "Sage Neues Wort, um weiterzumachen.", currentScore);
        }
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
