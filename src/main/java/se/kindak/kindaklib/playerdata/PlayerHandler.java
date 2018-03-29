package se.kindak.kindaklib.playerdata;

import org.bukkit.entity.Player;

import java.util.Set;

public class PlayerHandler {
    public Set<PlayerData> players;


    public PlayerData getPlayerdata(Player player) {
        try {
            return (PlayerData) players.stream().filter(p -> p.getPlayer() == player).toArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public Set<PlayerData> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerData> players) {
        this.players = players;
    }
}
