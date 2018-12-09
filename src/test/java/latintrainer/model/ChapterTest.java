package test.java.latintrainer.model;

import main.java.latintrainer.model.Chapter;
import main.java.latintrainer.model.Query;
import main.java.latintrainer.model.QueryList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChapterTest {

    Chapter sut = new Chapter(1);

    @Test
    public void getActualChapter() {
        assertEquals(1, sut.getChapterAsInt());
    }

    @Test
    public void changeChapter() {
        sut.setChapterNumber(2);
        assertEquals(2, sut.getChapterAsInt());
    }

    @Test
    public void getChapterAsString() {
        assertEquals("1", sut.toString());
    }

    @Test
    public void queriesOfChapterOne() {
        sut.setChapterNumber(0);
        List<Query> queries = new ArrayList<>();
        for(int i = 0; i < sut.getWordsOfThisChapter().size(); i++)
            queries.add(sut.getWordsOfThisChapter().get(i));

        List<Query> expected = QueryList.getChapter(0);

        assertTrue(expected.containsAll(queries));
    }

    @Test
    public void queriesOfChapterTwo() {
        sut.setChapterNumber(1);
        List<Query> queries = new ArrayList<>();
        for(int i = 0; i < sut.getWordsOfThisChapter().size(); i++)
            queries.add(sut.getWordsOfThisChapter().get(i));

        List<Query> expected = QueryList.getChapter(1);

        assertTrue(expected.containsAll(queries));
    }

    @Test
    public void queriesOfChapterThree() {
        sut.setChapterNumber(2);
        List<Query> queries = new ArrayList<>();
        for(int i = 0; i < sut.getWordsOfThisChapter().size(); i++)
            queries.add(sut.getWordsOfThisChapter().get(i));

        List<Query> expected = QueryList.getChapter(2);

        assertTrue(expected.containsAll(queries));
    }

}