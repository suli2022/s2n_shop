package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTab extends TabPane {
    Tab productTab;
    Tab loginTab;
    Tab registryTab;
    public MainTab() {
        this.initComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.productTab = new Tab("Termékek");
        this.loginTab = new Tab("Belépés");
        this.registryTab = new Tab("Regisztráció");
    }
    private void addComponent() {
        this.getTabs().add(this.productTab);
        this.getTabs().add(this.loginTab);
        this.getTabs().add(this.registryTab);
    }
    
}
