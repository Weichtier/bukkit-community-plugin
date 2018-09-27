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
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {
    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
        e.getPlayer().playSound(e.getTo(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    }
}
