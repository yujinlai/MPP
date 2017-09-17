package ui.controller;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.LoginWindow;
import ui.MainWindow;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class LoginController implements LibController {	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Text actiontarget;
	
	@FXML
	private Button button;
	
	public TextField getUsernameField() {
		return usernameField;
	}
	
	public PasswordField getPasswordField() {
		return passwordField;
	}

	public Text getActiontarget() {
		return actiontarget;
	}

	public Button getButton() {
		return button;
	}
	
	@FXML
	public void handleLogin() {		
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(LoginController.this);
			rules.applyRules(LoginController.this);
			ControllerInterface c = new SystemController();
			c.login(usernameField.getText().trim(), passwordField.getText().trim());
			usernameField.setText("");
			passwordField.setText("");
			((MainWindow)LoginWindow.INSTANCE.getMainWindow()).adjust();
			LoginWindow.INSTANCE.getMainWindow().show();				
			LoginWindow.INSTANCE.getPrimStage().hide();
		} catch (RuleException e1) {
			actiontarget.setText("All fields must be non-empty");
		} catch (LoginException e1) {
			actiontarget.setText("Either the user name or password is wrong");
		}
	}
}
