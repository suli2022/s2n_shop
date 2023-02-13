package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Pro {
    String configFileName;
    Properties properties;
    public Pro() {
        this.configFileName = "config.properties";
        properties = new Properties();
    }

    public String getProperty(String key) {
        String property = "";
        try {
            property = this.tryGetProperty(key);
        } catch (IOException e) {
            String msg = "Hiba! A konfigurációs fájl olvasása sikertelen!";
            System.err.println(msg);
            property = msg;
        }
        return property;
    }
    public String tryGetProperty(String key) throws IOException {
        InputStream inputStream = 
            new FileInputStream(this.configFileName);
        this.properties.load(inputStream); 
        String property = this.properties.getProperty(key);
        return property;
    }
}
