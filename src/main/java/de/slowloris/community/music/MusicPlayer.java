/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.community.music;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MusicPlayer {

    private SongPlayer sp;

    public MusicPlayer(Song song){
        sp = new RadioSongPlayer(song);
        sp.setAutoDestroy(true);

        for (Player all : Bukkit.getOnlinePlayers()){
            sp.addPlayer(all);
        }
    }

    public SongPlayer getPlayer(){
        return sp;
    }

    public void play(){
        sp.setPlaying(true);
    }

    public void pause(){
        sp.setPlaying(false);
    }

    public void stop(){
        sp.destroy();
    }

}
