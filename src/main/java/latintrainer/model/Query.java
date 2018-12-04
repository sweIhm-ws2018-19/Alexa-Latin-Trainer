package main.java.latintrainer.model;

public class Query {
    private final int index;
    private final String latinWord;
    private final String germanWord;
    private int rating;

    public Query(int index, String latin, String german,int rating)
    {
        this.index = index;
        this.germanWord = german;
        this.latinWord = latin;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rate) {
        this.rating = rate;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getLatinWord() {
        return latinWord;
    }

    @Override
    public String toString() {
        return "Deutsch: " + germanWord + "; latein: " + latinWord + "; rating: " + rating;
    }

}