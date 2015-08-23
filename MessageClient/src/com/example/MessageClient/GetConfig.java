package com.example.MessageClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by adam on 23.08.15.
 */
public class GetConfig {

    public static String main() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(prop.getProperty("host"));
        return prop.getProperty("host");

    }
}
