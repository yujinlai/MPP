package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AddCopyWindow extends VBox {
	public AddCopyWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCopy.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	    protected void SearchBook() {
	        System.out.println("The button was clicked!");
	    }
	 
	 @FXML
	    protected void AddCopy() {
	        System.out.println("The button was clicked!");
	    }
}
