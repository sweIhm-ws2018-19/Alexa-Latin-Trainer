package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import main.java.latintrainer.model.Chapter;
import main.java.latintrainer.model.Direction;
import main.java.latintrainer.model.LatinTrainerTools;
import main.java.latintrainer.model.Mode;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;
import static main.java.latintrainer.model.LatinTrainerTools.*;

public class SetChapterIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetChapterIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.updateHighscore();
        CURRENT_SESSION.setCurrentHandler("SetChap");
        Slot answerSlot = LatinTrainerTools.getAnswerSlot(CHAP_SLOT, input);
        String speechText;
        String repromptText;

        if (answerSlot != null) {

            String userAnswer = answerSlot.getValue();
            if (userAnswer.equals("1") || userAnswer.equals("2") || userAnswer.equals("3")) {

                saveData(CHAPTER, userAnswer, input);
                int choice = userAnswer.equals("1")? 0 : userAnswer.equals("2") ? 1 : 2;
                CURRENT_SESSION.setChapter(choice);

                speechText = "Okay. Dein Kapitel ist Nummer " + userAnswer + " von drei. Wähle nun die Richtung. Sage zum Beispiel: " +
                        " Wähle Richtung deutsch. Oder sage Hilfe für eine genauere Anleitung.";

                repromptText = "Sage zum Beispiel Wähle Richtung deutsch.";
            }
            else {
                speechText = "Ich konnte dich nicht verstehen. Sage wähle Kapitel eins zum Beispiel.";
                repromptText = "Sage zum Beispiel Wähle Kapitel eins.";
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