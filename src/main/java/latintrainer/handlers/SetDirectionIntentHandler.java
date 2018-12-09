package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import main.java.latintrainer.model.Direction;
import main.java.latintrainer.model.LatinTrainerTools;
import static main.java.latintrainer.model.LatinTrainerTools.*;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class SetDirectionIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetDirectionIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.setCurrentHandler("SetDir");
        Slot answerSlot = LatinTrainerTools.getAnswerSlot(DIR_SLOT, input);
        String speechText;
        String repromptText;

        if(answerSlot != null) {

            String userAnswer = answerSlot.getValue();

            if(userAnswer.equalsIgnoreCase(Direction.LATIN.getDirection()) || userAnswer.equalsIgnoreCase(Direction.GERMAN.getDirection())) {
                saveData(DIRECTION, userAnswer, input);
                CURRENT_SESSION.setIsChangingSession(true);
                Direction choice = userAnswer.equalsIgnoreCase(Direction.LATIN.getDirection())? Direction.LATIN : Direction.GERMAN;
                CURRENT_SESSION.setDir(choice);

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

