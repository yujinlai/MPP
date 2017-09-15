package ui;

import java.io.IOException;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.rulesets.RuleException;
import ui.rulesets.RuleSet;
import ui.rulesets.RuleSetFactory;

public class MainWindow extends Stage {
	Stage primaryStage;
	VBox mainContainer = new VBox();
	String[] paneIDs = {"#addMemberPane","#checkoutBookPane","#addCopyPane","#addBookPane",
			"#printRecordPane","#CheckOverduePane"};
	
	@FXML
	private Label welcomeLable;
	
	@FXML
	private Button logout;

	public MainWindow(Stage ps) {
		init();
	}

	private void ShowPane(int index) {
		for (int i = 0; i < paneIDs.length; i++) {
			Pane pane = (Pane) mainContainer.lookup(paneIDs[i]);
			if (i == index)
				pane.setVisible(true);
			else
				pane.setVisible(false);
		}
	}

	private void AddButtonHandlers() {
		String[] ids = {"#addMemberBtn","#checkoutBookBtn","#addCopyBtn","#addBookBookBtn",
				"#printRecordBtn","#checkoutOverdueBtn"};
		for(int i = 0; i < ids.length; i++) {
			Button checkoutBookBtn = (Button)mainContainer.lookup(ids[i]);
			final int index = i;
			checkoutBookBtn.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		try {
	        			ShowPane(index);
	        		} catch(Exception ex) {
	        			//messageBar.setFill(Start.Colors.red);
	        			ex.printStackTrace();
	        		}

	        	}
	        });
		}
	}

	public void init() {
		setTitle("Library System");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			fxmlLoader.setController(this);    
			mainContainer = fxmlLoader.load();//FXMLLoader.load(getClass().getResource("MainWindow.fxml"));      
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Color color = Color.rgb(200, 0, 0, 0.35);
	    BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY,
	            Insets.EMPTY);
	    Background background = new Background(fill);
	    Pane funcPane = (Pane)mainContainer.lookup("#FuncBtnPane");
	    funcPane.setBackground(background);

	    this.setResizable(false);
		AddButtonHandlers();
		ShowPane(0);
		Scene scene = new Scene(mainContainer, 800, 600,Color.BEIGE);
		setScene(scene);
		
		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {		
				LoginWindow.INSTANCE.reInit();
			}
		});
	}
	
	public void updateWelcomeInfo() {
		welcomeLable.setText("Welcome " + LoginWindow.INSTANCE.getUsernameField().getText());
	}
}
