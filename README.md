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

Now it’s time to add an intent to the skill. Click the “Add” button under the Intents section of the Interaction Model. Leave “Create custom intent” selected, enter “SetModeIntentHandler” for the intent name, and create the intent. Now it’s time to add some sample utterances that will be used to invoke the intent. For this example, we’ve provided the following sample utterances, but feel free to add others.


## Anleitung
Nachdem der Skill gestartet wird und bevor die Abfrage der Vokabeln beginnt, werden dem User Fragen zur Konfiguration gestellt.

Beispiele für Spracheingaben durch den User:
- Starten des Skills: "Alexa, lerne Latein mit mir"
- Modusauswahl: "Fortschritt" oder "Zufall"
- Vokabelabfrage: bei richtigen Antworten wird sofort die nächste Abfrage eingeleitet, bei nicht richtigen Antworten hat der User die Möglichkeit die aktuelle Vokabel zu "wiederholen", zu "überspringen" oder "auflösen" zu lassen
- Abfrage des Fortschritts: "Wo bin ich stehen geblieben?"
- Skill beenden: "Ende" -> Alexa sagt den Highscore der aktuellen Session an und verabschiedet sich

