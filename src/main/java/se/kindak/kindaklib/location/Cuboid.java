package se.kindak.kindaklib.location;

import org.bukkit.Location;

public class Cuboid {
    private Location locationOne;
    private Location locationTwo;


    public Cuboid(Location locationOne, Location locationTwo) {
        this.locationOne = locationOne;
        this.locationTwo = locationTwo;
    }

    public int[] getMinPoints() {
        int[] points = {
                Math.min(locationOne.getBlockX(), locationTwo.getBlockX()),
                Math.min(locationOne.getBlockY(), locationTwo.getBlockY()),
                Math.min(locationOne.getBlockZ(), locationTwo.getBlockZ())};

        return points;
    }

    public int[] getMaxPoints() {
        int[] points = {
                Math.max(locationOne.getBlockX(), locationTwo.getBlockX()),
                Math.max(locationOne.getBlockY(), locationTwo.getBlockY()),
                Math.max(locationOne.getBlockZ(), locationTwo.getBlockZ())};

        return points;
    }

    public Location getLocationOne() {
        return locationOne;
    }

    public void setLocationOne(Location locationOne) {
        this.locationOne = locationOne;
    }

    public Location getLocationTwo() {
        return locationTwo;
    }
    public void setLocationTwo(Location locationTwo) {
        this.locationTwo = locationTwo;
    }
}
