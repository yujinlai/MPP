package ui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainWindow extends Stage {


	Stage primaryStage;
	VBox mainContainer = new VBox();
	String[] paneIDs = {"#addMemberPane","#checkoutBookPane","#addCopyPane","#addBookPane",
			"#printRecordPane","#CheckOverduePane"};

	
	public MainWindow(Stage ps) {		
		
		//Stage primaryStage = ps;
		setTitle("Library System");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			mainContainer = fxmlLoader.load();//FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			fxmlLoader.setController(this);
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
	}

	private void ShowPane(int index) {
		for(int i = 0; i < paneIDs.length; i++) {
			Pane pane = (Pane)mainContainer.lookup(paneIDs[i]);
			if(i == index) pane.setVisible(true);
			else pane.setVisible(false);
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
	
}
