package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CheckoutBookWindow extends VBox {
	public CheckoutBookWindow() {
		init();
	}

	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckoutBook.fxml"));
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
