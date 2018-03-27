package se.kindak.kindaklib.location;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
    private final Location locationOne;
    private final Location locationTwo;
    private final World world;

    public Cuboid(Location locationOne, Location locationTwo) {
        this.locationOne = locationOne;
        this.locationTwo = locationTwo;
        this.world = locationOne.getWorld();
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

    public List<Location> getArea() {
        ArrayList<Location> area = new ArrayList<>();
        for (int x = this.getMinPoints()[0]; x < this.getMaxPoints()[0]; x++) {
            for (int y = this.getMinPoints()[1]; y < this.getMaxPoints()[1]; y++) {
                for (int z = this.getMinPoints()[2]; z < this.getMaxPoints()[2]; z++) {
                    area.add(new Location(world, x, y, z));
                }
            }
        }
        return area;
    }

    public Location getLocationOne() {
        return locationOne;
    }

    public World getWorld() {
        return world;
    }

    public Location getLocationTwo() {
        return locationTwo;
    }


}
