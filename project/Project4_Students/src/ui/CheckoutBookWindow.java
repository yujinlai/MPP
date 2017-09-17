package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

public class CheckoutBookWindow extends VBox {
	public CheckoutBookWindow() {
		init();
	}

	@SuppressWarnings("unchecked")
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
