package se.kindak.kindaklib.item.util;

import org.bukkit.enchantments.Enchantment;

public class CustomEnchantment {
    private Enchantment enchantment;
    private int level;

    public CustomEnchantment(Enchantment enchantment, int level) {
        this.enchantment = enchantment;
        this.level = level;
    }

    public static CustomEnchantment deSerilize(String serilizedEnchantment) {
        String[] parts = serilizedEnchantment.split(":");
        Enchantment enchantment = Enchantment.getByName(parts[0]);
        int level = Integer.parseInt(parts[1]);
        return new CustomEnchantment(enchantment, level);
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String serilize(String serilizedEnchantment) {
        return this.getEnchantment().getName() + ":" + this.getLevel();
    }
}
