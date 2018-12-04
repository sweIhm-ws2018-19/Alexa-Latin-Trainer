package main.java.latintrainer.model;

public enum Direction {
    GERMAN("deutsch"),LATIN("lateinisch"),RANDOM("zufall");
    private final String dirSelection;
    Direction(String direction){
        this.dirSelection =direction;
    }
    public String getDirection(){
        return dirSelection;
    }
}
