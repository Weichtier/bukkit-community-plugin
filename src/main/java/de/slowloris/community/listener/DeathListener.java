package de.slowloris.community.listener;

import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import de.slowloris.community.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {
    @EventHandler
    public void DeathEvent(PlayerDeathEvent e){
        final Player p = e.getEntity();
        final Player killer = p.getKiller();

        e.setKeepInventory(true);
        e.setDeathMessage("");

        if(Main.getEventManager().getEventType().equals(EventType.GRIEF)){
            e.setKeepInventory(false);
        }


        killer.sendMessage(Main.getPrefix() + "§aDu hast " + p.getName() + " §agetötet!");
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        killer.setLevel(killer.getLevel() + 1);
        p.sendMessage(Main.getPrefix() + "§cDu wurdest von §6" + killer.getName() + " §cgetötet");
        for (Player all : Bukkit.getOnlinePlayers()){
            if(all != killer && all != p){
                all.sendMessage(Main.getPrefix() + "§c" + p.getName() + " §awurde von §6" + killer.getName() + " §agetötet");
            }
        }

        new BukkitRunnable(){
            public void run() {
                p.spigot().respawn();
                LocationUtils.tpWarp(p, "Spawn");
            }
        }.runTaskLater(Main.getInstance(), 1);
    }
}
