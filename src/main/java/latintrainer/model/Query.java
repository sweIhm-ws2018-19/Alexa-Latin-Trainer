package main.java.latintrainer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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