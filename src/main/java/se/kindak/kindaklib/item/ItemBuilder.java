package se.kindak.kindaklib.item;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import se.kindak.kindaklib.item.util.CustomEnchantment;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material type, int amount, short dataId) {
        this.itemStack = new ItemStack(type, amount, dataId);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder(Material type, int amount, String name, List<String> lore) {
        this.itemStack = new ItemStack(type, amount);
        this.itemMeta = itemStack.getItemMeta();
        setName(name);
        this.itemMeta.setLore(lore);
        this.build();
    }

    //todo Fix serilize
    public static String serilize(ItemStack itemStack) {
        return "";
    }


    public ItemBuilder deSerilize(ConfigurationSection section) {
        String name = section.getString("Name");
        Material type = Material.getMaterial(section.getString("Type"));
        int amount = section.getInt("Amount");
        short data = (short) section.getInt("Data");
        List<String> lore = section.getStringList("Lore");
        List<CustomEnchantment> enchantments = new ArrayList<>();
        section.getStringList("Enchantments").forEach(s -> enchantments.add(CustomEnchantment.deSerilize(s)));

        ItemBuilder itemBuilder = new ItemBuilder(type, amount, data);
        if (name != null || !name.equalsIgnoreCase(""))
            itemBuilder.setName(name);
        if (lore != null || !lore.isEmpty())
            itemBuilder.getItemMeta().setLore(lore);
        if (enchantments != null || !enchantments.isEmpty())
            enchantments.forEach(e -> itemBuilder.addEnchantment(e.getEnchantment(), e.getLevel()));

        return itemBuilder;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void clearItemMeta() {
        this.itemStack = new ItemStack(itemStack.getType(), itemStack.getAmount(), itemStack.getDurability());
    }

    public void setName(String name) {
        itemMeta.setDisplayName(name);
    }

    public boolean addLoreLine(String line) {
        return itemMeta.getLore().add(line);
    }

    public void clearLore() {
        itemMeta.getLore().clear();
    }

    public void addEnchantment(Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, true);
    }

    public boolean removeLoreLine(int line) {
        if (line > itemMeta.getLore().size() - 1)
            return false;

        itemMeta.getLore().remove(line);
        return true;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public void setItemMeta(ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
    }
}
