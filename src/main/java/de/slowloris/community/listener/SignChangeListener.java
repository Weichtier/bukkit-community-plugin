package de.slowloris.community.listener;

import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements Listener {
    @EventHandler
    public void SignChangeEvent(SignChangeEvent e){
        if(e.getLine(0).equalsIgnoreCase("[FINISH]") && !e.getLine(1).equalsIgnoreCase("")){
            String name = e.getLine(1);
            e.setLine(0, "§5Glückwunsch!");
            e.setLine(1, "§7du hast das");
            e.setLine(2, "§a" + name + " JNR");
            e.setLine(3, "§6Geschafft :D");
        }else if(e.getLine(0).equalsIgnoreCase("[MUSIK]")){
            if(e.getLine(1).equalsIgnoreCase("")){
                e.setLine(0, "§cFEHLER BEIM");
                e.setLine(1, "§CERSTELLEN:");
                e.setLine(2, "§3FALSCHER");
                e.setLine(3, "§3SYNTAX");
                return;
            }
            String name = e.getLine(1);
            e.setLine(0, "§5Musik");
            e.setLine(1, "§8§m----------");
            e.setLine(2, "§9" + name);
            e.setLine(3, "");
        }else if(e.getLine(0).equalsIgnoreCase("[EFFECT]")){
            if(e.getLine(1).equalsIgnoreCase("")){
                e.setLine(0, "§cFEHLER BEIM");
                e.setLine(1, "§CERSTELLEN:");
                e.setLine(2, "§3FALSCHER");
                e.setLine(3, "§3SYNTAX");
                return;
            }
            String name = e.getLine(1);
            e.setLine(0, "§5Effekt");
            e.setLine(1, "§8§m----------");
            e.setLine(2, "§9" + name);
            e.setLine(3, "");
        }
    }
}
