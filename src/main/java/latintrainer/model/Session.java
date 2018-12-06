package main.java.latintrainer.model;


import java.util.List;
import java.util.Random;

public class Session {
    private Direction dir;
    private Mode mode;
    private int chapter;
    private List<Query> wordList;
    private int currentWordIndex;
    private Highscore currentHighscore = new Highscore(0);
    private Highscore allTimeHighscore;

    public Session(Direction dir, Mode mode, int chapter, int highscore) {
        this.dir = dir;
        this.mode = mode;
        this.allTimeHighscore = new Highscore(highscore);
        this.chapter = chapter;
        wordList = QueryList.getChapter(chapter);
        currentWordIndex = 0;
    }

    public Query getCurrentWord(int... index) {
        Query result;
        if(index.length == 0) {
            currentWordIndex = mode == Mode.RANDOM?  new Random().nextInt(20) : currentWordIndex+1;
            result = wordList.get(currentWordIndex);
        }
        else
            result = wordList.get(index[0]);

        return result;
    }

    public Direction getDir() {
        return dir;
    }

    public Highscore getCurrentHighscore() {
        return currentHighscore;
    }

    public Highscore getAllTimeHighscore() {
        return allTimeHighscore;
    }

    public Mode getMode() {
        return mode;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setChapter(int index) { chapter = index;   }

    public void setAllTimeHighscore(int highscore) {
        this.allTimeHighscore = new Highscore(highscore);
    }

    @Override
    public String toString() {
        return "Richtung: " + dir + "; Modus: " + mode + "; Highscore: " + currentHighscore
                + "; Kapitel: " + chapter;
    }
}