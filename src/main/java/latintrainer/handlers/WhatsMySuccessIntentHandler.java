package main.java.latintrainer.handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.LaunchRequestHandler.CURRENT_SESSION;

public class WhatsMySuccessIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsMySuccessIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        CURRENT_SESSION.updateHighscore();
        CURRENT_SESSION.setCurrentHandler("Success");
        int currentChapter = CURRENT_SESSION.getChapter().getChapterAsInt()+1;
        int chapterCount = CURRENT_SESSION.getAnsweredCorrectlyAsInt();
        int chapterSize = CURRENT_SESSION.getChapterSize();
        String mode = CURRENT_SESSION.getMode().getModeName();
        String direction = CURRENT_SESSION.getDir().getDirection();
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

