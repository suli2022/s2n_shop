package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Restapi {

    public Restapi() {
        // String str = this.getProductsAsString();
        // System.out.println(str);
    }
    
    public String getProductsAsString() {
        String text = "";
        try {
            text = this.tryGetProductsAsString();
        } catch (IOException e) {
            System.err.println("Hiba! A restapi lekérdezése sikertelen!");
        }
        return text;
    }
    public String tryGetProductsAsString() throws IOException {
        String host = "http://localhost:3000/api/";
        String endpoint = "products";
        String urlStr = host + endpoint;
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        int responseCode = http.getResponseCode();
        StringBuilder text = new StringBuilder();
        if(responseCode == 200) {
            InputStream inputStream = http.getInputStream();
            Reader reader = new   InputStreamReader (inputStream, "UTF-8");
            Scanner scanner = new Scanner(reader);            
            while(scanner.hasNextLine()) {
                text.append(scanner.nextLine());
            }
            scanner.close();
        }else {
            System.err.println("Hiba! A HTTP lekérdezés sikertelen!");
        }
        return text.toString();
    }
}
