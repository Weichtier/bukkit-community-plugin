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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GriefEvent {

    private boolean ingame = false;
    private BukkitTask scheduler;
    //TODO: Zeit bis Stop im Scoreboard anzeigen, Rüstung resetten, Event Item in der Mitte
    private int startingtime = 0;

    public GriefEvent(){
    }

    public void setIngame(boolean ingame) {
        this.ingame = ingame;


        if(ingame){

            scheduler = new BukkitRunnable(){
                public void run() {
                    Bukkit.getServer().shutdown();
                }
            }.runTaskLaterAsynchronously(Main.getInstance(), 1200);


            for (Player all : Bukkit.getOnlinePlayers()){

                all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 1.0F, 1.0F);
                all.sendMessage(Main.getPrefix() + "§a§lDas §6§lGriefEvent §a§lwurde gestartet!");
                giveItems(all);
            }
        }else {

            scheduler.cancel();

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
        ItemBuilder builder = new ItemBuilder(Material.DIAMOND_PICKAXE, 1, "§e§lSpitzpicke");
        builder.enchant(Enchantment.DIG_SPEED, 10);
        inv.setItem(0, builder.build());

        builder = new ItemBuilder(Material.DIAMOND_AXE, 1, "§e§lAxt");
        builder.enchant(Enchantment.DIG_SPEED, 10);
        inv.setItem(1, builder.build());

        builder = new ItemBuilder(Material.DIAMOND_SPADE, 1, "§e§lSchaufel");
        builder.enchant(Enchantment.DIG_SPEED, 10);
        inv.setItem(2, builder.build());
    }

}
