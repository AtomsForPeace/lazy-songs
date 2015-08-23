package com.messageserver;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

/**
 * Created by Adam on 24/07/2015.
 */
public class Server {
    public static void main(String[] args){
        String music_path = GetConfig.main();
        GetFolders folders = new GetFolders(music_path);
        final List<File> folderslist = folders.GetFoldersList();
        Thread t = new Thread(){

            @Override
            public void run() {
                System.out.println("Server up and running!");
                try {
                    ServerSocket ss = new ServerSocket(7000);
                    while(true){
                        System.out.println("Here1");
                        Socket s = ss.accept();
                        System.out.println("Here2");
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        System.out.println("Here3");
                        String inputs = dis.readUTF();
                        System.out.println("Here4");
                        System.out.println("Received: " + inputs);
                        InputParser parse_them = new InputParser();
                        parse_them.take_input(inputs, folderslist);
                        dis.close();
                        s.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
