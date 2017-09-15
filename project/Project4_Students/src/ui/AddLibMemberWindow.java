package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AddLibMemberWindow extends GridPane {
	public AddLibMemberWindow() {
		init();
	}

	@FXML
	protected void AddMember() {
		System.out.println("The AddMember button was clicked!");
	}

	public void init() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
}
