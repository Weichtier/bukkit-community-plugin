package de.slowloris.community.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {
    private ItemStack item;
    private ItemMeta meta;
    private ItemBuilder instance;
    public ItemBuilder(Material material, int count, String displayname){
        instance = this;
        item = new ItemStack(material, count);
        meta = item.getItemMeta();
        meta.setDisplayName(displayname);
    }

    public ItemBuilder(Material material, int count, String displayname, byte shortcode){
        item = new ItemStack(material, count, shortcode);
        meta = item.getItemMeta();
        meta.setDisplayName(displayname);
    }

    public ItemBuilder enchant(Enchantment enchantment, int lvl){
        meta.addEnchant(enchantment, lvl, true);
        return instance;
    }

    public ItemBuilder setLore(List<String> lore){
        meta.setLore(lore);
        return instance;
    }


    public ItemStack build(){
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack newItem(Material material, int count, String displayname){
        ItemBuilder builder = new ItemBuilder(material, count, displayname);
        return builder.build();
    }
    public static ItemStack newItem(Material material, int count, String displayname, byte shortcode){
        ItemBuilder builder = new ItemBuilder(material, count, displayname, shortcode);
        return builder.build();
    }
}
