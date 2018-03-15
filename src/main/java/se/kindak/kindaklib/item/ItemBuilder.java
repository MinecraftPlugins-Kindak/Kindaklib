package se.kindak.kindaklib.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
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

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public static String serilize(ItemStack itemStack) {
        String name = itemStack.getItemMeta().hasDisplayName() ? "N:" + itemStack.getItemMeta().getDisplayName() : "";
        String type = "M:" + itemStack.getType().name();
        String lore = "L:" + itemStack.getItemMeta().getLore().toString();
        String enchantment = "";
        String amount = "A:" + itemStack.getAmount();
        String dataId = "D:" + itemStack.getDurability();
        if (!itemStack.getEnchantments().keySet().isEmpty()) {
            enchantment += "E:";
            for (Enchantment ench : itemStack.getEnchantments().keySet()) {
                if (enchantment.equalsIgnoreCase("E:"))
                    enchantment += ench.getName() + ";" + itemStack.getEnchantments().get(ench) + ",";
                else
                    enchantment += "," + ench.getName() + ";" + itemStack.getEnchantments().get(ench);
            }
        }

        return name + "-" + type + "-" + amount + "-" + dataId + "-" + lore + "-" + enchantment;
    }

    public static ItemBuilder deSerilize(String serilizedItem) {
        String[] parts = serilizedItem.split("-");
        String name = null;
        Material type = null;
        int amount = 1;
        short dataId = 1;
        String[] lore = null;
        String enchantment = null;
        for (String part : parts) {
            char first = part.charAt(0);
            String partNoPre = part.split(":")[1];
            if (first == 'N') {
                name = partNoPre;
            } else if (first == 'M') {
                type = Material.getMaterial(partNoPre);
            } else if (first == 'A') {
                amount = Integer.parseInt(partNoPre);
            } else if (first == 'D') {
                dataId = Short.parseShort(partNoPre);
            } else if (first == 'L') {
                lore = partNoPre.split(",");
            } else if (first == 'E') {
                enchantment = partNoPre;
            }
        }

        ItemBuilder itemBuilder = new ItemBuilder(type, amount, dataId);

        if (lore != null)
            itemBuilder.getItemMeta().setLore(Arrays.asList(lore));

        if (enchantment != null) {
            for (String enchandlevel : enchantment.split(":")[1].split(";")) {
                int level = Integer.parseInt(enchandlevel.split(":")[1]);
                Enchantment ench = Enchantment.getByName(enchandlevel.split(":")[0]);
                itemBuilder.addEnchantment(ench, level);
            }
        }
        if (name != null)
            itemBuilder.setName(name);


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
