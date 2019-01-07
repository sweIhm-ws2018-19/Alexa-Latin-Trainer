package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.WhatsMySuccessIntentHandler;
import org.junit.Before;
import org.junit.Test;



import static main.java.latintrainer.model.LatinTrainerTools.*;
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
        final Response response = TestUtil.standardTestForHandle(sut, CHAP_SLOT, "1");
        assertTrue(response.getOutputSpeech().toString().contains("Du bist gerade in Kapitel"));
    }

}
