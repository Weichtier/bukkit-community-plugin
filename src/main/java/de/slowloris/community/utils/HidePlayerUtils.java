/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HidePlayerUtils {

    public static void hidePlayer(Player p) {
        for(Player all : Bukkit.getOnlinePlayers()) {
            p.hidePlayer(all);
        }
    }
    public static void showPlayer(Player p) {
        for(Player all : Bukkit.getOnlinePlayers()) {
            p.showPlayer(all);
        }
    }
    public static void hideVIP(Player p){
        for(Player all : Bukkit.getOnlinePlayers()){
            if(!all.hasPermission("pt.vip")){
                p.hidePlayer(all);
            }
        }
    }
}
