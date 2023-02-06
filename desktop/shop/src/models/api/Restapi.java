package models.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Product;

public class Restapi {

    public Restapi() {
        // String str = this.getProductsAsString();
        // System.out.println("Adatok----------------");
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
        String host = "http://localhost:8000/api/";
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

    public ArrayList<Product> getProducts() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        System.out.println("érkezett" + text);
        Product[] productArray =  gson.fromJson(text, Product[].class);
        ArrayList<Product> productList = 
            new ArrayList<>(Arrays.asList(productArray));
        return productList;
    }
}
