package de.slowloris.community.commands;

import de.slowloris.community.main.Main;
import de.slowloris.community.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetwarpCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("pt.setwarp")){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("Spawn")){
                        LocationUtils.setLocation(p.getLocation(), "Spawn");
                        p.sendMessage(Main.getPrefix() + "§aDu hast den Spawn gesetzt!");

                    }else if(args[0].equalsIgnoreCase("Buehne")){
                        LocationUtils.setLocation(p.getLocation(), "Buehne");
                        p.sendMessage(Main.getPrefix() + "§aDu hast den Spawn gesetzt!");

                    }else if(args[0].equalsIgnoreCase("Backstage")){
                        LocationUtils.setLocation(p.getLocation(), "Backstage");
                        p.sendMessage(Main.getPrefix() + "§aDu hast den Spawn gesetzt!");

                    }else if(args[0].equalsIgnoreCase("EffektSpawn")){
                        LocationUtils.setLocation(p.getLocation(), "EffectSpawn");
                        p.sendMessage(Main.getPrefix() + "§aDu hast den Effekt Spawn gesetzt!");

                    }else {
                        p.sendMessage("§c/setwarp <Buehne/Spawn/Backstage/EffektSpawn>");
                    }
                }else {
                    p.sendMessage("§c/setwarp <Buehne/Spawn/Backstage/EffektSpawn>");
                }
            }else {
                p.sendMessage("§cKeine Rechte :/");
            }
        }else {
            sender.sendMessage("§cNur als Spieler!");
        }
        return false;
    }
}
