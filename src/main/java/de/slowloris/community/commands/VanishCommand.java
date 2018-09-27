/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {
    private static ArrayList<Player> inVanish = new ArrayList<Player>();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("community.vanish")){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("list")){
                        p.sendMessage("§aSpieler im Vanish:");
                        for (Player invanish : inVanish){
                            p.sendMessage("§7" + invanish.getName());
                        }
                        p.sendMessage("§7Insgesamt §e" + inVanish.size() + " §7Spieler im Vanish");
                        return false;
                    }else {
                        if(p.hasPermission("community.vanish.other")){
                            Player target = Bukkit.getPlayer(args[0]);
                            if(target == null){
                                p.sendMessage("§cSpieler ist Offline");
                                return false;
                            }
                            vanish(target, p);
                        }else {
                            p.sendMessage("§cKeine Rechte :/");
                        }
                    }
                }else if(args.length == 0){
                    vanish(p, p);
                }else {
                    p.sendMessage("§c/vanish [Spielername]");
                }
            }else {
                p.sendMessage("§cKeine Rechte :/");
            }
        }else {
            sender.sendMessage("§cNur als Spieler");
        }
        return false;
    }

    public static ArrayList<Player> getInVanish() {
        return inVanish;
    }
    public static void vanish(Player target, Player sender){
        if (inVanish.contains(target)){
            inVanish.remove(target);
            show(target);
            if(target != sender){
                target.sendMessage("§7Dein Vanish wurde von §e" + sender.getName() + " §cdeaktiviert");
            }
            sender.sendMessage("§7Vanish §cdeaktiviert");
        }else {
            inVanish.add(target);
            sender.sendMessage("§7Vanish §aaktiviert");
            hide(target);
            if(target != sender){
                target.sendMessage("§7Dein Vanish wurde von §e" + sender.getName() + " §aaktiviert");
            }
        }
    }
    public static void hide(Player p){
        for (Player all : Bukkit.getOnlinePlayers()){
            all.hidePlayer(p);
        }
    }
    public static void show(Player p){
        for (Player all : Bukkit.getOnlinePlayers()){
            all.showPlayer(p);
        }
    }
}
