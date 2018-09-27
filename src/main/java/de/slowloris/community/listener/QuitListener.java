package de.slowloris.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void QuitEvent(PlayerQuitEvent e){
        e.setQuitMessage("");
    }
}
