package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AddLibMemberWindow extends GridPane {
	public AddLibMemberWindow() {
		init();
	}

	public void init() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
		fxmlLoader.setRoot(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
}
