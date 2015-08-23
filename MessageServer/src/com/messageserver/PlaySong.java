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
    List<File> folderslist;

    public PlaySong(String artist, String song, List<File> folderslist){
        this.artist = artist;
        this.song = song;
        this.folderslist = folderslist;
    }

    public void doStuff() {
        GetSong get_song = new GetSong(this.artist, this.song, folderslist);
        song_file = get_song.DoStuff();
        if (song_file != null) {
            play_it(song_file);
        }
    }

    private void play_it(File song_file){
        String path = song_file.getAbsolutePath();
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[] {"vlc", "--playlist-enqueue", "--one-instance", "--one-instance-when-started-from-file", "-Z", "-L", "\"", path, "\"" });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
