package main.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.SetModeIntentHandler.DIR_SLOT;

public class SetDirectionIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetDirectionIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        String speechText;
        String repromptText;

        Slot answerSlot = slots.get(DIR_SLOT);

        if(answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if(userAnswer.equalsIgnoreCase("lateinisch") || userAnswer.equalsIgnoreCase("deutsch")) {
                AttributesManager attributesManager = input.getAttributesManager();
                Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
                persistentAttributes.put("richtung", userAnswer.toLowerCase());
                attributesManager.setPersistentAttributes(persistentAttributes);
                attributesManager.savePersistentAttributes();
                speechText = "Sage neues Wort, um die Übung zu beginnen";
                repromptText = "Bitte sage neues Wort.";
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

