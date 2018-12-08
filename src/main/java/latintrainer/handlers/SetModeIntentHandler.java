package main.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import main.java.latintrainer.model.LatinTrainerTools;
import main.java.latintrainer.model.Mode;
import main.java.latintrainer.model.Session;


import java.util.Map;
import java.util.Optional;

import static main.java.latintrainer.model.LatinTrainerTools.*;
import static com.amazon.ask.request.Predicates.intentName;

public class SetModeIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetModeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Slot answerSlot = getAnswerSlot(MODE_SLOT, input);
        String speechText;
        String repromptText;

        if (answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if (userAnswer.equalsIgnoreCase(PROGRESS) || userAnswer.equalsIgnoreCase(RANDOM)) {

                saveData(MODE, userAnswer, input);

                speechText = String.format("Okay. Dein Modus ist %s. Wähle nun die Richtung: Willst du lieber die " +
                        "deutschen oder die lateinischen Worte sagen? Sage zum Beispiel Wähle Richtung deutsch.", userAnswer);

                repromptText = "Sage zum Beispiel Wähle Richtung deutsch.";

            } else {
                speechText = "Ich konnte dich nicht verstehen. Sage Fortschritt für deinen letzten Speicherstand oder Zufall für eine zufällige Abfrage.";
                repromptText = "Sage zum Beispiel Wähle Modus Fortschritt oder Zufall.";
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
