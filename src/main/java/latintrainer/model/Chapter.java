package main.java.latintrainer.model;

import java.util.Collections;
import java.util.List;

public class Chapter {

    private int chapterNumber;
    private List<Query> queryList;

    public Chapter(int chapter){
        this.chapterNumber =chapter;
        queryList = QueryList.getChapter(chapter);
    }

    public List<Query> getWordsOfThisChapter() {
        return Collections.unmodifiableList(queryList);
    }

    public int getChapterAsInt() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
        queryList = QueryList.getChapter(this.chapterNumber);
    }

    @Override
    public String toString() {
        return (String.valueOf(chapterNumber));
    }

}
