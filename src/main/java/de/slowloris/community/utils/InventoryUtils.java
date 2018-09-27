package de.slowloris.community.utils;

import de.slowloris.community.commands.FlyCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryUtils {
    private static ArrayList<Player> speedoff = new ArrayList<Player>();
    private static HashMap<Player, String> playerhider = new HashMap<Player, String>();
    public static void giveItems(Player p){
        Inventory inv = p.getInventory();
        inv.setItem(0, ItemBuilder.newItem(Material.GREEN_RECORD, 1, "§bTeleporter"));
        if(p.hasPermission("community.fly")){
            if(getSpeedoff().contains(p)){
                inv.setItem(3, ItemBuilder.newItem(Material.FEATHER, 1, "§bSpeed §8» §cDeaktiviert"));
                p.setWalkSpeed(0.2F);
                p.setFlySpeed(0.2F);
            }else {
                inv.setItem(3, ItemBuilder.newItem(Material.FEATHER, 1, "§bSpeed §8» §aAktiviert"));
                p.setWalkSpeed(0.4F);
                p.setFlySpeed(0.4F);
            }
            if(FlyCommand.fly.contains(p)){
                inv.setItem(5, ItemBuilder.newItem(Material.ARROW, 1, "§bFlugmodus §8» §aAktiviert"));
                p.setAllowFlight(true);
            }else {
                inv.setItem(5, ItemBuilder.newItem(Material.ARROW, 1, "§bFlugmodus §8» §cDeaktiviert"));
                p.setAllowFlight(false);
            }
        }else {
            if(getSpeedoff().contains(p)){
                inv.setItem(4, ItemBuilder.newItem(Material.FEATHER, 1, "§bSpeed §8» §cDeaktiviert"));
            }else {
                inv.setItem(4, ItemBuilder.newItem(Material.FEATHER, 1, "§bSpeed §8» §aAktiviert"));
            }
        }
        if(!getPlayerhider().containsKey(p)){
            getPlayerhider().put(p, "all");
        }
        if(getPlayerhider().get(p).equalsIgnoreCase("all")){
            inv.setItem(8, ItemBuilder.newItem(Material.BLAZE_ROD, 1, "§bSpieler Anzeigen §8» §aAlle"));
        }else if(getPlayerhider().get(p).equalsIgnoreCase("vip")){
            inv.setItem(8, ItemBuilder.newItem(Material.BLAZE_ROD, 1, "§bSpieler Anzeigen §8» §5VIP"));
        }else if(getPlayerhider().get(p).equalsIgnoreCase("none")){
            inv.setItem(8, ItemBuilder.newItem(Material.BLAZE_ROD, 1, "§bSpieler Anzeigen §8» §cNiemand"));
        }
    }

    public static ArrayList<Player> getSpeedoff() {
        return speedoff;
    }

    public static HashMap<Player, String> getPlayerhider() {
        return playerhider;
    }
}
