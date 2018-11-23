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

public class Session {
    private final Direction dir;
    private final Mode mode;
    private Chapter chapter;
    private Highscore currentHighscore;
    private final Highscore allTimeHighscore;
    private Query currentQuery;
    private int index;

    @JsonCreator
    public Session( @JsonProperty("dir") String dir, @JsonProperty("mode") String mode,
                    @JsonProperty("chapter") int chapter, @JsonProperty("currentHighscore") int currentHighscore,
                    @JsonProperty("allTimeHighscore") int allTimeHighscore) {
        this.dir = setDir(dir);
        this.mode = setMode(mode);
        this.chapter = setChapter(chapter);
        this.currentHighscore = setCurrentHighscore(currentHighscore);
        this.allTimeHighscore = setAllTimeHighscore(allTimeHighscore);
    }


    public Session() throws IOException {
        File file = new File("src/main/java/latintrainer/model/session.json");
        ObjectMapper om = new ObjectMapper();
        TypeFactory typeFactory = om.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Session.class);

        Map<String, Session> session = om.readValue(file, mapType);
        Session info = session.get("Infos");
        this.chapter = info.getChapter();
        this.dir = info.getDir();
        this.mode = info.getMode();
        this.allTimeHighscore = info.getAllTimeHighscore();
        this.currentHighscore = info.getCurrentHighscore();
    }

    // get a new set of Words
    public void newQuery() throws IOException {
        int newIndex;
        // not in sprint 1: check here what chapter were in and which mode the user chose
        // String mode = this.getMode().toString();
        // int chapter = Integer.parseInt(this.getChapter().toString());
        //
        //
        newIndex = (int) (Math.random()*20);
        newQuery(newIndex);
    }

    private void newQuery(int index) throws IOException {
        File file = new File("src/main/java/latintrainer/model/words.json");
        ObjectMapper om = new ObjectMapper();
        TypeFactory typeFactory = om.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Query.class);

        Map<String, Query> words = om.readValue(file, mapType);
        Query out = words.get(String.valueOf(index));
        currentQuery = out;
    }

    private Mode setMode(String mode) {
        Mode result = Mode.RANDOM;
        return result;
    }

    private Direction setDir(String dir) {
        Direction result = Direction.GERMAN;
        return result;
    }

    private Chapter setChapter(int chapter) {
        return new Chapter(1);
    }

    private Highscore setAllTimeHighscore(int allTimeHighscore) {
        return new Highscore(9000);
    }

    private Highscore setCurrentHighscore(int currentHighscore) {
        return new Highscore(1);
    }

    public int getIndex() {
        return index;
    }

    public Query getCurrentQuery() {
        return currentQuery;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Direction getDir() {
        return dir;
    }

    public Highscore getAllTimeHighscore() {
        return allTimeHighscore;
    }

    public Highscore getCurrentHighscore() {
        return currentHighscore;
    }

    public Mode getMode() {
        return mode;
    }

    @Override
    public String toString() {
        return "Richtung: " + dir + "; Modus: " + mode + "; Highscore: " + currentHighscore
                + "; Highest score: " + allTimeHighscore+ "; Kapitel: " + chapter;
    }
}
