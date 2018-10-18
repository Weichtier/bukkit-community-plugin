/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.events;

import de.slowloris.community.main.Main;
import de.slowloris.community.utils.InventoryUtils;
import de.slowloris.community.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class PvPEvent {

    private boolean ingame = false;

    public PvPEvent(){
    }

    public void setIngame(boolean ingame) {
        this.ingame = ingame;


        if(ingame){

            for (Player all : Bukkit.getOnlinePlayers()){

                all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 1.0F, 1.0F);
                all.sendMessage(Main.getPrefix() + "§a§lDas §6§lPvPEvent §a§lwurde gestartet!");
                giveItems(all);
            }
        }else {
            for (Player all : Bukkit.getOnlinePlayers()){
                all.getInventory().clear();
                all.getInventory().setArmorContents(null);
                InventoryUtils.giveItems(all);
            }
        }
    }

    public boolean isIngame() {
        return ingame;
    }

    public static void giveItems(Player p){
        Inventory inv = p.getInventory();
        p.setLevel(0);
        inv.clear();
        inv.setItem(0, ItemBuilder.newItem(Material.IRON_SWORD, 1, "§e§lTodesklinge"));
        inv.setItem(1, ItemBuilder.newItem(Material.COOKED_BEEF, 64, "§e§lFleisch"));
        ((PlayerInventory) inv).setHelmet(ItemBuilder.newItem(Material.IRON_HELMET, 1, "§e§lHelm"));
        ((PlayerInventory) inv).setChestplate(ItemBuilder.newItem(Material.IRON_CHESTPLATE, 1, "§e§lPanzer"));
        ((PlayerInventory) inv).setLeggings(ItemBuilder.newItem(Material.IRON_LEGGINGS, 1, "§e§lHose"));
        ((PlayerInventory) inv).setBoots(ItemBuilder.newItem(Material.IRON_BOOTS, 1, "§e§lSchuhe"));
    }

}
