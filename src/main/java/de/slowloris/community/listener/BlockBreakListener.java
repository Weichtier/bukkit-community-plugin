package de.slowloris.community.listener;

import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBuild(BlockBreakEvent e){

        if(Main.getEventManager().getEventType().equals(EventType.GRIEF)){
            e.setCancelled(false);
            return;
        }

        if(!InteractListener.getCanbuild().contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
