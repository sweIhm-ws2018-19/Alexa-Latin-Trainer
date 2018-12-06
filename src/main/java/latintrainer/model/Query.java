package main.java.latintrainer.model;

public class Query {
    private final String latinWord;
    private final String germanWord;
    private final int index;


    public Query(int index, String latin, String german) {
        this.germanWord = german;
        this.latinWord = latin;
        this.index = index;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getLatinWord() {
        return latinWord;
    }

    public int getIndex() { return index;}

    @Override
    public String toString() {
        return "Deutsch: " + germanWord + "; latein: " + latinWord;
    }

}