package main.java.latintrainer.handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import main.java.latintrainer.model.LatinTrainerTools;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.NextWordIntentHandler.currentSession;


public class WhatsMySuccessIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsMySuccessIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        LatinTrainerTools.setCurrentHandler("Success");
        int currentChapter = currentSession.getChapter().getChapterAsInt();
        int chapterCount = currentSession.getAnsweredCorrectlyAsInt();
        int chapterSize = currentSession.getChapterSize();
        String mode = currentSession.getMode().getModeName();
        String direction = currentSession.getDir().getDirection();
        String speechText = String.format("Du bist gerade in Kapitel %d. Du hast in diesem Kapitel bereits %d von %d" +
                " Wörtern richtig beantwortet. Weiter so! Gerade ist der Modus %s und die Richtung %s ausgewählt." +
                " Wenn du das ändern willst, sage: konfigurieren. Ansonsten sage neues Wort.", currentChapter,
                chapterCount, chapterSize, mode, direction);
        String repromptText = "Sage Start, um loszulegen.";
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}

