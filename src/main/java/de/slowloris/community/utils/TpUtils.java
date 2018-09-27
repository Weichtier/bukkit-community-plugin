package de.slowloris.community.utils;

import de.slowloris.community.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class TpUtils {
    public static void tpWarp(Player p, String name){
        FileConfiguration cfg = Main.getPlugin().getConfig();
        World world = Bukkit.getWorld(cfg.getString("Config." + name + ".World"));
        double x = cfg.getDouble("Config." + name + ".X");
        double y = cfg.getDouble("Config." + name + ".Y");
        double z = cfg.getDouble("Config." + name + ".Z");
        float yaw =  (float) cfg.getDouble("Config." + name + ".Yaw");
        float pitch = (float) cfg.getDouble("Config." + name + ".Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        p.teleport(loc);
        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    }
}
