package com.perficient.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static Properties loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/application.properties"
                );
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error loading properties file", e);
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }
}

