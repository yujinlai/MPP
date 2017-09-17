package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.LoginWindow;

public class MainController implements LibController {
	@FXML
	private Label welcomeLable;
	
	@FXML
	private Button logout;
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		welcomeLable.setText("Welcome ");
	}
	
	@FXML
	public void logout() {
		LoginWindow.INSTANCE.getMainWindow().close();
		LoginWindow.INSTANCE.getPrimStage().show();
	}
}
