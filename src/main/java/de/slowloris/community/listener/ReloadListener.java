/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.listener;

import de.slowloris.community.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReloadListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onReload(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        String command = e.getMessage().split(" ")[0];
        if(command.equalsIgnoreCase("rl") || command.equalsIgnoreCase("reload")){
            if(p.isOp()){
                e.setCancelled(true);
                Bukkit.reload();
                for (Player all : Bukkit.getOnlinePlayers()){
                    InventoryUtils.giveItems(all);
                }
            }
        }
    }
}
