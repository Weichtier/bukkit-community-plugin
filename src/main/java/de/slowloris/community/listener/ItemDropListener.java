/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if(!InteractListener.getCanbuild().contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
