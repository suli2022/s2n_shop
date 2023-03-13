package models.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckApi {
    int responseCode;

    public boolean checkUrl(String urlStr) {
        try {
            tryCheckUrl(urlStr);
            return true;
        } catch (IOException e) {
            System.err.println("Hiba! Nemérhető el!");
            return false;
        }
    }
    public void tryCheckUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();
        this.responseCode = http.getResponseCode();
    }

}
