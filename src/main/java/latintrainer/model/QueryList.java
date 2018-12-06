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

    private final List<Query> CHAPTER_ONE = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    private final List<Query> CHAPTER_TWO = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    private final List<Query> CHAPTER_THREE = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    private final List<Query> CHAPTER_FOUR = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    private final List<Query> CHAPTER_FIVE = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    private final List<Query> CHAPTER_SIX = Arrays.asList(
            new Query(1, "Domus","Haus"),
            new Query(1, "Sol","Sonne"),
            new Query(1, "Amicus","Freund"),
            new Query(1, "amare","lieben"),
            new Query(1, "Montis","Berg"),
            new Query(1, "videre","sehen"),
            new Query(1, "Magister","Lehrer"),
            new Query(1, "Studium","Eifer"),
            new Query(1, "ius","Recht"),
            new Query(1, "ante","vor"),
            new Query(1, "mandare","anvertrauen"),
            new Query(1, "fortis","tapfer"),
            new Query(1, "conari","versuchen"),
            new Query(1, "redire","zurueckkehren"),
            new Query(1, "bene","gut"),
            new Query(1, "gravis","schwer"),
            new Query(1, "tantum","nur"),
            new Query(1, "venire","kommen"),
            new Query(1, "Verbum","Wort"),
            new Query(1, "Lex","Gesetz"));

    List<List<Query>> queries = Arrays.asList(CHAPTER_ONE, CHAPTER_TWO, CHAPTER_THREE, CHAPTER_FOUR, CHAPTER_FIVE, CHAPTER_SIX);

    private List<Query> wordsForChapter(int index) {
        return queries.get(index%queries.size()).stream().collect(Collectors.toList());
    }

}
