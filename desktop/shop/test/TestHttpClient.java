package models.api;

public class TestHttpClient {

    public TestHttpClient() {
        HttpClient httpClient = new HttpClient();
        String res = httpClient.get("http://localhost:8000/api/products");
        int resCode = httpClient.getResponseCode();
        System.out.println("Kód: " + resCode);
        System.out.println("--- új lekérés--" + res);
    }
    
}
