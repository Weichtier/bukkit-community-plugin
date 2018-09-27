package de.slowloris.community.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
    public static ItemStack newItem(Material material, int count, String displayname){
        ItemStack item = new ItemStack(material, count);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        item.setItemMeta(meta);
        return item;
    }
}
