package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AddMemberWindow extends GridPane {
	public AddMemberWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	    protected void AddMember() {
	        System.out.println("The AddMember button was clicked!");
	    }
}
