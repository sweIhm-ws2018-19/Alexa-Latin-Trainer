package test.java.latintrainer.model;

import main.java.latintrainer.model.Highscore;
import org.junit.Test;

import static org.junit.Assert.*;

public class HighscoreTest {

    Highscore sut = new Highscore(9000);

    @Test
    public void checkHighscore() {
        assertEquals(9000, sut.getHighscoreValue());
    }

    @Test
    public void checkHighscoreAsString() {
        assertEquals("9000", sut.toString());
    }

}