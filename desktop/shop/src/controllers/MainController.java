package controllers;

import views.MainTab;
import views.MainView;

public class MainController {

    MainView mainView;
    MainTab mainTab;

    public MainController() {
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
        
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  
}
