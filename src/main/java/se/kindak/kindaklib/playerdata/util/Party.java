package se.kindak.kindaklib.playerdata.util;

import se.kindak.kindaklib.Settings;
import se.kindak.kindaklib.playerdata.PlayerData;

import java.util.HashSet;
import java.util.Set;

public class Party {
    private Set<PlayerData> players;
    private PlayerData leader;

    public Party(Set<PlayerData> players, PlayerData creator) {
        this.players = players;
        this.leader = creator;
        players.add(creator);
    }

    public Party(PlayerData creator) {
        this.leader = creator;
        this.players = new HashSet<>();
        players.add(creator);

    }

    public int getPartySize() {
        return players.size();
    }

    public boolean addPlayer(PlayerData player) {
        if (players.size() == Settings.getInstance().MAX_PARTY_SIZE)
            return false;

        return players.add(player);
    }

    public boolean removePlayer(PlayerData player) {
        if (player == leader)
            return false;

        return players.remove(player);
    }

    public Set<PlayerData> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerData> players) {
        this.players = players;
    }

    public PlayerData getLeader() {
        return leader;
    }

    public void setLeader(PlayerData leader) {
        this.leader = leader;
    }
}
