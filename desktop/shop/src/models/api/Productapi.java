package models.api;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Pro;
import models.Product;

public class Productapi {

    public Productapi() {
    }

    public String getProductsAsString() {
        Pro pro = new Pro();
                
        String host = pro.getProperty("restapi.host");
        String endpoint = "products";
        String urlStr = host + endpoint;
        HttpClient http = new HttpClient();
        String res = http.get(urlStr);
        return res;
    }

    public ArrayList<Product> getProducts() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        // System.out.println("érkezett" + text);
        Product[] productArray =  gson.fromJson(text, Product[].class);
        ArrayList<Product> productList = 
            new ArrayList<>(Arrays.asList(productArray));
        return productList;
    }
}
