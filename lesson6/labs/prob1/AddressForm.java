package lesson6.labs.prob1;

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

public class AddressForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Address Form");
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
        
        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 6);
        btn.setPrefWidth(100);
        btn.setPrefHeight(40);
        btn.setFont(Font.font(null, FontWeight.BOLD, 17));
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
        primaryStage.show();
	}

}
