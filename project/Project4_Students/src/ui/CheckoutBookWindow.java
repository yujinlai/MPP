package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CheckoutBookWindow extends VBox {
	public CheckoutBookWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckoutBook.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	    protected void CheckoutBook() {
	        System.out.println("The button was clicked!");
	    }
}
