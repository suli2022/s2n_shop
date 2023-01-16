package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public MainWindow() {
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
