/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.java.latintrainer;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import main.java.latintrainer.handlers.*;

public class LatinTrainerStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new SetModeIntentHandler(),
                        new SetDirectionIntentHandler(),
                        new SetConfigIntentHandler(),
                        new NextWordIntentHandler(),
                        new CheckAnswerIntentHandler(),
                        new NoIdeaIntentHandler(),
                        new TellMeIntentHandler(),
                        new WhatsMySuccessIntentHandler(),
                        new RepeatWordIntentHandler(),
                        new WhatsMyHighscoreIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler())
                .withTableName("LateinTrainerData")
                .withAutoCreateTable(true)
                //.withSkillId("")
                .build();
    }

    public LatinTrainerStreamHandler() {
        super(getSkill());
    }

}
