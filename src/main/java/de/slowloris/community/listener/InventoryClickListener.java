package de.slowloris.community.listener;

import de.slowloris.community.events.EventType;
import de.slowloris.community.main.Main;
import de.slowloris.community.utils.LocationUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){

        if(e.getClickedInventory() == null) return;
        if(e.getCurrentItem() == null) return;

        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        if(!InteractListener.getCanbuild().contains(p)){
            e.setCancelled(true);
        }else {
            return;
        }
        if(e.getClickedInventory().getName().equalsIgnoreCase("§b§lTeleporter")){

            if(!clicked.hasItemMeta()) return;

            if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lBühne")){
                LocationUtils.tpWarp(p, "Buehne");
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lSpawn")){
                LocationUtils.tpWarp(p, "Spawn");
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lBackstage")){
                LocationUtils.tpWarp(p, "Backstage");
            }

        }else if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getEventInv().getName())){

            if(!clicked.hasItemMeta()) return;

            if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lEffekte")){
                p.openInventory(Main.getInventorys().getEffectInv());

            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpieler Events")){
                p.openInventory(Main.getInventorys().getPlayerEventsInv());

            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMusik")){
                p.openInventory(Main.getInventorys().getMusicInv());

            }

        }else if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getEffectInv().getName())){

            if(!clicked.hasItemMeta()) return;

            if(!LocationUtils.isEffectSpawnSet()){
                p.sendMessage(Main.getPrefix() + "§cKein Effekt Spawn gefunden!");
                return;
            }

            if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lFeuerwerk")){
                Main.getEffects().firework();
                p.closeInventory();
            }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lPfeile")){
                Main.getEffects().arrows();
                p.closeInventory();
            }
        }else if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getPlayerEventsInv().getName())){

            if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPvP")){
                Main.getEventManager().launchEvent(EventType.PVP);
                p.closeInventory();
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lGrief")){
                Main.getEventManager().launchEvent(EventType.GRIEF);
                p.closeInventory();
            }

        }else if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getMusicInv().getName()) ||e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getFavouritemusicInv().getName())){

            if(!clicked.hasItemMeta()) return;

            if(clicked.getType().equals(Material.RECORD_3)){

                File file = null;

                if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getFavouritemusicInv().getName())){
                    file = new File(Main.getInstance().getDataFolder() + "/music/favourites/" + clicked.getItemMeta().getDisplayName() + ".nbs");
                }else {
                    file = new File(Main.getInstance().getDataFolder() + "/music/" + clicked.getItemMeta().getDisplayName() + ".nbs");
                }

                Main.getMusicManager().playSong(file);

                if(e.getClickedInventory().getName().equalsIgnoreCase(Main.getInventorys().getFavouritemusicInv().getName())){
                    p.openInventory(Main.getInventorys().getFavouritemusicInv());
                }else {
                    p.openInventory(Main.getInventorys().getMusicInv());
                }

            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§cStoppen")){
                Main.getMusicManager().stop();
                p.openInventory(Main.getInventorys().getMusicInv());
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§6Pausieren")){
                Main.getMusicManager().pause();
                p.openInventory(Main.getInventorys().getMusicInv());
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aAbspielen")){
                Main.getMusicManager().play();
                p.openInventory(Main.getInventorys().getMusicInv());
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFavoriten")){
                p.openInventory(Main.getInventorys().getFavouritemusicInv());
            }else if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lAlle Lieder")){
                p.openInventory(Main.getInventorys().getMusicInv());
            }

        }
    }
}
