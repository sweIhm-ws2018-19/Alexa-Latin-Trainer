package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.SetDirectionIntentHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static main.java.latintrainer.model.LatinTrainerTools.DIR_SLOT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class SetDirectionIntentHandlerTest {

    private SetDirectionIntentHandler sut;

    @Before
    public void setup() {
        sut = new SetDirectionIntentHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), SetDirectionIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut, DIR_SLOT, "deutsch");
        assertTrue(response.getOutputSpeech().toString().contains("Sage neues Wort, um die Übung zu beginnen") ||
                response.getOutputSpeech().toString().contains("Ich habe dich nicht verstanden. Wenn ich lateinische Vokabeln ansagen soll, sage lateinisch. Ansonsten sage deutsch."));
    }
}