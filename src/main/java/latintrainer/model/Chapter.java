package main.java.latintrainer.model;

public class Chapter {

    private int chapter;

    public Chapter(int chapter){
        this.chapter=chapter;
    }

    public int getChapterAsInt() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return (String.valueOf(chapter));
    }

}
