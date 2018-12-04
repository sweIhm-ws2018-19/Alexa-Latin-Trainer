package main.java.latintrainer.model;

public class Chapter {

    private int chapterNumber;

    public Chapter(int chapter){
        this.chapterNumber =chapter;
    }

    public int getChapterAsInt() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    @Override
    public String toString() {
        return (String.valueOf(chapterNumber));
    }

}
