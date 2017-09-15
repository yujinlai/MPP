package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AddBookWindow extends GridPane {
	
	public AddBookWindow() {
		init();
	}

	@FXML
	protected void AddBook() {
		System.out.println("The button was clicked!");
	}
	
	@FXML
	protected void EditAuthors() {
		System.out.println("The button was clicked!");
	}

	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
