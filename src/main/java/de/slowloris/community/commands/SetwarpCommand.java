package de.slowloris.community.commands;

import de.slowloris.community.main.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetwarpCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            if(sender.hasPermission("community.setwarp")){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("Spawn")){
                        FileConfiguration cfg = Main.getPlugin().getConfig();
                        Location loc = ((Player) sender).getLocation();

                        cfg.set("Config.Spawn.World", loc.getWorld().getName());
                        cfg.set("Config.Spawn.X", loc.getX());
                        cfg.set("Config.Spawn.Y", loc.getY());
                        cfg.set("Config.Spawn.Z", loc.getZ());
                        cfg.set("Config.Spawn.Yaw", loc.getYaw());
                        cfg.set("Config.Spawn.Pitch", loc.getPitch());
                        Main.getPlugin().saveConfig();
                        sender.sendMessage("§aDu hast den Spawn gesetzt!");
                    }else if(args[0].equalsIgnoreCase("Buehne")){
                        FileConfiguration cfg = Main.getPlugin().getConfig();
                        Location loc = ((Player) sender).getLocation();

                        cfg.set("Config.Buehne.World", loc.getWorld().getName());
                        cfg.set("Config.Buehne.X", loc.getX());
                        cfg.set("Config.Buehne.Y", loc.getY());
                        cfg.set("Config.Buehne.Z", loc.getZ());
                        cfg.set("Config.Buehne.Yaw", loc.getYaw());
                        cfg.set("Config.Buehne.Pitch", loc.getPitch());
                        Main.getPlugin().saveConfig();
                        sender.sendMessage("§aDu hast den Spawn gesetzt!");
                    }else if(args[0].equalsIgnoreCase("Backstage")){
                        FileConfiguration cfg = Main.getPlugin().getConfig();
                        Location loc = ((Player) sender).getLocation();

                        cfg.set("Config.Backstage.World", loc.getWorld().getName());
                        cfg.set("Config.Backstage.X", loc.getX());
                        cfg.set("Config.Backstage.Y", loc.getY());
                        cfg.set("Config.Backstage.Z", loc.getZ());
                        cfg.set("Config.Backstage.Yaw", loc.getYaw());
                        cfg.set("Config.Backstage.Pitch", loc.getPitch());
                        Main.getPlugin().saveConfig();
                        sender.sendMessage("§aDu hast den Spawn gesetzt!");
                    }else {
                        sender.sendMessage("§c/setwarp <Buehne/Spawn/Backstage>");
                    }
                }else {
                    sender.sendMessage("§c/setwarp <Buehne/Spawn/Backstage>");
                }
            }else {
                sender.sendMessage("§cKeine Rechte :/");
            }
        }else {
            sender.sendMessage("§cNur als Spieler!");
        }
        return false;
    }
}
