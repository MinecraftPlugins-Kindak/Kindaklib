package se.kindak.kindaklib;

import org.bukkit.plugin.java.JavaPlugin;
import se.kindak.kindaklib.playerdata.PlayerHandler;

public final class Kindaklib extends JavaPlugin {
    private static Kindaklib instance;
    private PlayerHandler playerHandler;

    public static Kindaklib getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        playerHandler = new PlayerHandler();
    }

    @Override
    public void onDisable() {

    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public void setPlayerHandler(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
    }
}
