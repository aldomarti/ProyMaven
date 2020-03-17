package net.kiranatos.examples.v03;

import java.io.IOException;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class CustomControl extends VBox {
    @FXML private TextField textField;

    public CustomControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Option2d_Control.fxml"));
        
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load(); 
        } catch (IOException ex) { System.out.println("Error..."); }
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }
    
    public StringProperty textProperty() {
        return textField.textProperty();
    }
    
    @FXML
    protected void doSomething() {
        System.out.println("Button clicked");
    }    
}
