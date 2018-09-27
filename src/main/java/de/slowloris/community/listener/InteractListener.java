package de.slowloris.community.listener;

import de.slowloris.community.commands.FlyCommand;
import de.slowloris.community.utils.*;
import org.bukkit.*;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class InteractListener implements Listener {
    private static ArrayList<Player> canbuild = new ArrayList<Player>();

    @EventHandler
    public void InteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getClickedBlock() != null && e.getClickedBlock().getState() instanceof Sign){
            Sign sign = (Sign) e.getClickedBlock().getState();
            if(sign.getLine(0).equalsIgnoreCase("§5Glückwunsch!")){
                TpUtils.tpWarp(p, "Spawn");
            }
        }
        if(p.getItemInHand().getType().isBlock() && !getCanbuild().contains(p)){
            return;
        }

        if(e.getItem() == null){
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null){
            return;
        }
        if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("teleporter"))){
            Inventory inv = Bukkit.createInventory(p, 9, "§bTeleporter");
            inv.setItem(2, ItemBuilder.newItem(Material.BEACON, 1, "§5§lBühne"));
            inv.setItem(6, ItemBuilder.newItem(Material.ENDER_PEARL, 1, "§5§lSpawn"));
            if(p.hasPermission("pt.vip")){
                inv.setItem(4, ItemBuilder.newItem(Material.NETHER_STAR, 1, "§5§lBackstage"));
            }
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            p.openInventory(inv);
        }else if(p.getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("speedoff"))){
            InventoryUtils.getSpeedoff().remove(p);
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("speedon"))){
            InventoryUtils.getSpeedoff().add(p);
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("hideron"))){
            HidePlayerUtils.hideVIP(p);
            InventoryUtils.getPlayerhider().put(p, "vip");
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("hidervip"))){
            HidePlayerUtils.hidePlayer(p);
            InventoryUtils.getPlayerhider().put(p, "none");
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("hideroff"))){
            HidePlayerUtils.showPlayer(p);
            InventoryUtils.getPlayerhider().put(p, "all");
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("flyoff"))){
            FlyCommand.fly.add(p);
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(InventoryUtils.getItemName("flyon"))){
            FlyCommand.fly.remove(p);
            InventoryUtils.giveItems(p);
            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }
    }
    public static ArrayList<Player> getCanbuild() {
        return canbuild;
    }
}
