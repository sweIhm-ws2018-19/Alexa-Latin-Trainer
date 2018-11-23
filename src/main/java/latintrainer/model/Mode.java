package main.java.latintrainer.model;

public enum Mode {
    PROGRESS("Fortschritt"),RANDOM("Zufall"),CHAPTER("Kapitel");

    private final String mode;

    Mode(String mode){
        this.mode=mode;
    }

    public String getMode() {
        return mode;
    }
}
