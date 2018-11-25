package test.java.latintrainer.model;

import main.java.latintrainer.model.Chapter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChapterTest {

    Chapter sut = new Chapter(1);

    @Test
    public void getActualChapter() {
        assertEquals(1, sut.getChapterAsInt());
    }

    @Test
    public void changeChapter() {
        sut.setChapter(2);
        assertEquals(2, sut.getChapterAsInt());
    }

    @Test
    public void getChapterAsString() {
        assertEquals("1", sut.toString());
    }

}