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

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.latintrainer.handlers.NextWordIntentHandler.currentSession;

public class CancelandStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        int thisScore = currentSession.getCurrentHighscore().getHighscoreValue();
        int oldAllTimeHighscore = currentSession.getAllTimeHighscore().getHighscoreValue();

        if (thisScore > oldAllTimeHighscore) {
            AttributesManager attributesManager = input.getAttributesManager();
            Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
            persistentAttributes.put("highscore", Integer.toString(thisScore));
            attributesManager.setPersistentAttributes(persistentAttributes);
            attributesManager.savePersistentAttributes();
        }
        return input.getResponseBuilder()
                .withSpeech(String.format("Du hast diese Session %d Punkte erreicht. Auf Wiedersehen",thisScore))
                .withSimpleCard("LatinTrainerSession", "Auf Wiedersehen")
                .build();
    }
}
