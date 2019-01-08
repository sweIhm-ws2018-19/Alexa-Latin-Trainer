# Alexa Skill - Latein Trainer - Latintrainer
 
Eine [AWS Lambda](http://aws.amazon.com/lambda) Funktion, mit der man lateinische Vokabeln üben kann. 

## Features
- Auswahl der Übersetzungsrichtung (Latein-Deutsch oder Deutsch-Latein)
- Auswahl aus verschiedenen Modi (Fortschritt, Zufall und Kapitel)
- Ermittlung des Lernerfolgs durch Punktesystem

## Setup
To run this skill you need to do two things. The first is to deploy the example code in lambda, and the second is to configure the Alexa skill to use Lambda.

### AWS Lambda Setup
Refer to [Hosting a Custom Skill as an AWS Lambda Function](https://developer.amazon.com/de/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html) reference for a walkthrough on creating a AWS Lambda function with the correct role for your skill. When creating the function, select the “Author from scratch” option, and select the Java 8 runtime.

To build the sample, open a terminal and go to the directory containing pom.xml, and run 'mvn org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package'. This will generate a zip file named "latintrainer-1.0-jar-with-dependencies.jar" in the target directory.

Once you've created your AWS Lambda function and configured “Alexa Skills Kit” as a trigger, upload the JAR file produced in the previous step and set the handler to the fully qualified class name of your handler function. Finally, copy the ARN for your AWS Lambda function because you’ll need it when configuring your skill in the Amazon Developer console.

### Alexa Skill Setup
Now that the skill code has been uploaded to AWS Lambda we're ready to configure the skill with Alexa. First, navigate to the [Alexa Skills Kit Developer Console](https://developer.amazon.com/alexa/console/ask?). Click the “Create Skill” button in the upper right. Enter “LatinTrainer” as your skill name. On the next page, select “Custom” and click “Create skill”.

Now we're ready to define the interaction model for the skill. Under “Invocation” tab on the left side, define your Skill Invocation Name to be Latintrainer.

Now it’s time to add an intent to the skill. Click the “Add” button under the Intents section of the Interaction Model. Leave “Create custom intent” selected, enter “SetConfigIntent” for the intent name, and create the intent. Now it’s time to add some sample utterances that will be used to invoke the intent. For this example, we’ve provided the following sample utterances, but feel free to add others.
```
Konfigurieren
Settings
Einstellungen
```
Now we need to add some Intents to configure the skill. There are three more Intents concerning configuration options.
"SetModeIntent" with the utterances:
```
Waehle Modus {mode}
```
Let's add a Slot Type. You can find it below Built-In Intents.Click "Add Slot Type" and under "Create custom slot type", enter the name as "LIST_OF_MODES". Add below values one at a time for this slot type.
```
Kapitel
Fortschritt
Zufall
```
Second configuration option is triggered with the "SetDirectionIntent".
```
Waehle Richtung {dir}
```
It has an own Slot Type named "List_OF_DIRS" containing the values:
```
Deutsch
Lateinisch
```
Finally you can choose the chapter to start with by triggering "SetChapterIntent".
```
Waehle Kapitel {chap}
```
Create a slot "chap" and select AMAZON.NUMBER als Slot Type.

In de_DE.json model-file there are more intents listed. You must create utterances but don't need any special Slot Types.

Since AMAZON.CancelIntent, AMAZON.HelpIntent, and AMAZON.StopIntent are built-in Alexa intents, sample utterances do not need to be provided as they are automatically inherited.

The Developer Console alternately allows you to edit the entire skill model in JSON format by selecting “JSON Editor” on the navigation bar. For this sample, the following JSON schema can be used.
```
{
    "interactionModel": {
        "languageModel": {
            "invocationName": "lateintrainer",
            "intents": [
                {
                    "name": "AMAZON.CancelIntent",
                    "samples": []
                },
                {
                    "name": "AMAZON.HelpIntent",
                    "samples": []
                },
                {
                    "name": "AMAZON.StopIntent",
                    "samples": []
                },
                {
                    "name": "SetModeIntent",
                    "slots": [
                        {
                            "name": "mode",
                            "type": "LIST_OF_MODES"
                        }
                    ],
                    "samples": [
                        "Waehle Modus {mode}",
                        "Modus {mode}"
                    ]
                },
                {
                    "name": "SetDirectionIntent",
                    "slots": [
                        {
                            "name": "dir",
                            "type": "LIST_OF_DIRS"
                        }
                    ],
                    "samples": [
                        "Waehle Richtung {dir}",
                        "Richtung {dir}",
                        "{dir}"
                    ]
                },
                {
                    "name": "SetConfigIntent",
                    "slots": [],
                    "samples": [
                        "Konfigurieren",
                        "Einstellungen",
                        "config",
                        "Settings",
                        "Session bearbeiten"
                    ]
                },
                {
                    "name": "NextWordIntent",
                    "slots": [],
                    "samples": [
                        "Starte direkt",
                        "Neues Wort",
                        "Ueberspringen",
                        "Next"
                    ]
                },
                {
                    "name": "CheckAnswerIntent",
                    "slots": [
                        {
                            "name": "Answer",
                            "type": "LIST_OF_ANSWERS"
                        }
                    ],
                    "samples": [
                        "Die Antwort ist {Answer}",
                        "check {Answer}"
                    ]
                },
                {
                    "name": "NoIdeaIntent",
                    "slots": [],
                    "samples": [
                        "weiß nicht",
                        "keine Ahnung",
                        "kein Plan"
                    ]
                },
                {
                    "name": "TellMeIntent",
                    "slots": [],
                    "samples": [
                        "Auflösen",
                        "Sags mir"
                    ]
                },
                {
                    "name": "WhatsMySuccessIntent",
                    "slots": [],
                    "samples": [
                        "Wie ist mein Fortschritt",
                        "In welchem Kapitel bin ich",
                        "Wie stehe ich",
                        "Wo stehe ich",
                        "Welches Kapitel",
                        "Fortschritt"
                    ]
                },
                {
                    "name": "RepeatWordIntent",
                    "slots": [],
                    "samples": [
                        "Wiederholen",
                        "Nochmal",
                        "Wie bitte"
                    ]
                },
                {
                    "name": "WhatsMyHighscoreIntent",
                    "slots": [],
                    "samples": [
                        "Punktestand",
                        "Wie viele Punkte hab ich gerade",
                        "Was ist mein Highscore",
                        "Highscore"
                    ]
                },
                {
                    "name": "AMAZON.PauseIntent",
                    "samples": []
                },
                {
                    "name": "AMAZON.ResumeIntent",
                    "samples": []
                },
                {
                    "name": "SetChapterIntent",
                    "slots": [
                        {
                            "name": "chap",
                            "type": "AMAZON.NUMBER"
                        }
                    ],
                    "samples": [
                        "waehle Kapitel {chap}",
                        "Kapitel {chap}"
                    ]
                },
                {
                    "name": "AMAZON.NavigateHomeIntent",
                    "samples": []
                }
            ],
            "types": [
                {
                    "name": "LIST_OF_ANSWERS",
                    "values": [
                        {
                            "name": {
                                "value": "Sonne"
                            }
                        },
                        {
                            "name": {
                                "value": "Haus"
                            }
                        },
                        {
                            "name": {
                                "value": "Freund"
                            }
                        },
                        {
                            "name": {
                                "value": "Lehrer"
                            }
                        },
                        {
                            "name": {
                                "value": "Eifer"
                            }
                        },
                        {
                            "name": {
                                "value": "lieben"
                            }
                        },
                        {
                            "name": {
                                "value": "vor"
                            }
                        },
                        {
                            "name": {
                                "value": "Berg"
                            }
                        },
                        {
                            "name": {
                                "value": "Wort"
                            }
                        },
                        {
                            "name": {
                                "value": "Recht"
                            }
                        },
                        {
                            "name": {
                                "value": "Gesetz"
                            }
                        },
                        {
                            "name": {
                                "value": "anvertrauen"
                            }
                        },
                        {
                            "name": {
                                "value": "tapfer"
                            }
                        },
                        {
                            "name": {
                                "value": "versuchen"
                            }
                        },
                        {
                            "name": {
                                "value": "zurückkehren"
                            }
                        },
                        {
                            "name": {
                                "value": "gut"
                            }
                        },
                        {
                            "name": {
                                "value": "schwer"
                            }
                        },
                        {
                            "name": {
                                "value": "nur"
                            }
                        },
                        {
                            "name": {
                                "value": "kommen"
                            }
                        },
                        {
                            "name": {
                                "value": "sehen"
                            }
                        }
                    ]
                },
                {
                    "name": "LIST_OF_DIRS",
                    "values": [
                        {
                            "name": {
                                "value": "Deutsch"
                            }
                        },
                        {
                            "name": {
                                "value": "Lateinisch"
                            }
                        }
                    ]
                },
                {
                    "name": "LIST_OF_MODES",
                    "values": [
                        {
                            "name": {
                                "value": "Zufall"
                            }
                        },
                        {
                            "name": {
                                "value": "Fortschritt"
                            }
                        },
                        {
                            "name": {
                                "value": "Kapitel"
                            }
                        }
                    ]
                }
            ]
        }
    }
}
```


Once you’re done editing the interaction model don't forget to save and build the model.

Let's move on to the skill configuration section. Under “Endpoint” select “AWS Lambda ARN” and paste in the ARN of the function you created previously. The rest of the settings can be left at their default values. Click “Save Endpoints” and proceed to the next section.

Finally you're ready to test the skill! In the “Test” tab of the developer console you can simulate requests, in text and voice form, to your skill. Use the invocation name along with one of the sample utterances we just configured as a guide. You should also be able to go to the [Echo webpage](https://alexa.amazon.de/spa/index.html#welcome) and see your skill listed under “Your Skills”, where you can enable the skill on your account for testing from an Alexa enabled device.

At this point, feel free to start experimenting with your Intent Schema as well as the corresponding request handlers in your skill's implementation. Once you're finished iterating, you can optionally choose to move on to the process of getting your skill certified and published so it can be used by Alexa users worldwide.
