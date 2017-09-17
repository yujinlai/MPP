package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class PrintRecordWindow extends GridPane {
	public PrintRecordWindow() {
		init();
	}

	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrintRecord.fxml"));
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
