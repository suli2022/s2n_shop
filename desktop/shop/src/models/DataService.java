package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataService {
    Database database;
    Connection con;
    public DataService(Database database) {
        this.database = database;
        con = this.database.connect();
    }
    public ArrayList<Product> getProducts() {
        ArrayList<Product> productList = null;
        try {
            productList = tryGetProducts();
        } catch (SQLException e) {
            System.err.println("Hiba! A termékek lekérdezése sikertelen!");
        }
        return productList;
    }
    public ArrayList<Product> tryGetProducts() throws SQLException {
        String sql = "select * from products";
        Statement statement = this.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Product> productList = new ArrayList<>();
        while(resultSet.next()) {
            Product product = new Product();
            product.id = resultSet.getInt("id");
            product.name = resultSet.getString("name");
            product.itemNumber = resultSet.getString("itemNumber");
            product.count = resultSet.getInt("count");
            product.price = resultSet.getDouble("price");
            productList.add(product);
        }
        return productList;        
    }
}
