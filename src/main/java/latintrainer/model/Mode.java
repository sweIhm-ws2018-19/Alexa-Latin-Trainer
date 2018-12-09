package main.java.latintrainer.model;

public enum Mode {
    PROGRESS("Fortschritt"),RANDOM("Zufall"),CHAPTER("Kapitel");

    private final String modeName;

    Mode(String modeName){
        this.modeName = modeName;
    }

    public String getModeName() {
        return modeName;
    }

}
