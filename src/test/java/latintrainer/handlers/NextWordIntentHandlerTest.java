package test.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.NextWordIntentHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;

import static main.java.latintrainer.model.LatinTrainerTools.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class NextWordIntentHandlerTest {

    private NextWordIntentHandler sut;

    @Before
    public void setup() {
        sut = new NextWordIntentHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), NextWordIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
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
        assertTrue(response.getOutputSpeech().toString().contains("Das zu übersetzende Wort lautet Domus. Bitte sage, die Antwort ist x y, " +
                "oder wenn du es nicht weißt, keine Ahnung.") ||
                response.getOutputSpeech().toString().contains("Ich habe dich nicht verstanden. Wenn ich lateinische Vokabeln ansagen soll, sage lateinisch. Ansonsten sage deutsch."));
    }
}