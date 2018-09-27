package de.slowloris.community.main;

import de.slowloris.community.commands.BuildCommand;
import de.slowloris.community.commands.FlyCommand;
import de.slowloris.community.commands.SetwarpCommand;
import de.slowloris.community.commands.VanishCommand;
import de.slowloris.community.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
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
        getCommand("setwarp").setExecutor(new SetwarpCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("§7Plugin erfolgreich §cdeaktiviert");
    }

    public static Main getPlugin() {
        return plugin;
    }
}
