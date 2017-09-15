package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public static class Colors {
		static Color green = Color.web("#034220");
		static Color red = Color.FIREBRICK;
	}

	@Override
	public void start(Stage stage) throws IOException {
		 LoginWindow.INSTANCE.setPrimStage(stage);
		 LoginWindow.INSTANCE.init();	
	}
}
