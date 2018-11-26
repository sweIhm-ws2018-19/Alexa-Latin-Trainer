package test.java.latintrainer.model;

import main.java.latintrainer.model.Query;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryTest {

    Query sut = new Query(1,"domus", "Haus", 2);

    @Test
    public void checkRatingValue() {
        assertEquals(2, sut.getRating());
    }

    @Test
    public void checkLatinTranslation() {
        assertEquals("domus", sut.getLatinWord());
    }

    @Test
    public void checkGermanTranslation() {
        assertEquals("Haus", sut.getGermanWord());
    }
}