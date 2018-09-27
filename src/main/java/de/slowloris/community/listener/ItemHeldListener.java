/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.listener;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemHeldListener implements Listener {
    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent e){
        if(!InteractListener.getCanbuild().contains(e.getPlayer())){

        }
    }
}
