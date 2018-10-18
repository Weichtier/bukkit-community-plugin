package de.slowloris.community.listener;

import de.slowloris.community.main.Main;
import de.slowloris.community.utils.ScoreboardBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void QuitEvent(PlayerQuitEvent e){
        e.setQuitMessage("");
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            public void run() {
                ScoreboardBuilder.updateForAll();
            }
        }, 5);
    }
}
