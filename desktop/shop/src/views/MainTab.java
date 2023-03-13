package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import views.registry.RegistryView;

public class MainTab extends TabPane {
    Tab productTab;
    Tab loginTab;
    Tab registryTab;
    MainView mainView;
    RegistryView registryView;
    public MainTab(MainView mainView ) {
        this.mainView = mainView;
        this.registryView = new RegistryView();
        this.initComponent();
        this.addComponent();
        
    }
    private void initComponent() {
        this.productTab = new Tab("Termékek", this.mainView);
        this.loginTab = new Tab("Belépés");
        this.registryTab = new Tab("Regisztráció", this.registryView);
    }
    private void addComponent() {
        this.getTabs().add(this.productTab);
        this.getTabs().add(this.loginTab);
        this.getTabs().add(this.registryTab);
    }
    
}
