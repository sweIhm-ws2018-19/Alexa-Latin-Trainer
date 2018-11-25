package main.java.latintrainer.model;

public class Highscore {
    private int highscore;

    public Highscore(int highscore){
        this.highscore=highscore;
    }

    public int getHighscore() {
        return highscore;
    }

    public void addToHighscore(int value) {
        highscore += value;
    }

    public void setHighscore(int newScore) {
        highscore = newScore;
    }

    @Override
    public String toString() {
        return (String.valueOf(highscore));
    }
}
