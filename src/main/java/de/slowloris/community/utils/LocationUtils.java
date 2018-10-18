package de.slowloris.community.utils;

import de.slowloris.community.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LocationUtils {
    public static void tpWarp(Player p, String name){
        p.teleport(getLocation(name));
        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    }

    public static Location getLocation(String name){
        FileConfiguration cfg = Main.getInstance().getConfig();
        World world = Bukkit.getWorld(cfg.getString("Config.Locations." + name + ".World"));
        double x = cfg.getDouble("Config.Locations." + name + ".X");
        double y = cfg.getDouble("Config.Locations." + name + ".Y");
        double z = cfg.getDouble("Config.Locations." + name + ".Z");
        float yaw =  (float) cfg.getDouble("Config.Locations." + name + ".Yaw");
        float pitch = (float) cfg.getDouble("Config.Locations." + name + ".Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        return loc;
    }

    public static boolean isLocationSet(String name){
        return Main.getInstance().getConfig().isSet("Config.Locations." + name + ".World");
    }

    public static void setLocation(Location loc, String name){
        FileConfiguration cfg = Main.getInstance().getConfig();

        cfg.set("Config.Locations." + name + ".World", loc.getWorld().getName());
        cfg.set("Config.Locations." + name + ".X", loc.getX());
        cfg.set("Config.Locations." + name + ".Y", loc.getY());
        cfg.set("Config.Locations." + name + ".Z", loc.getZ());
        cfg.set("Config.Locations." + name + ".Yaw", loc.getYaw());
        cfg.set("Config.Locations." + name + ".Pitch", loc.getPitch());
        Main.getInstance().saveConfig();
    }
    public static boolean isEffectSpawnSet(){
        return LocationUtils.isLocationSet("EffectSpawn");
    }
    public static boolean isSpawnSet(){
        return LocationUtils.isLocationSet("Spawn");
    }
}
