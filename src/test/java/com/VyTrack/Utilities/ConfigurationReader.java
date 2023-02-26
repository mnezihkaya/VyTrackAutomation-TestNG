package com.VyTrack.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // Created the object of Properties
    private static Properties properties = new Properties();

    static {
        try {
            // opened the file in java memory: FileInputStream
           FileInputStream file = new FileInputStream("configuration.properties");
            // Loaded the properties object using FileInputStream object
            properties.load(file);
            //closed the file
            file.close();
        } catch (IOException e) {
            System.out.println("file not read from configuration.properties");
            e.printStackTrace();
        }

    }

    public static String getProperty(String word) {
        return properties.getProperty(word);
    }
}
