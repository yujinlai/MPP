package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AddBookCopyWindow extends VBox {
	
	public AddBookCopyWindow() {
		init();
	}
	
	public void init() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCopy.fxml"));
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

	}
}
