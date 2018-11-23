package main.java.latintrainer.model;

public enum Direction {
    GERMAN("deutsch"),LATIN("lateinisch"),RANDOM("zufall");
    private final String direction;
    Direction(String direction){
        this.direction=direction;
    }
    public String getDirection(){
        return direction;
    }
}
