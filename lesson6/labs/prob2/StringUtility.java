package lesson6.labs.prob2;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class StringUtility extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("String Utility");
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(5);
	        grid.setPadding(new Insets(50, 100, 50, 100));
	        
	        Button btn1 = new Button("Count Letters");
	        btn1.setFont(Font.font("Verdana", FontWeight.BOLD,-1));
	        btn1.setAlignment(Pos.CENTER_LEFT);
	        Button btn2 = new Button("Reverse Letters");
	        btn2.setFont(Font.font("Verdana", FontWeight.BOLD,-1));
	        btn2.setAlignment(Pos.CENTER_LEFT);
	        Button btn3 = new Button("Remove Duplicates");
	        btn3.setFont(Font.font("Verdana", FontWeight.BOLD,-1));
	        btn3.setAlignment(Pos.CENTER_LEFT);
	        VBox hbBtn = new VBox(15);
	        btn1.setMaxWidth(Double.MAX_VALUE);
	        btn2.setMaxWidth(Double.MAX_VALUE);
	        btn3.setMaxWidth(Double.MAX_VALUE);
	        hbBtn.setAlignment(Pos.CENTER_LEFT);
	        hbBtn.getChildren().addAll(btn1,btn2,btn3);
	        grid.add(hbBtn, 0, 0);

	        VBox hbText = new VBox(1);
	        TextField inputTextField = new TextField();        
	        TextField outputTextField = new TextField();
	        Label input = new Label("Input");
	        Label output = new Label("Output");
	        hbText.getChildren().addAll(input,inputTextField,output,outputTextField);
	        grid.add(hbText, 1, 0);
	        
			btn1.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		outputTextField.clear();
	        		outputTextField.
	        			insertText(0, String.valueOf(inputTextField.getLength()));
	        	}
	        });
			btn2.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		outputTextField.clear();
	        		StringBuilder sb = new StringBuilder(inputTextField.getText());
	        		outputTextField.
        				insertText(0, sb.reverse().toString());
	        	}
	        });
			btn3.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e) {
	        		outputTextField.clear();
	        	    char[] c = inputTextField.getText().toCharArray();
	        	    String op = "";
	        	    for(int i=0; i<=c.length-1; i++){
	        	        if(!op.contains(c[i] + ""))
	        	        op = op + c[i];
	        	    }
	        		outputTextField.insertText(0, op);
	        	}
	        });
			Scene scene = new Scene(grid);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
