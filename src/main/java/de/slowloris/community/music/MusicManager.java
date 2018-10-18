/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */


package de.slowloris.community.music;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import de.slowloris.community.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicManager {

    private MusicPlayer player;
    private List<Song> songs = new ArrayList<Song>();
    private List<Song> favourites = new ArrayList<Song>();

    public MusicManager(){
        for (File file : getMusicFolder().listFiles()){
            if(file.isFile()){
                Song song = NBSDecoder.parse(file);
                songs.add(song);
            }
        }

        for (File file : getFavouritesFolder().listFiles()){
            if(file.isFile()){
                Song song = NBSDecoder.parse(file);
                songs.add(song);
                favourites.add(song);
            }
        }
    }

    public List<Song> getSongs(){
        return songs;
    }

    public List<Song> getFavourites() {
        return favourites;
    }

    public File getMusicFolder(){
        File file = new File(Main.getInstance().getDataFolder() + "/music/" + File.separator);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    public File getFavouritesFolder(){
        File file = new File(Main.getInstance().getDataFolder() + "/music/favourites/" + File.separator);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    public void playSong(Song song){
        if(player != null){
            if(isPlaying()){
                stop();
            }
        }
        player = new MusicPlayer(song);
        player.getPlayer().setAutoDestroy(true);

        for (Player all : Bukkit.getOnlinePlayers()){
            player.getPlayer().addPlayer(all);
        }
        player.play();
    }

    public void playSong(File file){
        playSong(NBSDecoder.parse(file));
    }

    public boolean isPlaying(){
        if(player != null){
            return player.getPlayer().isPlaying();
        }else {
            return false;
        }
    }

    public boolean isStopped(){
        return player == null;
    }

    public void play(){
        player.play();
    }

    public void pause(){
        player.pause();
    }

    public void stop(){
        player.stop();
        player = null;
    }

    public Song getSong(){
        if(player != null){
            return player.getPlayer().getSong();
        }
        return null;
    }

    public String getFileName(){
        if(getSong() != null){
            return getSong().getPath().getName().replace(".nbs", "");
        }else {
            return "null";
        }
    }

}
