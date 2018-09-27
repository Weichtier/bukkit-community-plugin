package de.slowloris.community.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    public static ArrayList<Player> fly = new ArrayList<Player>();
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("community.fly")){
                if(fly.contains(p)){
                    fly.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage("§7Flugmodus §cdeaktiviert");
                }else {
                    fly.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage("§7Flugmodus §aaktiviert");
                }
            }else {
                p.sendMessage("§cKeine Rechte :/");
            }
        }else {
            sender.sendMessage("§cKeine Rechte :/");
        }
        return false;
    }
}
