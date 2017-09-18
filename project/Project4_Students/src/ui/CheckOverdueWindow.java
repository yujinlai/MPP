package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CheckOverdueWindow extends VBox {
	public CheckOverdueWindow() {
		init();
	}
	
	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckOverdue.fxml"));
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
