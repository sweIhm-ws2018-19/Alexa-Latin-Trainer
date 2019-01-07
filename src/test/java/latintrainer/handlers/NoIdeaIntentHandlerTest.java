package test.java.latintrainer.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.NoIdeaIntentHandler;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoIdeaIntentHandlerTest {

    private NoIdeaIntentHandler sut;
    private HandlerInput inputMock;

    @Before
    public void setup() {
        sut = new NoIdeaIntentHandler();
        inputMock = mock(HandlerInput.class);
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), NoIdeaIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }
    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut);
        assertTrue(response.getOutputSpeech().toString().contains("Kein Problem. Willst du das Wort wiederholen, überspringen oder auflösen?"));
    }
}
