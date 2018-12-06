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
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static com.amazon.ask.request.Predicates.requestType;


public class LaunchRequestHandler implements RequestHandler {

    public static final String MODE_SLOT = "mode";
//    public static Session currentSession;
//
//    private static final Logger log = Logger.getLogger(LaunchRequestHandler.class.getName());
//
//    static {
//        try {
//            currentSession = new Session();
//        } catch (IOException e) {
//            log.info("!!!Session could not be created!!!");
//        }
//    }

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
<<<<<<< HEAD
        String speechText = "Hallo. Ich bin Dein Latein Trainer. Sage Fortschritt, um deinen letzten Speicherstand zu laden,"+
                " Zufall für eine beliebige Abfrage oder Hilfe um Zusatzinformationen zu bekommen.";
        String repromptText = "Bitte sage Fortschritt oder Zufall, um zu beginnen.";
=======
        String speechText = "Hallo. Ich bin Dein Latein Trainer. Sage Starte direkt, um mit deinen Standard " +
                "Einstellungen zu beginnen, oder Konfigurieren, um deine Abfrage Einstellungen zu aendern.";
        String repromptText = "Bitte sage Starte die Demo oder Hilfe.";
>>>>>>> 71ca4bde6cbacae9187b063083e274eb1aac4d60
        return input.getResponseBuilder()
                .withSimpleCard("LatinTrainerSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .build();
    }
}
