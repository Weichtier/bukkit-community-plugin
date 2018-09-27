package de.slowloris.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void Build(BlockBreakEvent e){
        if(!InteractListener.getCanbuild().contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
