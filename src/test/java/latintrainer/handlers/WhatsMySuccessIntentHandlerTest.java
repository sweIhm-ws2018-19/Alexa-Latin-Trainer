package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.WhatsMySuccessIntentHandler;
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

public class WhatsMySuccessIntentHandlerTest {

    private WhatsMySuccessIntentHandler sut;
    private HandlerInput inputMock;

    @Before
    public void setup() {
        sut = new WhatsMySuccessIntentHandler();
        inputMock = mock(HandlerInput.class);
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), WhatsMySuccessIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }
    @Test
    public void testHandle() {
        Map<String, String> slots = new HashMap<>();
        slots.put(DIRECTION, "deutsch");
        slots.put(MODE, "Fortschritt");
        slots.put(CHAPTER, "1");
        slots.put(HIGHSCORE, "50");
        final Response response = TestUtil.standardTestForHandle(sut, slots);
        assertTrue(response.getOutputSpeech().toString().contains("Du bist gerade in Kapitel"));
    }

}
