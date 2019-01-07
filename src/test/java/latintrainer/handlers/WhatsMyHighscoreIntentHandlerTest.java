package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.WhatsMyHighscoreIntentHandler;
import org.junit.Before;
import org.junit.Test;

import static main.java.latintrainer.model.LatinTrainerTools.DIR_SLOT;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhatsMyHighscoreIntentHandlerTest {

    private WhatsMyHighscoreIntentHandler sut;
    private HandlerInput inputMock;

    @Before
    public void setup() {
        sut = new WhatsMyHighscoreIntentHandler();
        inputMock = mock(HandlerInput.class);
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), WhatsMyHighscoreIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

}
