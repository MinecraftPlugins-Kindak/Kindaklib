package se.kindak.kindaklib.playerdata.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import se.kindak.kindaklib.playerdata.PlayerData;
import se.kindak.kindaklib.playerdata.PlayerHandler;

public class PlayerConnectionEvents implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        PlayerData playerData = new PlayerData(e.getPlayer().getUniqueId());
        PlayerHandler.instance().players.add(playerData);
    }
    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent e) {
        PlayerData playerData = PlayerHandler.instance().getPlayerdata(e.getPlayer());
        PlayerHandler.instance().getPlayers().remove(playerData);
    }
}
