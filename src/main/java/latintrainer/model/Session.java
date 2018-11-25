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
    private Direction dir;
    private Mode mode;
    private Chapter chapter;
    private Highscore currentHighscore;
    private Highscore allTimeHighscore;
    private Query currentQuery;
    private int index;

    @JsonCreator
    public Session( @JsonProperty("dir") String dir, @JsonProperty("mode") String mode,
                    @JsonProperty("chapter") int chapter, @JsonProperty("currentHighscore") int currentHighscore,
                    @JsonProperty("allTimeHighscore") int allTimeHighscore) {
        this.dir = Direction.valueOf(dir);
        this.mode = Mode.valueOf(mode);
        this.chapter = new Chapter(chapter);
        this.currentHighscore = new Highscore(currentHighscore);
        this.allTimeHighscore = new Highscore(allTimeHighscore);
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
        // int chapter = Integer.parseInt(this.getChapterAsInt().toString());
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
        this.mode = Mode.valueOf(mode);
        return this.mode;
    }

    private Direction setDir(String dir) {
        this.dir = Direction.valueOf(dir);
        return this.dir;
    }

    private Chapter setChapt(int chapter) {
        this.chapter.setChapter(chapter);
        return this.chapter;
    }

    private Highscore setAllTimeHighscore(int allTimeHighscore) {
        this.allTimeHighscore.setHighscore(allTimeHighscore);
        return this.allTimeHighscore;
    }

    private Highscore setCurrentHighscore(int currentHighscore) {
        this.currentHighscore.setHighscore(currentHighscore);
        return this.currentHighscore;
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