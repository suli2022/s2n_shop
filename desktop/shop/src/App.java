import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.api.AuthService;
import models.api.TestHttpClient;
import views.MainTab;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {

        new AuthService()
        .registry("tibi", "tibi@zold.lan", "titok");

        MainController mainController = new MainController();
        MainTab mainTab = mainController.getMainTab();
        
        Scene scene = new Scene(mainTab, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
