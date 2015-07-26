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
        String music_path = "\\\\THEMOIST\\Feuchtgebiete\\Music";
        files = new File(music_path).listFiles();
        folders = getFolders();
        artist_folders = matchArtist(artist);
        song_files = getFiles();
        song_file = getSong(song);
        if (song_file != null) {
            play_it(song_file);
        }
    }

    private List<File> getFolders() {
        List<File> results = new ArrayList<File>();
        for (File file : files) {
            if (file.isDirectory()) {
                results.add(file);
            }
        }
        System.out.println(results);
        return results;
    }

    private List<File> getFiles() {
        List<File> results = new ArrayList<File>();
        for (File folder : artist_folders) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    results.add(file);
                }
            }
        }
        System.out.println(results);
        return results;
    }

    private File getSong(String song){
        for (File file : song_files) {
            System.out.println(file.getName());
            if (file.getName().contains(song) || file.getName().toLowerCase().contains(song)) {
                return file;
            }
        }
        System.out.println("Song not found");
        return null;
    }

    private  List<File> matchArtist(String artist){
        List<File> results = new ArrayList<File>();
        for (File folder : folders) {
            if (folder.getName().contains(artist) || folder.getName().toLowerCase().contains(artist)){
                results.add(folder);
            }
        }
        return results;
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
