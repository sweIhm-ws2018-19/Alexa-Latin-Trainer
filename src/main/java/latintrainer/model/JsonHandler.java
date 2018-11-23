package main.java.latintrainer.model;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonHandler {

    Map<String, Query> abfrage = new HashMap<>();

    public void readSessionInfo() throws IOException {
        File file = new File("src/main/java/latintrainer/model/session.json");
        ObjectMapper om = new ObjectMapper();
        TypeFactory typeFactory = om.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Session.class);

        Map<String, Session> word = om.readValue(file, mapType);

        System.out.println(word);
    }
    public void readQuery() throws IOException {
        File file = new File("src/main/java/latintrainer/model/words.json");
        ObjectMapper om = new ObjectMapper();
        TypeFactory typeFactory = om.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Query.class);

        Map<String, Query> words = om.readValue(file, mapType);
        String out = words.get("3").getLatinWord();
        System.out.println(out);
    }

    @Override
    public String toString() {
        String tmp = "";
        for (Query current : abfrage.values()) {
            tmp += current.toString() + "\n";
            tmp += "\n\n";
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        JsonHandler test = new JsonHandler();
        test.readQuery();
        test.readSessionInfo();
    }

}
