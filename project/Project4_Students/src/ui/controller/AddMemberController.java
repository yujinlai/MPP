package ui.controller;

import java.util.ArrayList;
import java.util.List;

import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.AllMembersData;
import ui.AllMembersWindow;
import ui.LoginWindow;
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
	protected void addMember() {
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
	
	@FXML
	protected void allMembers() {
		try {
			AllMembersWindow allMembers = new AllMembersWindow(LoginWindow.INSTANCE.getMainWindow());
			ArrayList<AllMembersData> data = new ArrayList<AllMembersData>();
			ControllerInterface c = new SystemController();
			List<LibraryMember> all = c.allLibMembers();
			for (LibraryMember m : all) {
				data.add(new AllMembersData(m.getMemberId(), m.getFirstName(), m.getLastName()));
			}
			allMembers.setAllMembers(data);
			allMembers.Show();
		} catch (Exception ex) {
			// messageBar.setFill(Start.Colors.red);
			ex.printStackTrace();
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
