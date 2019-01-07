package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import java.util.Optional;

import main.java.latintrainer.model.Mode;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;
import static main.java.latintrainer.model.LatinTrainerTools.*;
import static com.amazon.ask.request.Predicates.intentName;

public class SetModeIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetModeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.updateHighscore();
        CURRENT_SESSION.setCurrentHandler("SetMode");

        Slot answerSlot = getAnswerSlot(MODE_SLOT, input);
        String speechText;
        String repromptText;

        if (answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if (userAnswer.equalsIgnoreCase(Mode.PROGRESS.getModeName()) || userAnswer.equalsIgnoreCase(Mode.RANDOM.getModeName())) {

                saveData(MODE, userAnswer, input);

                Mode choice = userAnswer.equalsIgnoreCase(Mode.PROGRESS.getModeName())? Mode.PROGRESS : Mode.RANDOM;
                CURRENT_SESSION.setMode(choice);

                speechText = String.format("Okay. Dein Modus ist %s. Wähle nun die Richtung. Sage zum Beispiel:" +
                        " Wähle Richtung deutsch. Oder sage Hilfe für eine genauere Anleitung.", userAnswer);

                repromptText = "Sage zum Beispiel Wähle Richtung deutsch.";

            } else if (userAnswer.equalsIgnoreCase(Mode.CHAPTER.getModeName())) {
                saveData(MODE, userAnswer, input);

                Mode choice = Mode.CHAPTER;
                CURRENT_SESSION.setMode(choice);

                speechText = String.format("Okay. Dein Modus ist %s. Wähle nun das Kapitel. Sage zum Beispiel:" +
                        "Wähle Kapitel eins. Oder sage Hilfe für eine genauere Anleitung.", userAnswer);

                repromptText = "Sage zum Beispiel Wähle Kapitel eins.";

            }
            else {
                speechText = "Ich konnte dich nicht verstehen. Sage wähle Modus Fortschritt, Zufall oder Kapitel.";
                repromptText = "Sage zum Beispiel Wähle Modus Fortschritt, Zufall oder Kapitel.";
            }
        }
        else {
            speechText = "Das habe ich leider nicht verstanden. Bitte versuche es noch einmal.";
            repromptText = "Sage zum Beispiel Wähle Modus Fortschritt oder Zufall.";
        }

        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
