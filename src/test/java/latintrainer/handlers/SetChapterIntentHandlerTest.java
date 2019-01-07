package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.SetChapterIntentHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static main.java.latintrainer.model.LatinTrainerTools.CHAP_SLOT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class SetChapterIntentHandlerTest {
    private SetChapterIntentHandler sut;

    @Before
    public void setup() {
        sut = new SetChapterIntentHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), SetChapterIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut, CHAP_SLOT, "1");
        assertTrue(response.getOutputSpeech().toString().contains("Okay. Dein Kapitel ist Nummer 1 von drei. " +
                "Wähle nun die Richtung. Sage zum Beispiel:  Wähle Richtung deutsch. Oder sage Hilfe für eine genauere Anleitung.") ||
                response.getOutputSpeech().toString().contains("Ich konnte dich nicht verstehen. Sage wähle Kapitel eins zum Beispiel."));
    }


}
