package lesson6.labs.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final String NAME = "name";
	private static final String STREET = "street";
	private static final String CITY = "city";
	private static final String ZIP = "zip";
	private static int currentPos = 0;
	

    public static void main(String[] args) {
        launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Customer Information");
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 5, 25));
		
        VBox vbBtn1 = new VBox(5);
        TextField nameTextField = new TextField();
        vbBtn1.getChildren().addAll(new Label("Name:"), nameTextField);
        VBox vbBtn2 = new VBox(5);
        TextField streetTextField = new TextField();
        vbBtn2.getChildren().addAll(new Label("Street:"), streetTextField);
        VBox vbBtn3 = new VBox(5);
        TextField cityTextField = new TextField();
        vbBtn3.getChildren().addAll(new Label("City:"), cityTextField);
        HBox hbBtn1 = new HBox(20);
        hbBtn1.getChildren().addAll(vbBtn1,vbBtn2,vbBtn3);
        grid.add(hbBtn1, 0, 0);
        
        VBox vbBtn4 = new VBox(5);
        TextField stateTextField = new TextField();
        vbBtn4.getChildren().addAll(new Label("State:"), stateTextField);
        VBox vbBtn5 = new VBox(5);
        TextField zipTextField = new TextField();
        vbBtn5.getChildren().addAll(new Label("Zip:"), zipTextField);
        HBox hbBtn2 = new HBox(20);
        hbBtn2.setAlignment(Pos.CENTER);
        hbBtn2.getChildren().addAll(vbBtn4,vbBtn5);
        grid.add(hbBtn2, 0, 2);
        

        List<Customer> customers = allCustomersBeginWithMa();
        if(customers != null && customers.size() > currentPos) {
        	Customer cus = customers.get(currentPos);
        	nameTextField.setText(cus.getName());
        	streetTextField.setText(cus.getStreet());
        	cityTextField.setText(cus.getCity());
        	zipTextField.setText(cus.getZip());
        }
        
        Button btn = new Button("Submit");
        Button btn0 = new Button("Next");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn0);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 6);
        btn0.setPrefWidth(100);
        btn0.setPrefHeight(40);
        btn0.setFont(Font.font(null, FontWeight.BOLD, 17));
        btn.setPrefWidth(100);
        btn.setPrefHeight(40);
        btn.setFont(Font.font(null, FontWeight.BOLD, 17));
        
		btn0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (btn0.getText().equals("Next")) {
					if (customers != null && customers.size() > currentPos + 1) {
						if (btn0.getText().equals("Next")) {
							currentPos++;
							Customer cus = customers.get(currentPos);
							nameTextField.setText(cus.getName());
							streetTextField.setText(cus.getStreet());
							cityTextField.setText(cus.getCity());
							zipTextField.setText(cus.getZip());
							if (currentPos == customers.size() - 1)
								btn0.setText("Prev");
						}
					} 
				}else {
					currentPos--;
					Customer cus = customers.get(currentPos);
					nameTextField.setText(cus.getName());
					streetTextField.setText(cus.getStreet());
					cityTextField.setText(cus.getCity());
					zipTextField.setText(cus.getZip());
					if (currentPos == 0)
						btn0.setText("Next");
				}
			}
		});
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        	   System.out.println(nameTextField.getText());
        	   System.out.println(streetTextField.getText());
        	   System.out.print(cityTextField.getText());
        	   System.out.print(", " + stateTextField.getText() + " ");
        	   System.out.println(zipTextField.getText());
        	}
        });
        
		Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        primaryStage.show();
	}
	
	//Use the DomServiceClass to get all customers 
    //whose city of residence begins with "Ma", in sorted order.
	public List<Customer> allCustomersBeginWithMa() {
        //we read customer info from customer.xml file
		List<Customer> customers = new ArrayList<>();
        String n = System.getProperty("line.separator");
        try {           
            DomInterface xml = new DomServiceClass("src/lesson6/labs/prob3/customer.xml");
            
            List<String> names = new ArrayList<>();
            names.addAll(xml.extractLeafTagNames());
            
            System.out.println(n + "Here is a list of the tag names:" + n);
            System.out.println(names + n + n);  
            System.out.println("Looking up customers whose city of residence begin with " + "Ma");
            
            //find out all about form
			List<Properties> propsList = xml.lookupPartialEntry("city", "Ma");
			System.out.println("There are " + propsList.size() +" customers are found");
			if (propsList != null && propsList.size() > 0) {
				for (Properties p : propsList) {
					customers.add(new Customer(p.getProperty(NAME), 
							p.getProperty(STREET), 
							p.getProperty(CITY),
							p.getProperty(ZIP)));
				}
			}
            
        }
        catch(DomException e) {
            System.out.println(e.getMessage());
        } 
		return customers;
	}
}


