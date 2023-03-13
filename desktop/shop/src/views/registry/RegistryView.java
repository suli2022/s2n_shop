package views.registry;

import javafx.scene.layout.VBox;
import views.InputPanel;
import views.PassPanel;

public class RegistryView extends VBox {
    InputPanel nameInput;
    InputPanel emailInput;
    PassPanel passInput;
    PassPanel passAgainInput;
    public RegistryView() {
        this.initComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.nameInput = new InputPanel();
        this.emailInput = new InputPanel();
        this.passInput = new PassPanel();
        this.passAgainInput = new PassPanel();
    }
    private void addComponent() {
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.passInput);
        this.getChildren().add(this.passAgainInput);
    }
    
}
