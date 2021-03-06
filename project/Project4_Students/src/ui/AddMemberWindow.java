package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddMemberWindow extends GridPane {
	Stage stg;
	GridPane mainContainer = new GridPane();
	public Stage getStg() {
		return stg;
	}

	public void setStg(Stage stg) {
		this.stg = stg;
	}

	public AddMemberWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
        	mainContainer = fxmlLoader.load();                      
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	 protected void addMember() {
	     System.out.println("The AddMember button was clicked!");
	 }
}
