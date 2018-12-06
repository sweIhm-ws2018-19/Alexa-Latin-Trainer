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
    private boolean[] alreadyAsked;
    private boolean[] answeredCorrectly;


    public Session() {
        currentWordIndex = -1;
        alreadyAsked = new boolean[20];
        answeredCorrectly = new boolean[20];
    }

    public Session(Direction dir, Mode mode, int chapter, int highscore) {
        this.dir = dir;
        this.mode = mode;
        this.allTimeHighscore = new Highscore(highscore);
        this.chapter = chapter;
        wordList = QueryList.getChapter(chapter);
        currentWordIndex = -1;
        alreadyAsked = new boolean[20];
        answeredCorrectly = new boolean[20];
    }

    public Query getCurrentWord() {
            currentWordIndex = mode == Mode.RANDOM?  new Random().nextInt(wordList.size()) : (currentWordIndex+1)%wordList.size();
            int savePoint = currentWordIndex;
            Query result = checkForNextUnasked(currentWordIndex);

            if(result == null)
                result = checkForNextFailed(savePoint);

            if(result == null) {
                chapter++;
                wordList = QueryList.getChapter(chapter);
                currentWordIndex = 0;
                alreadyAsked = new boolean[wordList.size()];
                answeredCorrectly = new boolean[wordList.size()];
                result = getCurrentWord();
            }
        return result;
    }

    public void answeredCorrectly() {
        answeredCorrectly[currentWordIndex] = true;
    }

    private Query checkForNextUnasked(int index) {
        return findSpecificQuery(alreadyAsked, index, true);
    }

    private Query checkForNextFailed(int index) {
        return findSpecificQuery(answeredCorrectly, index, false);
    }

    private Query findSpecificQuery(boolean[] arr, int index, boolean flag) {
        int i = index;
        int counter = 0;
        while(arr[i] || counter < wordList.size()) {
            i = (i+1)%wordList.size();
            counter++;
        }
        currentWordIndex = i;

        // flag for setting the allreadyAskedArray on index i to true
        if(flag)
            arr[i] = true;

        return counter < wordList.size()? wordList.get(i) : null;
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

    public void setChapter(int index) { chapter = index; }


    public void setAllTimeHighscore(int highscore) {
        this.allTimeHighscore = new Highscore(highscore);
    }

    @Override
    public String toString() {
        return "Richtung: " + dir + "; Modus: " + mode + "; Highscore: " + currentHighscore
                + "; Kapitel: " + chapter;
    }
}