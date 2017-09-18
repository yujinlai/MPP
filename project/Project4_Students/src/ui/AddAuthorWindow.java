package ui;

import java.io.IOException;

import business.Address;
import business.Author;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.controller.LibController;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class AddAuthorWindow extends GridPane implements LibController {
	GridPane mainContainer = new GridPane();
	final Stage stage = new Stage();
	
	AddBookWindow abWindow;


	public AddBookWindow getAbWindow() {
		return abWindow;
	}

	public void setAbWindow(AddBookWindow abWindow) {
		this.abWindow = abWindow;
	}

	public AddAuthorWindow(final Stage stg) {
		init(stg);
	}
	
	public void init(final Stage stg) {

		//Initialize the Stage with type of modal
		stage.initModality(Modality.APPLICATION_MODAL);
		//Set the owner of the Stage 
		stage.initOwner(stg);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAuthor.fxml"));
        try {
        	mainContainer = fxmlLoader.load();
        	Button ok = (Button)mainContainer.lookup("#ok");
        	Button cancel = (Button)mainContainer.lookup("#cancel");
        	ok.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		try {
	        			actiontarget = (Text) mainContainer.lookup("#actiontarget");
	        			firstName = (TextField) mainContainer.lookup("#firstName");
	        			lastName = (TextField) mainContainer.lookup("#lastName");
	        			credentials = (TextField) mainContainer.lookup("#credentials");
	        			phoneNumber = (TextField) mainContainer.lookup("#phoneNumber");
	        			bio = (TextField) mainContainer.lookup("#bio");
	        			street = (TextField) mainContainer.lookup("#street");
	        			city = (TextField) mainContainer.lookup("#city");
	        			state = (TextField) mainContainer.lookup("#state");
	        			zip = (TextField) mainContainer.lookup("#zip");
	        			RuleSet rules = RuleSetFactory.getRuleSet(AddAuthorWindow.this);
	        			rules.applyRules(AddAuthorWindow.this);
	        			Address addr = new Address(street.getText(),city.getText(),state.getText(),zip.getText());
	        			Author author = new Author(firstName.getText(),lastName.getText(),phoneNumber.getText(),
	        					addr, bio.getText(), credentials.getText());
	        			actiontarget.setText("add book success");
	        			abWindow.SetAuthors(author);
	        			stage.close();
	        		} catch(RuleException ex) {
	        			actiontarget.setText(ex.getMessage());
	        		}
	        	}
	        });
        	cancel.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		try {	        			
	        			stage.close();
	        		} catch(Exception ex) {
	        			//messageBar.setFill(Start.Colors.red);
	        			ex.printStackTrace();
	        		}

	        	}
	        });
        	
	        Scene scene = new Scene(mainContainer, 300, 600,Color.BEIGE);
	        stage.setScene(scene);
	         
	    } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public void Show() {
		stage.show();
	}
	
	public void SetAuthor(Author a) {
		TextField firstName = (TextField) mainContainer.lookup("#firstName");
		TextField lastName = (TextField) mainContainer.lookup("#lastName");
		TextField credentials = (TextField) mainContainer.lookup("#credentials");
		TextField phoneNumber = (TextField) mainContainer.lookup("#phoneNumber");
		TextField bio = (TextField) mainContainer.lookup("#bio");
		TextField street = (TextField) mainContainer.lookup("#street");
		TextField city = (TextField) mainContainer.lookup("#city");
		TextField state = (TextField) mainContainer.lookup("#state");
		TextField zip = (TextField) mainContainer.lookup("#zip");
		
		firstName.setText(a.getFirstName());
		lastName.setText(a.getLastName());
		phoneNumber.setText(a.getTelephone());
		street.setText(a.getAddress().getStreet());
		city.setText(a.getAddress().getCity());
		state.setText(a.getAddress().getState());
		zip.setText(a.getAddress().getZip());
		bio.setText(a.getBio());
		credentials.setText(a.getCredentials());
	}

	@FXML
	private TextField firstName;
	
	public TextField getFirstName() {
		return firstName;
	}

	public void setFirstName(TextField firstName) {
		this.firstName = firstName;
	}

	public TextField getLastName() {
		return lastName;
	}

	public void setLastName(TextField lastName) {
		this.lastName = lastName;
	}

	public TextField getCredentials() {
		return credentials;
	}

	public void setCredentials(TextField credentials) {
		this.credentials = credentials;
	}

	public TextField getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(TextField phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public TextField getBio() {
		return bio;
	}

	public void setBio(TextField bio) {
		this.bio = bio;
	}

	public TextField getStreet() {
		return street;
	}

	public void setStreet(TextField street) {
		this.street = street;
	}

	public TextField getCity() {
		return city;
	}

	public void setCity(TextField city) {
		this.city = city;
	}

	public TextField getState() {
		return state;
	}

	public void setState(TextField state) {
		this.state = state;
	}

	public TextField getZip() {
		return zip;
	}

	public void setZip(TextField zip) {
		this.zip = zip;
	}


	@FXML
	private TextField lastName;
	
	@FXML
	private TextField credentials;
	
	@FXML
	private TextField phoneNumber;
	
	@FXML
	private TextField bio;
	
	@FXML
	private TextField street;
	
	@FXML
	private TextField city;
	
	@FXML
	private TextField state;
	
	@FXML
	private TextField zip;
	
	@FXML
	private Text actiontarget;
	
	public Text getActiontarget() {
		return actiontarget;
	}

	public void setActiontarget(Text actiontarget) {
		this.actiontarget = actiontarget;
	}

}
