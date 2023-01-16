import java.util.ArrayList;

import models.DataService;
import models.MariadbDatabase;
import models.Product;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Adatbázis elérés");
        //TODO: Az adatbázis kapcsolat nem működik,
        // helyes adatokkal sem
        DataService dataService = new DataService( 
            new MariadbDatabase(
                "shop",
                "shop",
                "titok")  
                );
        
        ArrayList<Product> productList = dataService.getProducts();
        System.out.println(productList.get(0).getName());
    }
}
