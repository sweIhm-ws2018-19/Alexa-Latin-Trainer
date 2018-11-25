package test.java.latintrainer.model;

import main.java.latintrainer.model.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void firstDirectionIsToGerman() {
        Direction expectedDirection = Direction.GERMAN;
        Direction actualDirection = Direction.values()[0];
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void secondDirectionIsToLatin() {
        Direction expectedDirection = Direction.LATIN;
        Direction actualDirection = Direction.values()[1];
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void thirdDirectionIsRandom() {
        Direction expectedDirection = Direction.RANDOM;
        Direction actualDirection = Direction.values()[2];
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void firstDirectionIsToGermanToString() {
        String expectedDirection = "deutsch";
        String actualDirection = Direction.values()[0].getDirection();
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void secondDirectionIsToLatinToString() {
        String expectedDirection = "lateinisch";
        String actualDirection = Direction.values()[1].getDirection();
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void thirdDirectionIsRandomToString() {
        String expectedDirection = "zufall";
        String actualDirection = Direction.values()[2].getDirection();
        assertEquals(expectedDirection, actualDirection);
    }
}