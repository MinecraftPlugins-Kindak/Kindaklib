package se.kindak.kindaklib;

public class Settings {
    private static Settings instance;
    public final int MAX_PARTY_SIZE;

    public Settings(int MAX_PARTY_SIZE) {
        this.MAX_PARTY_SIZE = MAX_PARTY_SIZE;
    }

    public static Settings getInstance() {
        return instance;
    }

    public static void setInstance(Settings instance) {
        Settings.instance = instance;
    }

}
