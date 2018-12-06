package main.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import main.java.latintrainer.model.LatinTrainerTools;


import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.SetModeIntentHandler.DIR_SLOT;

import static main.java.latintrainer.handlers.NextWordIntentHandler.isChangingSession;

import static main.java.latintrainer.handlers.NextWordIntentHandler.isChangingSession;

public class SetDirectionIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetDirectionIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Slot answerSlot = LatinTrainerTools.getAnswerSlot(DIR_SLOT, input);
        String speechText;
        String repromptText;

        if(answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if(userAnswer.equalsIgnoreCase("lateinisch") || userAnswer.equalsIgnoreCase("deutsch")) {
                LatinTrainerTools.saveData("richtung", userAnswer.toLowerCase(), input);
                speechText = "Sage neues Wort, um die Übung zu beginnen";
                repromptText = "Bitte sage neues Wort.";
                isChangingSession = true;
            }
            else {
                speechText = "Ich habe dich nicht verstanden. Wenn ich lateinische Vokabeln ansagen soll, sage lateinisch. Ansonsten sage deutsch.";
                repromptText = "Sage deutsch oder lateinisch.";
            }
        }
        else {
            speechText = "Ich habe dich nicht verstanden. Wenn ich lateinische Vokabeln ansagen soll, sage lateinisch. Ansonsten sage deutsch.";
            repromptText = "Sage deutsch oder lateinisch.";
        }
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}

