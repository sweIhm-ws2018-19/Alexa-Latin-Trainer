package test.java.latintrainer.model;

import main.java.latintrainer.model.Direction;
import main.java.latintrainer.model.Query;
import main.java.latintrainer.model.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    Session sutOne = new Session();

    @Test
    public void

    @Test
    public void checkGetChapter() {
        assertEquals(1, sutOne.getChapter().getChapterAsInt());
    }


    @Test
    public void checkGetDir() {
        assertEquals(Direction.GERMAN, sutOne.getDir());
    }

    @Test
    public void checkCurrentQuery() {
        Query testQuery = sutOne.getCurrentQuery();

        assertEquals(null, testQuery);
    }


}