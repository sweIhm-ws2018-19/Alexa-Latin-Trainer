package test.java.latintrainer.model;

import main.java.latintrainer.model.Direction;
import main.java.latintrainer.model.Mode;
import main.java.latintrainer.model.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    private Session sut = new Session();

    @Test
    public void setFirstChapter() {
        sut.setChapter(0);
        int expectedChapter = 0;
        assertEquals(expectedChapter, sut.getChapter().getChapterAsInt());
    }

    @Test
    public void setThirdChapter() {
        sut.setChapter(2);
        int expectedChapter = 2;
        assertEquals(expectedChapter, sut.getChapter().getChapterAsInt());
    }

    @Test
    public void setModeToRandom() {
        sut.setMode(Mode.RANDOM);
        Mode expected = Mode.RANDOM;
        assertEquals(expected, sut.getMode());
    }

    @Test
    public void setModeToChapter() {
        sut.setMode(Mode.CHAPTER);
        Mode expected = Mode.CHAPTER;
        assertEquals(expected, sut.getMode());
    }

    @Test
    public void setModeToProgress() {
        sut.setMode(Mode.PROGRESS);
        Mode expected = Mode.PROGRESS;
        assertEquals(expected, sut.getMode());
    }

    @Test
    public void setDirectionToLatin() {
        sut.setDir(Direction.LATIN);
        Direction expected = Direction.LATIN;
        assertEquals(expected, sut.getDir());
    }

    @Test
    public void setDirectionToRandom() {
        sut.setDir(Direction.RANDOM);
        Direction expected = Direction.RANDOM;
        assertEquals(expected, sut.getDir());
    }

    @Test
    public void setDirectionToGerman() {
        sut.setDir(Direction.GERMAN);
        Direction expected = Direction.GERMAN;
        assertEquals(expected, sut.getDir());
    }

    @Test
    public void sessionChangingFalse() {
        sut.setIsChangingSession(false);
        assertFalse(sut.isChangingSession());
    }

    @Test
    public void sessionChangingTrue() {
        sut.setIsChangingSession(true);
        assertTrue(sut.isChangingSession());
    }

    @Test
    public void sessionChangingTrueFalse() {
        sut.setIsChangingSession(true);
        boolean beforeSwitch = sut.isChangingSession();
        sut.setIsChangingSession(false);
        boolean afterSwitch = sut.isChangingSession();
        assertTrue(beforeSwitch && !afterSwitch);
    }

    @Test
    public void sessionChangingFalseTrue() {
        sut.setIsChangingSession(false);
        boolean beforeSwitch = sut.isChangingSession();
        sut.setIsChangingSession(true);
        boolean afterSwitch = sut.isChangingSession();
        assertFalse(beforeSwitch && !afterSwitch);
    }

    @Test
    public void firstWordChapterOneAsCurrentWordToGerman() {
        sut.setDir(Direction.GERMAN).setChapter(0).setMode(Mode.PROGRESS).setAllTimeHighscore(0);
        String expected = "Haus";
        assertEquals(expected, sut.getCurrentWord().getGermanWord());
    }

    @Test
    public void firstWordChapterOneAsCurrentWordToLatin() {
        sut.setDir(Direction.LATIN).setChapter(0).setMode(Mode.PROGRESS).setAllTimeHighscore(0);
        String expected = "Domus";
        assertEquals(expected, sut.getCurrentWord().getLatinWord());
    }

    @Test
    public void lastWordChapterOneAsCurrentWordToLatin() {
        sut.setDir(Direction.LATIN).setChapter(0).setMode(Mode.PROGRESS).setAllTimeHighscore(0);
        for(int i = 0; i < 19; i++) {
            sut.nextQuery();
            sut.answeredCorrectly();
        }

        String expected = "Lex";

        assertEquals(expected, sut.nextQuery().getLatinWord());
    }

    @Test
    public void chapterSwitchFromFirstToSecondChapterFirstWordToLatin() {
        sut.setDir(Direction.LATIN).setChapter(0).setMode(Mode.PROGRESS).setAllTimeHighscore(0);
        for(int i = 0; i < 20; i++) {
            sut.nextQuery();
            sut.answeredCorrectly();
        }

        String expected = "facere";

        assertEquals(expected, sut.nextQuery().getLatinWord());
    }

    @Test
    public void chapterSwitchFromSecondToThirdChapterWithDirectionFromLatinToGerman() {
        sut.setDir(Direction.LATIN).setChapter(1).setMode(Mode.PROGRESS).setAllTimeHighscore(0);
        for(int i = 0; i < 19; i++) {
            sut.nextQuery();
            sut.answeredCorrectly();
        }
        String lastWordChapTwoLatin = sut.nextQuery().getLatinWord();
        sut.answeredCorrectly();
        sut.setDir(Direction.GERMAN);
        String firstWordChapThreeGerman = sut.nextQuery().getGermanWord();

        boolean expectedOne = lastWordChapTwoLatin.equalsIgnoreCase("totus");
        boolean expectedTwo = firstWordChapThreeGerman.equalsIgnoreCase("glauben");

        assertTrue(expectedOne && expectedTwo);
        }


}