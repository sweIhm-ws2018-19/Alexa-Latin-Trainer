package test.java.latintrainer.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.CheckAnswerIntentHandler;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static main.java.latintrainer.model.LatinTrainerTools.*;
import static main.java.latintrainer.model.LatinTrainerTools.HIGHSCORE;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckAnswerIntentHandlerTest {

    private CheckAnswerIntentHandler sut;
    private HandlerInput inputMock;

    @Before
    public void setup() {
        sut = new CheckAnswerIntentHandler();
        inputMock = mock(HandlerInput.class);
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), CheckAnswerIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }
    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut, ANSWER_SLOT, "Bla");
        assertTrue(response.getOutputSpeech().toString().contains("Richtig. Sage Neues Wort um weiterzumachen") ||
                response.getOutputSpeech().toString().contains("Falsch. Es ist nicht") ||
                response.getOutputSpeech().toString().contains("Das habe ich leider nicht verstanden. Bitte versuche es noch einmal."));
    }
}
