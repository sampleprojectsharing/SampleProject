package com.company.project.dataProviders;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private static String baseURL;
    private static String baseApiURL;


    public static PropertiesReader getInstance () {
        if (instance == null) {
            instance = new PropertiesReader();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + "config.properties");
        }

        baseURL = prop.getProperty("base_url");
        baseApiURL = prop.getProperty("base_api");

    }

    public String getBaseUrl() {
        return baseURL;
    }

    public String getBaseApiURL() {
        return baseApiURL;
    }
}
