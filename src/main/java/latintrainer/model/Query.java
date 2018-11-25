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
//    @JsonCreator
//    public Query(@JsonProperty("latin") String latin, @JsonProperty("german") String german, @JsonProperty("rating")int rating)
//    {
//        this.germanWord = german;
//        this.latinWord = latin;
//        this.rating = rating;
//    }
//    public Query() throws IOException {
//        this((int) (Math.random()*20));
//    }
//
//    public Query(int index ) throws IOException {
//        File file = new File("src/main/java/latintrainer/model/words.json");
//        ObjectMapper om = new ObjectMapper();
//        TypeFactory typeFactory = om.getTypeFactory();
//        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Query.class);
//
//        Map<String, Query> words = om.readValue(file, mapType);
//        Query out = words.get(String.valueOf(index));
//        this.germanWord = out.getGermanWord();
//        this.latinWord = out.getLatinWord();
//        this.rating = out.getRating();
//    }

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
