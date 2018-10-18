package de.slowloris.community.main;

import de.slowloris.community.commands.*;
import de.slowloris.community.events.EventManager;
import de.slowloris.community.listener.*;
import de.slowloris.community.music.MusicManager;
import de.slowloris.community.utils.Effects;
import de.slowloris.community.utils.InventoryUtils;
import de.slowloris.community.utils.Inventorys;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    private static Main instance;
    private static Inventorys inventorys;
    private static Effects effects;
    private static EventManager eventManager;
    private static MusicManager musicManager;
    private static final String PREFIX = "§8| §5Community §8§l» §7";
    @Override
    public void onEnable() {
        instance = this;
        inventorys = new Inventorys();
        effects = new Effects();
        eventManager = new EventManager();
        musicManager = new MusicManager();

        getConfig().options().copyDefaults(true);
        if(!getMusicManager().getMusicFolder().exists()){
            getMusicManager().getMusicFolder().mkdirs();
        }

        if(!getMusicManager().getFavouritesFolder().exists()){
            getMusicManager().getFavouritesFolder().mkdirs();
        }

        saveConfig();

        getLogger().info("§7Plugin erfolgreich §aaktiviert!");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new AchievementListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new SignChangeListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new ItemDropListener(), this);
        pm.registerEvents(new ItemPickupListener(), this);
        pm.registerEvents(new TeleportListener(), this);
        pm.registerEvents(new ItemHeldListener(), this);
        pm.registerEvents(new ReloadListener(), this);
        pm.registerEvents(new SneakListener(), this);
        pm.registerEvents(new ProjectileHitListener(), this);
        pm.registerEvents(new HungerListener(), this);
        getCommand("setwarp").setExecutor(new SetwarpCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("event").setExecutor(new EventCommand());


        InventoryUtils.setItemname("teleporter", "§8» §bTeleporter");
        InventoryUtils.setItemname("speedoff", "§8» §bSpeed §8| §cDeaktiviert");
        InventoryUtils.setItemname("speedon", "§8» §bSpeed §8| §aAktiviert");
        InventoryUtils.setItemname("flyon", "§8» §eFlugmodus §8| §aAktiviert");
        InventoryUtils.setItemname("flyoff", "§8» §eFlugmodus §8| §cDeaktiviert");
        InventoryUtils.setItemname("hideron", "§8» §6Spieler Anzeigen §8| §aAlle");
        InventoryUtils.setItemname("hidervip", "§8» §6Spieler Anzeigen §8| §5VIP");
        InventoryUtils.setItemname("hideroff", "§8» §6Spieler Anzeigen §8| §cNiemand");
    }

    @Override
    public void onDisable() {
        getLogger().info("§7Plugin erfolgreich §cdeaktiviert");
    }

    public static Main getInstance() {
        return instance;
    }

    public static Inventorys getInventorys() {
        return inventorys;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static Effects getEffects() {
        return effects;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static MusicManager getMusicManager() {
        return musicManager;
    }
}
