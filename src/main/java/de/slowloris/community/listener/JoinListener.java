package de.slowloris.community.listener;

import de.slowloris.community.commands.FlyCommand;
import de.slowloris.community.commands.VanishCommand;
import de.slowloris.community.utils.HidePlayerUtils;
import de.slowloris.community.utils.InventoryUtils;
import de.slowloris.community.utils.TpUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void JoinEvent(PlayerJoinEvent e){
        e.setJoinMessage("");
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().getInventory().clear();
        e.getPlayer().setFlySpeed(0.2F);
        e.getPlayer().setWalkSpeed(0.2F);
        InventoryUtils.getPlayerhider().put(e.getPlayer(), "all");
        for(Player p : Bukkit.getOnlinePlayers()){
            if(InventoryUtils.getPlayerhider().get(p).equalsIgnoreCase("vip")){
                HidePlayerUtils.hideVIP(p);
            }else if(InventoryUtils.getPlayerhider().get(p).equalsIgnoreCase("none")){
                HidePlayerUtils.hidePlayer(p);
            }else if(InventoryUtils.getPlayerhider().get(p).equalsIgnoreCase("all")){
                HidePlayerUtils.showPlayer(p);
            }
        }
        for (Player invanish : VanishCommand.getInVanish()){
            VanishCommand.hide(invanish);
        }
        InventoryUtils.getSpeedoff().add(e.getPlayer());
        Player p = e.getPlayer();
        InventoryUtils.giveItems(p);
        p.setGameMode(GameMode.SURVIVAL);
        TpUtils.tpWarp(p, "Spawn");
    }
}
