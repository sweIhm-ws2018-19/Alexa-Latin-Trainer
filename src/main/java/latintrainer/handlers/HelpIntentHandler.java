/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.java.latintrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import static main.java.latintrainer.LatinTrainerStreamHandler.CURRENT_SESSION;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;
        String repromptText;
        switch (CURRENT_SESSION.getCurrentHandler()) {
            case "Launch":
                repromptText = "Sage Starte direkt, um loszulegen.";
                speechText = "Danke für das Öffnen von Latein Trainer. Latein Trainer hilft dir, deine lateinischen " +
                        "Vokabeln besser zu verinnerlichen. Außerdem kannst du selber festlegen, wie du abgefragt werden " +
                        "willst. Zusätzlich kannst du jederzeit deinen Highscore und deinen Fortschritt abfragen. Sage " +
                        "dafür einfach Highscore beziehungsweise Fortschritt. Möchtest du die Erfahrung nun beginnen? " +
                        repromptText;
                break;
            case "NextWord":
                speechText = "Dir wurde soeben ein Wort gesagt, das du übersetzen sollst. Damit deine Antwort " +
                        "verarbeitet werden kann musst du sagen: Die Antwort ist Bla Bla. Solltest du die Antwort nicht " +
                        "wissen, sage: keine Ahnung. So werden dir auch keine Punkte abgezogen.";
                repromptText = "Sage: Die Antwort ist Bla Bla.";
                break;
            case "CheckAnswer":
                speechText = "Du hast grade eine Antwort gegeben und von Alexa Feedback bekommen. Wenn du die falsche " +
                        "Antwort gegeben hast, kannst du dich jetzt zwischen den folgenden Optionen entscheiden: " +
                        "Wiederholen gibt dir die Chance, das gleiche Wort nochmal zu beantworten. Überspringen bringt " +
                        "dich zur nächsten Abfrage. Auflösen gibt dir die richtige Antwort der zuvor gestellten Abfrage. " +
                        "Sage nun Wiederholen, Überspringen oder Auflösen.";
                repromptText = "Sage Wiederholen, Überspringen oder Auflösen.";
                break;
            case "SetConfig":
                speechText = "Wie gerade gesagt, kannst du zwischen den Modi Zufall, Fortschritt und Kapitel wählen. " +
                        "Zufall gibt dir eine zufällig generierte Auswahl an Abfragen. Fortschritt macht bei dem Kapitel " +
                        "weiter, bei dem du zuletzt aufgehört hast. Kapitel erlaubt dir ein Kapitel auszuwählen, das " +
                        "abgefragt werden soll. Damit Alexa dich versteht, musst du zum Beispiel sagen: Wähle Modus Zufall.";
                repromptText = "Sage zum Beispiel: Wähle Modus Zufall";
                break;
            case "SetMode":
                speechText = "Nun kannst du deine bevorzugte Übersetzungsrichtung wählen. Willst du lieber, dass Alexa" +
                        " die lateinischen Wörter vorsagt und du dann die deutschen Übersetzungen sagen sollst, dann sage: " +
                        " Wähle Richtung deutsch. Sollte es dir anders herum lieber sein, sage: Wähle Richtung lateinisch.";
                repromptText = "Sage Wähle Richtung deutsch oder lateinisch";
                break;
            case "Highscore":
                speechText = "Latein Trainer hat eine Highscore Funktion, die deine Antworten je nach Richtigkeit mit +2 " +
                        "oder -2 Punkten bewertet.";
                repromptText = "Sage neues Wort, um weiterzumachen.";
                break;
            case "Success":
                speechText = "Latein Trainer hat eine Fortschritt Funktion, die dir sagt, in welchem Kapitel du dich " +
                        "gerade befindest und wie viele Wörter du aus diesem Kapitel bereits richtig beantwortet hast";
                repromptText = "Sage neues Wort, um weiterzumachen.";
                break;
            default:
                speechText = "Danke für das Öffnen von Latein Trainer. Latein Trainer hilft dir, deine lateinischen " +
                        "Vokabeln besser zu verinnerlichen. Außerdem kannst du selber festlegen, wie du abgefragt werden " +
                        "willst. Zusätzlich kannst du jederzeit deinen Highscore und deinen Fortschritt abfragen. Sage " +
                        "dafür einfach Highscore beziehungsweise Fortschritt. Möchtest du die Erfahrung nun beginnen? " +
                        "Sage Starte direkt, um loszulegen.";
                repromptText = "Sage Starte die Demo, um loszulegen.";
        }

        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
