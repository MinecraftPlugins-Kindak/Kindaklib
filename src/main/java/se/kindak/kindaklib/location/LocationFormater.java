package se.kindak.kindaklib.location;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationFormater {

    public static Location format(String formatedLocation) {
        String[] parts = formatedLocation.split(",");
        World world = Bukkit.getWorld(parts[0]);
        Integer x = Integer.parseInt(parts[1]);
        Integer y = Integer.parseInt(parts[2]);
        Integer z = Integer.parseInt(parts[3]);

        if (x == null || y == null || z == null || world == null)
            return null;

        return new Location(world, x, y, z);

    }

    public static String format(Location location) {
        return location.getWorld().getName() + "," + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }
}
