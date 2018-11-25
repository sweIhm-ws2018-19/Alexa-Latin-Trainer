package main.java.latintrainer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Query {
    private final String latinWord;
    private final String germanWord;
    private final int rating;

    @JsonCreator
    public Query(@JsonProperty("latin") String latin, @JsonProperty("german") String german, @JsonProperty("rating")int rating)
    {
        this.germanWord = german;
        this.latinWord = latin;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
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