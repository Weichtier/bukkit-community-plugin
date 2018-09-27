package de.slowloris.community.listener;

import de.slowloris.community.main.Main;
import de.slowloris.community.utils.TpUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        if(!InteractListener.getCanbuild().contains(p)){
            e.setCancelled(true);
        }else {
            return;
        }
        if(e.getClickedInventory().getName().equalsIgnoreCase("§bTeleporter")){
            if(clicked != null && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lBühne")){
                TpUtils.tpWarp(p, "Buehne");
            }else if(clicked != null && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lSpawn")){
                TpUtils.tpWarp(p, "Spawn");
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lBackstage")){
                TpUtils.tpWarp(p, "Backstage");
            }
        }
    }
}
