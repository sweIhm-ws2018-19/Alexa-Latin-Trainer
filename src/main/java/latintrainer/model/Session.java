package main.java.latintrainer.model;


public class Session {
    private Direction dir;
    private Mode mode;
    private Chapter chapter;
    private Highscore currentHighscore = new Highscore(0);
    private Highscore allTimeHighscore;
    private int index;

    public Session(Direction dir, Mode mode, int chapter, int highscore) {
        this.dir = dir;
        this.mode = mode;
        this.chapter = new Chapter(chapter);
        this.allTimeHighscore = new Highscore(highscore);
    }

    public void incrementChapter() {
        this.chapter.setChapterNumber(this.chapter.getChapterAsInt()+1);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Chapter getChapter() {
        return chapter;
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

    @Override
    public String toString() {
        return "Richtung: " + dir + "; Modus: " + mode + "; Highscore: " + currentHighscore
                + "; Kapitel: " + chapter;
    }
}