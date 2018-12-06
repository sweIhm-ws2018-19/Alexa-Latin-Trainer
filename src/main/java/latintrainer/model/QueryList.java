package main.java.latintrainer.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryList {

    /**
     *  Private constructor to hide implicit public one.
     */
    private QueryList() {}

    public static List<Query> getChapter(int index) {
        return new QueryList().wordsForChapter(index);
    }

    private final List<Query> CHAPTER_ONE = DUMMY_CHAPTER;

    private final List<Query> CHAPTER_TWO = DUMMY_CHAPTER;

    private final List<Query> CHAPTER_THREE = DUMMY_CHAPTER;

    private final List<Query> CHAPTER_FOUR = DUMMY_CHAPTER;

    private final List<Query> CHAPTER_FIVE = DUMMY_CHAPTER;

    private final List<Query> CHAPTER_SIX = DUMMY_CHAPTER;

    private static final List<Query> DUMMY_CHAPTER = Arrays.asList(
            new Query(0, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(2, "Amicus","Freund"),
            new Query(3, "amare","lieben"),
            new Query(4, "Montis","Berg"),
            new Query(5, "videre","sehen"),
            new Query(6, "Magister","Lehrer"),
            new Query(7, "Studium","Eifer"),
            new Query(8, "ius","Recht"),
            new Query(9, "ante","vor"),
            new Query(10, "mandare","anvertrauen"),
            new Query(11, "fortis","tapfer"),
            new Query(12, "conari","versuchen"),
            new Query(13, "redire","zurueckkehren"),
            new Query(14, "bene","gut"),
            new Query(15, "gravis","schwer"),
            new Query(16, "tantum","nur"),
            new Query(17, "venire","kommen"),
            new Query(18, "Verbum","Wort"),
            new Query(19, "Lex","Gesetz"));

    List<List<Query>> queries = Arrays.asList(CHAPTER_ONE, CHAPTER_TWO, CHAPTER_THREE, CHAPTER_FOUR, CHAPTER_FIVE, CHAPTER_SIX);

    private List<Query> wordsForChapter(int index) {
        return queries.get(index%queries.size()).stream().collect(Collectors.toList());
    }

}
