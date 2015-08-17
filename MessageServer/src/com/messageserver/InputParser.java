package com.messageserver;

import java.io.File;
import java.util.List;

/**
 * Created by Adam on 25/07/2015.
 */
public class InputParser {
    public InputParser() {
        super();
    }

    public void take_input(String text_input, List<File> folderslist){
        String artist = "artist";
        String song = "song";
        String artist_title = text_input.substring(text_input.indexOf(artist) + 7, text_input.indexOf(song) - 1);
        String song_title = text_input.substring(text_input.indexOf(song) + 5);
        System.out.println(artist_title);
        System.out.println(artist_title.length());
        System.out.println(song_title);
        System.out.println(song_title.length());
        PlaySong playSong = new PlaySong(artist_title, song_title, folderslist);
        playSong.doStuff();
    }
}
