package se.kindak.kindaklib;

import org.bukkit.plugin.java.JavaPlugin;

public final class Kindaklib extends JavaPlugin {
    private static Kindaklib instance;

    public static Kindaklib getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
