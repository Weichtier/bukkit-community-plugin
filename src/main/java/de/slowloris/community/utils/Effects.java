/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.utils;

import de.slowloris.community.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Effects {

    public Effects(){
    }

    public void firework(){

        List<Location> loclist = new ArrayList<Location>();
        Location mainloc = getSpawn();
        loclist.add(mainloc);
        loclist.add(mainloc.add(1, 0, 1));
        loclist.add(mainloc.add(-1, 0, -1));
        loclist.add(mainloc.add(1, 0, -1));
        loclist.add(mainloc.add(-1, 0, 1));

        for (Location loc : loclist){

            final Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            FireworkMeta fwm = fw.getFireworkMeta();

            fwm.setPower(3);
            fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
            fw.setFireworkMeta(fwm);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                public void run() {
                    fw.detonate();
                }
            }, 25);
        }
    }

    public void arrows(){
        Arrow mainarrow = getSpawn().getWorld().spawnArrow(getSpawn().add(0, 5, 0), getSpawn().getDirection().setY(2), 2.0F, 2.0F);
        mainarrow.setBounce(true);
        mainarrow.setVelocity(getSpawn().getDirection().multiply(2));

        Vector velocity = mainarrow.getVelocity();
        double speed = velocity.length();
        Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
        double spray = 2D;

        for (int i = 0; i < 60; i++) {
            Arrow arrow = getSpawn().getWorld().spawnArrow(getSpawn().add(0, 5, 0), getSpawn().getDirection(), 2.0F, 2.0F);
            arrow.setVelocity(new Vector(direction.getX() + (Math.random() - 0.5) / spray, direction.getY() + (Math.random() - 0.5) / spray, direction.getZ() + (Math.random() - 0.5) / spray).normalize().multiply(speed));
        }
    }

    private Location getSpawn(){
        return LocationUtils.getLocation("EffectSpawn");
    }
}
