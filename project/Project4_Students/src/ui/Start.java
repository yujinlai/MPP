package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;


public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		 LoginWindow.INSTANCE.setPrimStage(stage);
		 LoginWindow.INSTANCE.init();	
	}
}
