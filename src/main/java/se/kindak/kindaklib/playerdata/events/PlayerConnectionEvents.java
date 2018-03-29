package se.kindak.kindaklib.playerdata.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import se.kindak.kindaklib.Kindaklib;
import se.kindak.kindaklib.playerdata.PlayerData;

public class PlayerConnectionEvents implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        PlayerData playerData = new PlayerData(e.getPlayer().getUniqueId());
        Kindaklib.getInstance().getPlayerHandler().players.add(playerData);
    }

    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent e) {
        PlayerData playerData = Kindaklib.getInstance().getPlayerHandler().getPlayerdata(e.getPlayer());
        Kindaklib.getInstance().getPlayerHandler().getPlayers().remove(playerData);
    }
}
