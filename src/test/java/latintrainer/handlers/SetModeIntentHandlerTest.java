package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.SetDirectionIntentHandler;
import main.java.latintrainer.handlers.SetModeIntentHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import test.java.latintrainer.handlers.TestUtil;

import static main.java.latintrainer.model.LatinTrainerTools.DIR_SLOT;
import static main.java.latintrainer.model.LatinTrainerTools.MODE_SLOT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class SetModeIntentHandlerTest {

    private SetModeIntentHandler sut;

    @Before
    public void setup() {
        sut = new SetModeIntentHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), SetModeIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut, MODE_SLOT, "Zufall");
        assertTrue(response.getOutputSpeech().toString().contains("Okay. Dein Modus ist Zufall. Wähle nun die Richtung. Sage zum Beispiel: " +
                "Wähle Richtung deutsch. Oder sage Hilfe für eine genauere Anleitung.") ||
                response.getOutputSpeech().toString().contains("Ich konnte dich nicht verstehen. Sage Fortschritt für deinen letzten Speicherstand oder Zufall für eine zufällige Abfrage."));
    }
}
