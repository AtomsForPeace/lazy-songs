package com.messageserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 17/08/2015.
 */
public class GetFolders {
    File[] files;
    List<File> folders;
    String music_path;

    public GetFolders(String music_path) {
        this.music_path = music_path;
    }

    public List<File> GetFoldersList() {
        files = new File(this.music_path).listFiles();
        List<File> results = new ArrayList<File>();
        for (File file : files) {
            if (file.isDirectory()) {
                results.add(file);
            }
        }
        System.out.println(results);
        return results;
    }
}
