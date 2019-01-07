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

    @Test
    public void setHighscoreToZero() {
        sut.setHighscoreValue(0);

        int expected = 0;

        assertEquals(expected, sut.getHighscoreValue());
    }

    @Test
    public void setMinusHighscore() {
        sut.setHighscoreValue(-10);

        int expected = 0;

        assertEquals(expected, sut.getHighscoreValue());
    }

    @Test
    public void addHighscore() {
        sut.setHighscoreValue(10);
        sut.addToHighscore(10);

        int expected = 20;

        assertEquals(expected, sut.getHighscoreValue());
    }

}