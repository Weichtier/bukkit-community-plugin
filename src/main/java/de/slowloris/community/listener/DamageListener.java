package de.slowloris.community.listener;

import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void DamageEvent(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(p.getLocation().getY() < 40){
                p.setHealth(0);
            }

            if(Main.getEventManager().getEventType().equals(EventType.PVP) ||Main.getEventManager().getEventType().equals(EventType.GRIEF)){
                e.setCancelled(false);
                return;
            }


            if (!InteractListener.getCanbuild().contains(p)){
                e.setCancelled(true);
                return;
            }

        }
    }
}
