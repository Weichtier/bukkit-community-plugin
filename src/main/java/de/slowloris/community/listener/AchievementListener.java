package de.slowloris.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class AchievementListener implements Listener {
    @EventHandler
    public void AchievementEvent(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }
}
