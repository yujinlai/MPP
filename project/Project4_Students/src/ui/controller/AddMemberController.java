package ui.controller;

import business.ControllerInterface;
import business.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class AddMemberController implements LibController {
	@FXML
	private TextField id;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField street;
	
	@FXML
	private TextField city;

	@FXML
	private TextField state;
	
	@FXML
	private TextField zipCode;

	@FXML
	private TextField telephone;
	
	@FXML
	private Text actiontarget;
	
	public TextField getId() {
		return id;
	}

	public TextField getFirstName() {
		return firstName;
	}

	public TextField getLastName() {
		return lastName;
	}

	public TextField getStreet() {
		return street;
	}

	public TextField getCity() {
		return city;
	}

	public TextField getState() {
		return state;
	}

	public TextField getZipCode() {
		return zipCode;
	}

	public TextField getTelephone() {
		return telephone;
	}

	public Text getActiontarget() {
		return actiontarget;
	}
	
	@FXML
	protected void AddMember() {
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(AddMemberController.this);
			rules.applyRules(AddMemberController.this);
			ControllerInterface c = new SystemController();
			c.addLibraryMember(id.getText().trim(), firstName.getText().trim(), lastName.getText().trim(), street.getText().trim(), 
					city.getText().trim(), state.getText().trim(), zipCode.getText().trim(), telephone.getText().trim());
			emptyAllFields();
			actiontarget.setText("Add member succee");
		} catch (RuleException e) {
			actiontarget.setText(e.getMessage());
		} 
	}
	
	private void emptyAllFields() {
		id.setText("");
		firstName.setText("");
		lastName.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zipCode.setText("");
		telephone.setText("");
	}
}
