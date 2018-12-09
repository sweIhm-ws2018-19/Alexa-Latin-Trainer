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

    private static final List<Query> CHAPTER_ONE = Arrays.asList(
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

    private static final List<Query> CHAPTER_TWO = Arrays.asList(
            new Query(0, "facere","machen"),
            new Query(1, "multus","viel"),
            new Query(2, "magnus","gross"),
            new Query(3, "animus","Geist"),
            new Query(4, "iam","schon"),
            new Query(5, "pars","Teil"),
            new Query(6, "nihil","nichts"),
            new Query(7, "corpus","Körper"),
            new Query(8, "deus","Gott"),
            new Query(9, "homo","Mensch"),
            new Query(10, "noster","unser"),
            new Query(11, "locus","Ort"),
            new Query(12, "manus","Hand"),
            new Query(13, "dies","Tag"),
            new Query(14, "bellum","Krieg"),
            new Query(15, "vita","Leben"),
            new Query(16, "pater","Vater"),
            new Query(17, "causa","Ursache"),
            new Query(18, "vis","Kraft"),
            new Query(19, "totus","ganz"));

    private static final List<Query> CHAPTER_THREE = Arrays.asList(
            new Query(0, "credere","glauben"),
            new Query(1, "urbis","Stadt"),
            new Query(2, "longus","lang"),
            new Query(3, "ergo","deshalb"),
            new Query(4, "petere","erbitten"),
            new Query(5, "natura","Natur"),
            new Query(6, "mors","Tod"),
            new Query(7, "primus","der Erste"),
            new Query(8, "tantus","so groß"),
            new Query(9, "fortuna","Schicksal"),
            new Query(10, "vivere","leben"),
            new Query(11, "miles","Soldat"),
            new Query(12, "populus","Volk"),
            new Query(13, "satis","genug"),
            new Query(14, "pedis","Fuß"),
            new Query(15, "mare","Meer"),
            new Query(16, "sub","unter"),
            new Query(17, "duo","zwei"),
            new Query(18, "parvus","klein"),
            new Query(19, "modus","Art"));

    List<List<Query>> queries = Arrays.asList(CHAPTER_ONE, CHAPTER_TWO, CHAPTER_THREE);

    private List<Query> wordsForChapter(int index) {
        return queries.get(index%queries.size()).stream().collect(Collectors.toList());
    }

}
