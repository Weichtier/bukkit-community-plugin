package de.slowloris.community.commands;

import de.slowloris.community.listener.InteractListener;
import de.slowloris.community.listener.JoinListener;
import de.slowloris.community.utils.InventoryUtils;
import de.slowloris.community.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(p.hasPermission("community.build")){
                    if(!InteractListener.getCanbuild().contains(p)){
                        InteractListener.getCanbuild().add(p);
                        if(FlyCommand.fly.contains(p)){
                            FlyCommand.fly.remove(p);
                        }
                        if(!InventoryUtils.getSpeedoff().contains(p)){
                            p.setWalkSpeed(0.2F);
                            InventoryUtils.getSpeedoff().add(p);
                        }
                        p.getInventory().clear();
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("§7Baumodus §aaktiviert");
                    }else {
                        InteractListener.getCanbuild().remove(p);
                        p.setGameMode(GameMode.SURVIVAL);
                        p.getInventory().clear();
                        InventoryUtils.giveItems(p);
                        p.sendMessage("§7Baumodus §cdeaktiviert");
                    }
                }else {
                    p.sendMessage("§cKeine Rechte :/");
                }
            }else if(args.length == 1){
                if(p.hasPermission("community.build.other")){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null){
                        p.sendMessage("§cDieser Spieler ist nicht Online!");
                        return false;
                    }
                    if(!InteractListener.getCanbuild().contains(target)){
                        InteractListener.getCanbuild().add(target);
                        target.getInventory().clear();
                        target.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("§7Baumodus §aaktiviert");
                    }else {
                        InteractListener.getCanbuild().remove(target);
                        target.setGameMode(GameMode.CREATIVE);
                        target.getInventory().clear();
                        InventoryUtils.giveItems(target);
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("§7Baumodus §cdeaktiviert");
                    }
                }else {
                    p.sendMessage("§cKeine Rechte :/");
                }
            }
        }else {
            sender.sendMessage("§cNur als Spieler!");
        }
        return false;
    }
}
