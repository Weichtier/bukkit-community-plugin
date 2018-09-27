package de.slowloris.community.listener;

import de.slowloris.community.main.Main;
import de.slowloris.community.utils.TpUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {
    @EventHandler
    public void DeathEvent(PlayerDeathEvent e){
        final Player p = e.getEntity();
        e.setKeepInventory(true);
        e.setDeathMessage("");
        new BukkitRunnable(){
            public void run() {
                p.spigot().respawn();
                TpUtils.tpWarp(p, "Spawn");
            }
        }.runTaskLater(Main.getPlugin(), 1);
    }
}
