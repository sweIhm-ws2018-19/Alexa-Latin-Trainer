package main.java.latintrainer.model;

public class Highscore {
    private final int highscore;

    Highscore(int highscore){
        this.highscore=highscore;
    }

    public int getHighscore() {
        return highscore;
    }

    @Override
    public String toString() {
        return (String.valueOf(highscore));
    }
}
