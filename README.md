# Alexa Skill - Latein Trainer 
Eine [AWS Lambda](http://aws.amazon.com/lambda) Funktion, mit der man lateinische Vokabeln üben kann. 

## Features
- Auswahl der Übersetzungsrichtung (Latein-Deutsch oder Deutsch-Latein)
- Auswahl aus verschiedenen Modi (Fortschritt und Zufall)
- Ermittlung des Lernerfolgs durch Punktesystem

## Anleitung
Nachdem der Skill gestartet wird und bevor die Abfrage der Vokabeln beginnt, werden dem User Fragen zur Konfiguration gestellt.

Beispiele für Spracheingaben durch den User:
- Starten des Skills: "Alexa, lerne Latein mit mir"
- Modusauswahl: "Fortschritt" oder "Zufall"
- Vokabelabfrage: bei richtigen Antworten wird sofort die nächste Abfrage eingeleitet, bei nicht richtigen Antworten hat der User die Möglichkeit die aktuelle Vokabel zu "wiederholen", zu "überspringen" oder "auflösen" zu lassen
- Abfrage des Fortschritts: "Wo bin ich stehen geblieben?"
- Skill beenden: "Ende" -> Alexa sagt den Highscore der aktuellen Session an und verabschiedet sich

