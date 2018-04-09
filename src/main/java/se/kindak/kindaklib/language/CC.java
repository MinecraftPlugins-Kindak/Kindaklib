package se.kindak.kindaklib.language;

import org.bukkit.ChatColor;

public class CC {
    public static final String
            BOLD = ChatColor.BOLD.toString(), STRIPE = ChatColor.STRIKETHROUGH.toString(),
            MAGIC = ChatColor.MAGIC.toString(), UNDERLINE = ChatColor.UNDERLINE.toString(),
            ITALIC = ChatColor.ITALIC.toString(), RESET = ChatColor.RESET.toString(),
            RED = ChatColor.RED.toString(), D_RED = ChatColor.DARK_RED.toString(),
            BLUE = ChatColor.BLUE.toString(), D_BLUE = ChatColor.DARK_BLUE.toString(),
            AQUA = ChatColor.AQUA.toString(), D_AQUA = ChatColor.DARK_AQUA.toString(),
            BLACK = ChatColor.BLACK.toString(), WHITE = ChatColor.WHITE.toString(),
            GREEN = ChatColor.GREEN.toString(), D_GREEN = ChatColor.DARK_GREEN.toString(),
            PURPLE = ChatColor.LIGHT_PURPLE.toString(), D_PURPLE = ChatColor.DARK_PURPLE.toString(),
            GRAY = ChatColor.GRAY.toString(), D_GRAY = ChatColor.DARK_GRAY.toString(),
            YELLOW = ChatColor.YELLOW.toString(), GOLD = ChatColor.GOLD.toString();

    public static String clearColors(String message) {
        return ChatColor.stripColor(message);
    }

    public static String formatColors(char replace, String message) {
        return ChatColor.translateAlternateColorCodes(replace, message);
    }
    
}
