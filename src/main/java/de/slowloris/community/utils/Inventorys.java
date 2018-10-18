/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.utils;


import com.xxmicloxx.NoteBlockAPI.model.Song;
import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventorys {

    public Inventorys(){

    }



    public Inventory getEventInv(){
        Inventory inventory = Bukkit.createInventory(null, 1*9, "§b§lEvent");
        inventory.setItem(InventoryUtils.buildItemPos(3, 1), ItemBuilder.newItem(Material.FIREWORK, 1, "§e§lEffekte"));

        ItemBuilder builder = new ItemBuilder(Material.RECORD_12, 1, "§e§lMusik");
        inventory.setItem(InventoryUtils.buildItemPos(7, 1), builder.build());
        inventory.setItem(InventoryUtils.buildItemPos(5, 1), ItemBuilder.newItem(Material.REDSTONE, 1, "§6§lSpieler Events"));
        return inventory;
    }

    public Inventory getEffectInv(){
        Inventory inventory = Bukkit.createInventory(null, 4*9, "§e§lEffekte");
        inventory.setItem(InventoryUtils.buildItemPos(3, 2), ItemBuilder.newItem(Material.FIREWORK, 1, "§c§lFeuerwerk"));
        inventory.setItem(InventoryUtils.buildItemPos(7, 2), ItemBuilder.newItem(Material.ARROW, 1, "§9§lPfeile"));
        return inventory;
    }

    public Inventory getPlayerEventsInv(){
        Inventory inventory = Bukkit.createInventory(null, 3*9, "§6§lSpieler Events");

        ItemBuilder builder = new ItemBuilder(Material.IRON_SWORD, 1, "§c§lPvP");
        if(Main.getEventManager().getEventType().equals(EventType.PVP)){
            builder.enchant(Enchantment.DAMAGE_ALL, 10);
        }
        inventory.setItem(InventoryUtils.buildItemPos(3, 2), builder.build());

        builder = new ItemBuilder(Material.DIAMOND_PICKAXE, 1, "§9§lGrief");
        if(Main.getEventManager().getEventType().equals(EventType.GRIEF)){
            builder.enchant(Enchantment.DAMAGE_ALL, 10);
        }
        inventory.setItem(InventoryUtils.buildItemPos(7, 2), builder.build());

        return inventory;
    }

    public Inventory getMusicInv(){
        Inventory inv = Bukkit.createInventory(null, 6*9, "§b§lMusic");

        int i = 0;

        for (Song song : Main.getMusicManager().getSongs()){

            if (i < 44) {
                ItemBuilder builder = new ItemBuilder(Material.RECORD_3, 1, song.getPath().getName().replace(".nbs", ""));

                if (Main.getMusicManager().getFileName().equalsIgnoreCase(song.getPath().getName().replace(".nbs", ""))) {
                    builder.enchant(Enchantment.DURABILITY, 10);
                }

                List<String> lore = new ArrayList<String>();
                lore.add("§c");
                lore.add("§c§lTitel: §e" + song.getTitle());
                lore.add("§c§lAuthor: §e" + song.getAuthor());
                lore.add("§c§lLänge: §e" + (song.getLength() / 20) + " Sekunden");
                lore.add("§e");
                builder.setLore(lore);
                inv.setItem(i, builder.build());
                i++;
            } else {
                break;
            }

        }

        if(Main.getMusicManager().isStopped()){
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §cGestoppt", (byte) 14);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());

        }else if(Main.getMusicManager().isPlaying()){
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §aSpiele §b" + Main.getMusicManager().getSong().getPath().getName().replace(".nbs", ""), (byte) 5);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());

            inv.setItem(InventoryUtils.buildItemPos(5, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§cStoppen", (byte) 1));
            inv.setItem(InventoryUtils.buildItemPos(6, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§6Pausieren", (byte) 14));
        }else {
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §6Pausiert", (byte) 1);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());
            inv.setItem(InventoryUtils.buildItemPos(5, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§aAbspielen", (byte) 10));
        }

        inv.setItem(InventoryUtils.buildItemPos(9, 6), new ItemBuilder(Material.JUKEBOX, 1, "§b§lFavoriten").enchant(Enchantment.DURABILITY, 10).build());

        return inv;
    }

    public Inventory getFavouritemusicInv(){


        /*
        TODO: Eigene Favoriten erstellen lassen
        TODO: mit user configs und dann alle dateien namen dort abspeichern
        TODO: favoriten werden mit einem Rechtsklick erstellt
         */



        Inventory inv = Bukkit.createInventory(null, 6*9, "§b§lFavoriten");

        int i = 0;

        for (Song song : Main.getMusicManager().getFavourites()){
            if(i < 44){
                ItemBuilder builder = new ItemBuilder(Material.RECORD_3, 1, song.getPath().getName().replace(".nbs", ""));

                if(Main.getMusicManager().getFileName().equalsIgnoreCase(song.getPath().getName().replace(".nbs", ""))){
                    builder.enchant(Enchantment.DURABILITY, 10);
                }

                List<String> lore = new ArrayList<String>();
                lore.add("§c");
                lore.add("§c§lTitel: §e" + song.getTitle());
                lore.add("§c§lAuthor: §e" + song.getAuthor());
                lore.add("§c§lLänge: §e" + (song.getLength() / 20) + " Sekunden");
                lore.add("§e");
                builder.setLore(lore);
                inv.setItem(i, builder.build());
                i++;
            }else {
                break;
            }
        }

        if(Main.getMusicManager().isStopped()){
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §cGestoppt", (byte) 14);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());

        }else if(Main.getMusicManager().isPlaying()){
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §aSpiele §b" + Main.getMusicManager().getSong().getPath().getName().replace(".nbs", ""), (byte) 5);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());

            inv.setItem(InventoryUtils.buildItemPos(5, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§cStoppen", (byte) 1));
            inv.setItem(InventoryUtils.buildItemPos(6, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§6Pausieren", (byte) 14));
        }else {
            ItemBuilder builder = new ItemBuilder(Material.WOOL, 1, "§e§lStatus: §6Pausiert", (byte) 1);
            inv.setItem(InventoryUtils.buildItemPos(2, 6), builder.build());
            inv.setItem(InventoryUtils.buildItemPos(5, 6), ItemBuilder.newItem(Material.getMaterial(351), 1, "§aAbspielen", (byte) 10));
        }

        inv.setItem(InventoryUtils.buildItemPos(9, 6), new ItemBuilder(Material.JUKEBOX, 1, "§b§lAlle Lieder").enchant(Enchantment.DURABILITY, 10).build());

        return inv;
    }


}
