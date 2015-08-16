package com.messageserver;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 25/07/2015.
 */
public class PlaySong {
    File[] files;
    List<File> folders;
    List<File> artist_folders;
    List<File> song_files;
    File song_file;
    String artist;
    String song;

    public PlaySong(String artist, String song){
        this.artist = artist;
        this.song = song;
    }

    public void doStuff() {
        GetSong get_song = new GetSong(this.artist, this.song);
        song_file = get_song.DoStuff();
        if (song_file != null) {
            play_it(song_file);
        }
    }

    private void play_it(File song_file){
        String path = song_file.getAbsolutePath();
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("C:\\Program Files\\VideoLAN\\VLC\\vlc " + "\"" + path + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
