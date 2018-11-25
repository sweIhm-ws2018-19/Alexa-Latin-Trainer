package test.java.latintrainer.model;

import main.java.latintrainer.model.Mode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModeTest {

    @Test
    public void firstModeIsProgress() {
        Mode expectedMode = Mode.PROGRESS;
        Mode actualMode = Mode.values()[0];
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void secondModeIsRandom() {
        Mode expectedMode = Mode.RANDOM;
        Mode actualMode = Mode.values()[1];
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void thirdModeIsRandom() {
        Mode expectedMode = Mode.CHAPTER;
        Mode actualMode = Mode.values()[2];
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void firstModeIsProgressAsString() {
        String expectedMode = "Fortschritt";
        String actualMode = Mode.values()[0].getMode();
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void secondModeIsRandomAsString() {
        String expectedMode = "Zufall";
        String actualMode = Mode.values()[1].getMode();
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void thirdModeIsRandomAsString() {
        String expectedMode = "Kapitel";
        String actualMode = Mode.values()[2].getMode();
        assertEquals(expectedMode, actualMode);
    }
}