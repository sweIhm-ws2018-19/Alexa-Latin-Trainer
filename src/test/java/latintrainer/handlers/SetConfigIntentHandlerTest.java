package test.java.latintrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import main.java.latintrainer.handlers.SetConfigIntentHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


public class SetConfigIntentHandlerTest {

    private SetConfigIntentHandler sut;

    @Before
    public void setup() {
        sut = new SetConfigIntentHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), SetConfigIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut);
        assertTrue(response.getOutputSpeech().toString().contains("Okay, Du kannst zwischen den Modi Zufall, Fortschritt und Kapitel entscheiden. " +
                "Sage zum Beispiel: Wähle Modus Fortschritt oder Hilfe für genauere Informationen"));
    }

}
