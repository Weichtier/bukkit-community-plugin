/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.listener;

import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickupListener implements Listener {
    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e){
        if(!InteractListener.getCanbuild().contains(e.getPlayer())){
            e.setCancelled(true);
        }else if(Main.getEventManager().getEventType().equals(EventType.GRIEF)){
            e.setCancelled(false);
        }
    }
}
