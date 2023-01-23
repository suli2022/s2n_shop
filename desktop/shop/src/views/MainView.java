package views;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.DataService;
import models.MariadbDatabase;
import models.Product;
import models.Restapi;

public class MainView extends VBox{
    Label productLabel;
    DataService dataService;
    Restapi restapi;
    TableView<Product> tableView;
    public MainView() {
        productLabel = new Label("Termékek");
        
        this.initData();
        this.initTable();
        this.getChildren().add(productLabel);
        this.getChildren().add(tableView);
    }
    private void initTable() {
        tableView = new TableView<>();
        
        TableColumn<Product, Integer> idCol = new TableColumn<>("Az");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Product, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Product, String> itemNumberCol = new TableColumn<>("Cikkszám");
        itemNumberCol.setMinWidth(50);
        itemNumberCol.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));

        TableColumn<Product, Integer> countCol = new TableColumn<>("Darab");
        countCol.setMinWidth(50);
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        
        TableColumn<Product, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.setItems(this.getProducts());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(itemNumberCol);
        tableView.getColumns().add(countCol);
        tableView.getColumns().add(priceCol);
        
    }
    private ObservableList<Product> getProducts() {
        ObservableList<Product> productList = 
        FXCollections.observableArrayList(restapi.getProducts());
        return productList;
    }
    private void initData() {
        this.restapi = new Restapi();
        dataService = new DataService(new MariadbDatabase(
            "shop",
            "shop",
            "titok"
        ));
        // ArrayList<Product> productList = dataService.getProducts();
        // System.out.println(productList.get(0).getName());
    }
    
}
