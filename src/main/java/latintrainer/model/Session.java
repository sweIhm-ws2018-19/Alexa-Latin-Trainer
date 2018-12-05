package main.java.latintrainer.model;


public class Session {
    private Direction dir;
    private Mode mode;
    private Chapter chapter;
    private Highscore currentHighscore = new Highscore(0);
    private Highscore allTimeHighscore;

    public Session(Direction dir, Mode mode, int chapter, int highscore) {
        this.dir = dir;
        this.mode = mode;
        this.chapter = new Chapter(chapter);
        this.allTimeHighscore = new Highscore(highscore);
    }

    public void incrementChapter() {
        this.chapter.setChapterNumber(this.chapter.getChapterAsInt()+1);
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

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setCurrentHighscore(Highscore currentHighscore) {
        this.currentHighscore = currentHighscore;
    }

    @Override
    public String toString() {
        return "Richtung: " + dir + "; Modus: " + mode + "; Highscore: " + currentHighscore
                + "; Kapitel: " + chapter;
    }
}