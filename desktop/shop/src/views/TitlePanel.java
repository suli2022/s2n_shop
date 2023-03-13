package views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TitlePanel extends HBox {
    Label label;
    public TitlePanel() {
        this.label = new Label();
        this.initComponent();
    }
    private void initComponent() {
        this.setAlignment(Pos.CENTER);        
        this.getChildren().add(this.label);
    }
    public void setText(String text) {
        this.label.setText(text);
    }
    public String getText(){
        return this.label.getText();
    }
}

