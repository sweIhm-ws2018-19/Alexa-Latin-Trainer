package main.java.latintrainer.model;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Slot;
import java.util.Map;

public class LatinTrainerTools {

    private LatinTrainerTools() {}

    // String constants used across different classes
    public static final String DIR_SLOT = "dir";
    public static final String CHAP_SLOT = "chap";
    public static final String MODE_SLOT = "mode";
    public static final String ANSWER_KEY = "ANSWER";
    public static final String ANSWER_SLOT = "Answer";

    public static final String DIRECTION = "richtung";
    public static final String MODE = "modus";
    public static final String CHAPTER = "kapitel";
    public static final String HIGHSCORE = "highscore";

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
        persistentAttributes.put(tableName, userAnswer.toLowerCase());
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();
    }

    public static Map<String, Object> getAttributes(HandlerInput input) {
        AttributesManager attributesManager = input.getAttributesManager();
        return attributesManager.getPersistentAttributes();
    }

    public static void checkAndSaveAlltimeHighscore(Session currentSession, HandlerInput input) {
        int currentScore = currentSession.getCurrentHighscore().getHighscoreValue();
        int allTimeHS = currentSession.getAllTimeHighscore().getHighscoreValue();
        int newAlltimeHS = allTimeHS > currentScore? allTimeHS : currentScore;
        LatinTrainerTools.saveData(HIGHSCORE, Integer.toString(newAlltimeHS), input);
    }
}
