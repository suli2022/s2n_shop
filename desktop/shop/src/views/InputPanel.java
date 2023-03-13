package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class InputPanel extends HBox {
    Label label;
    TextField field;
    public InputPanel() {
        this.initComponent();
        this.setComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.label = new Label();
        this.field = new TextField();
    }
    private void setComponent() {
        HBox.setMargin(this.label, new Insets(10, 10, 10, 10));
        HBox.setMargin(this.field, new Insets(10, 10, 10, 10));
        this.label.setMinWidth(100);
        this.label.setAlignment(Pos.CENTER_RIGHT);
    }
    private void addComponent() {
        this.getChildren().add(this.label);
        this.getChildren().add(this.field);
    }
    public String getText() {
        return label.getText();
    }
    public void setText(String text) {
        this.label.setText(text);
    }
    public String getValue() {
        return field.getText();
    }
    public void setValue(String value) {
        this.field.setText(value);
    }
    
    
}
