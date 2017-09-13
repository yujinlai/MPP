package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CheckOverdueWindow extends VBox {
	public CheckOverdueWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckOverdue.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	    protected void CheckOverdue() {
	        System.out.println("The button was clicked!");
	    }
}
