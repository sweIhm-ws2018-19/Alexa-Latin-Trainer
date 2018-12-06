package main.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import main.java.latintrainer.model.LatinTrainerTools;


import java.util.Map;
import java.util.Optional;

import static main.java.latintrainer.handlers.LaunchRequestHandler.MODE_SLOT;

import static com.amazon.ask.request.Predicates.intentName;
//import static main.java.latintrainer.handlers.SetConfigIntentHandler.MODE_SLOT;

public class SetModeIntentHandler implements RequestHandler{

    public static String DIR_SLOT = "dir";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetModeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Slot answerSlot = LatinTrainerTools.getAnswerSlot(MODE_SLOT, input);  // slots.get(MODE_SLOT);

        String speechText;
        String repromptText;

        if (answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if (userAnswer.equalsIgnoreCase("Fortschritt") || userAnswer.equalsIgnoreCase("Zufall")) {

                LatinTrainerTools.saveData("modus", userAnswer.toLowerCase(), input);

                speechText = String.format("Okay. Dein Modus ist %s. Waehle nun die Richtung: Willst du lieber die " +
                        "deutschen oder die lateinischen Worte sagen? Sage zum Beispiel Waehle Richtung deutsch.", userAnswer);

                repromptText = "Sage deutsch oder lateinisch.";

            } else {
                speechText = "Ich konnte dich nicht verstehen. Sage Fortschritt für deinen letzten Speicherstand oder Zufall für eine zufällige Abfrage.";
                repromptText = "Sage Fortschritt oder Zufall.";
            }
        }
        else {
            speechText = "Das habe ich leider nicht verstanden. Bitte versuche es noch einmal.";
            repromptText = "Sage Fortschritt oder Zufall.";
        }

        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
