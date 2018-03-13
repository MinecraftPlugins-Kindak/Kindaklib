package se.kindak.kindaklib.location;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationFormater {

    public static Location format(String formatedLocation) {
        return new Location(Bukkit.getWorld(formatedLocation.split(",")[0]),
                Integer.parseInt(formatedLocation.split(",")[1]),
                Integer.parseInt(formatedLocation.split(",")[2]),
                Integer.parseInt(formatedLocation.split(",")[3]));

    }

    public static String format(Location location) {
        return location.getWorld().getName() + "," + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }
}
