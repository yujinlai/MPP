package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class PrintRecordWindow extends GridPane {
	public PrintRecordWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrintRecord.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	 @FXML
	    protected void PrintRecord() {
	        System.out.println("The button was clicked!");
	    }
}
