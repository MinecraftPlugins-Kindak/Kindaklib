package se.kindak.kindaklib.playerdata;


import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import se.kindak.kindaklib.language.MessageComponent;

import java.util.UUID;

public class PlayerData {
    private UUID playerUUID;

    public PlayerData(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public void msg(String message) {

    }

    public void msg(MessageComponent message) {
        switch (message.getType()) {
            case ACTION_BAR:
                break;
            case TITLE:
                break;
            case CHAT:
                break;
            default:
                return;
        }

        getPlayer().spigot().sendMessage(new TextComponent());

    }

    public Player getPlayer() {
        return Bukkit.getPlayer(playerUUID);
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }
}
