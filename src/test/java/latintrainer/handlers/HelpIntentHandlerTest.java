package test.java.latintrainer.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import main.java.latintrainer.handlers.HelpIntentHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelpIntentHandlerTest {

    private HelpIntentHandler sut;
    private HandlerInput inputMock;

    @Before
    public void setup() {
        sut = new HelpIntentHandler();
        inputMock = mock(HandlerInput.class);
    }

    @Test
    public void testCtor() {
        assertEquals(sut.getClass(), HelpIntentHandler.class);
    }

    @Test
    public void testCanHandle() {
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(sut.canHandle(inputMock));
    }

    @Test
    public void testHandle() {
        final Response response = TestUtil.standardTestForHandle(sut);

        String speechTextOne = "Danke für das Öffnen von Latein Trainer. Latein Trainer hilft dir, deine lateinischen " +
                "Vokabeln besser zu verinnerlichen. Solltest du mal nicht wissen, wie es weiter geht oder was " +
                "du sagen musst, damit Alexa dich versteht, sage einfach Hilfe und Alexa erklärt dir den nächsten " +
                "Schritt. Außerdem kannst du selber festlegen, wie du abgefragt werden willst. Sage hierfür Konfigurieren" +
                "und Alexa führt dich durch alle Konfigurationsschritte. Zusätzlich kannst du jederzeit deinen Highscore und " +
                "deinen Fortschritt abfragen. Sage dafür einfach Highscore beziehungsweise Fortschritt. Möchtest du die Erfahrung nun beginnen?";

        String speechTextTwo = "Dir wurde soeben ein Wort gesagt, das du übersetzen sollst. Damit deine Antwort " +
                "verarbeitet werden kann musst du sagen: Die Antwort ist Bla Bla. Solltest du die Antwort nicht " +
                "wissen, sage: keine Ahnung. So werden dir auch keine Punkte abgezogen. Du kannst auch jederzeit " +
                "deinen Highscore oder deinen Fortschritt abrufen. Sage dafür einfach Highscore beziehungsweise Fortschritt.";

        String speechTextThree = "Du hast grade eine Antwort gegeben und von Alexa Feedback bekommen. Wenn du die falsche " +
                "Antwort gegeben hast, kannst du dich jetzt zwischen den folgenden Optionen entscheiden: " +
                "Wiederholen gibt dir die Chance, das gleiche Wort nochmal zu beantworten. Überspringen bringt " +
                "dich zur nächsten Abfrage. Auflösen gibt dir die richtige Antwort der zuvor gestellten Abfrage. " +
                "Sage nun Wiederholen, Überspringen oder Auflösen.";

        String speechTextFour = "Wie gerade gesagt, kannst du zwischen den Modi Zufall, Fortschritt und Kapitel wählen. " +
                "Zufall gibt dir eine zufällig generierte Auswahl an Abfragen. Fortschritt macht bei dem Kapitel " +
                "weiter, bei dem du zuletzt aufgehört hast. Kapitel erlaubt dir ein Kapitel auszuwählen, das " +
                "abgefragt werden soll. Damit Alexa dich versteht, musst du zum Beispiel sagen: Wähle Modus Zufall.";

        String speechTextFive = "Nun kannst du deine bevorzugte Übersetzungsrichtung wählen. Willst du lieber, dass Alexa" +
                " die lateinischen Wörter vorsagt und du dann die deutschen Übersetzungen sagen sollst, dann sage: " +
                " Wähle Richtung deutsch. Sollte es dir anders herum lieber sein, sage: Wähle Richtung lateinisch.";

        String speechTextSix = "Latein Trainer hat eine Highscore Funktion, die deine Antworten je nach Richtigkeit mit +2 " +
                "oder -2 Punkten bewertet.";

        String speechTextSeven = "Latein Trainer hat eine Fortschritt Funktion, die dir sagt, in welchem Kapitel du dich " +
                "gerade befindest und wie viele Wörter du aus diesem Kapitel bereits richtig beantwortet hast";

        String speechTextEight = "Danke für das Öffnen von Latein Trainer. Latein Trainer hilft dir, deine lateinischen " +
                "Vokabeln besser zu verinnerlichen. Außerdem kannst du selber festlegen, wie du abgefragt werden " +
                "willst. Zusätzlich kannst du jederzeit deinen Highscore und deinen Fortschritt abfragen. Sage " +
                "dafür einfach Highscore beziehungsweise Fortschritt. Möchtest du die Erfahrung nun beginnen? " +
                "Sage Starte direkt, um loszulegen.";

        assertTrue(response.getOutputSpeech().toString().contains(speechTextOne) ||
                response.getOutputSpeech().toString().contains(speechTextTwo) ||
                response.getOutputSpeech().toString().contains(speechTextThree) ||
                response.getOutputSpeech().toString().contains(speechTextFour) ||
                response.getOutputSpeech().toString().contains(speechTextFive) ||
                response.getOutputSpeech().toString().contains(speechTextSix) ||
                response.getOutputSpeech().toString().contains(speechTextSeven) ||
                response.getOutputSpeech().toString().contains(speechTextEight));
    }

}
