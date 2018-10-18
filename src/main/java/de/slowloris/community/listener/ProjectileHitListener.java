/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.listener;

import org.bukkit.Location;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;


public class ProjectileHitListener implements Listener {
    @EventHandler
    public void onDestroy(ProjectileHitEvent event){

        Location loc = event.getEntity().getLocation();
        final TNTPrimed tnt = loc.getWorld().spawn(loc.getBlock().getLocation(), TNTPrimed.class);
        tnt.setVelocity(new Vector(0, 0.5 ,0));
        tnt.setFuseTicks(10);

        event.getEntity().remove();
    }
}
