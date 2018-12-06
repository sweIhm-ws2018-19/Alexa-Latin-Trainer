package main.java.latintrainer.model;

public class Query {
    private final int chapter;
    private final String latinWord;
    private final String germanWord;


    public Query(int chapter, String latin, String german)
    {
        this.chapter = chapter;
        this.germanWord = german;
        this.latinWord = latin;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getLatinWord() {
        return latinWord;
    }

    public int getChapter() {
        return chapter;
    }

    @Override
    public String toString() {
        return "Deutsch: " + germanWord + "; latein: " + latinWord + " Kapitel: "+chapter;
    }

}