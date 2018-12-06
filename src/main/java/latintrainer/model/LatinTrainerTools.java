package main.java.latintrainer.model;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Slot;

import java.util.List;
import java.util.Map;

public class LatinTrainerTools {

    /*
    --- constants not tested yet ----

    public static final String DIR_SLOT = "dir";
    public static final String MODE_SLOT = "mode";
    */

    public static Slot getAnswerSlot(String slotName, HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        return slots.get(slotName);
    }

    public static void saveData(String tableName, String userAnswer, HandlerInput input) {
        AttributesManager attributesManager = input.getAttributesManager();
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.put(tableName, userAnswer);
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();
    }

    public static List<Query> createQueryList() {return null;}


}
