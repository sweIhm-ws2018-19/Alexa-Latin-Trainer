package main.java.latintrainer.model;

public class Highscore {

    private int highscoreValue;

    public Highscore(int highscore){
        this.highscoreValue =highscore;
    }

    public int getHighscoreValue() {
        return highscoreValue;
    }

    public void addToHighscore(int value) {

        highscoreValue = (value+highscoreValue) > 0? value+highscoreValue : 0;
    }

    public void setHighscoreValue(int newScore) {

        highscoreValue = newScore > 0? newScore : 0;
    }

    @Override
    public String toString() {
        return (String.valueOf(highscoreValue));
    }
}
