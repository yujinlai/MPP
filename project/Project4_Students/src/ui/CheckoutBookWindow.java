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

	@FXML
	protected void CheckoutBook() {
		System.out.println("The button was clicked!");
	}

	@SuppressWarnings("unchecked")
	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckoutBook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        TableColumn<CheckoutBookData, String> bookNameCol = new TableColumn<>("Book Name");
        bookNameCol.setMinWidth(100);
        bookNameCol.setCellValueFactory(
            new PropertyValueFactory<CheckoutBookData, String>("bookName"));
        bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<CheckoutBookData, String> copyNumCol = new TableColumn<>("Copy Num");
        copyNumCol.setMinWidth(100);
        copyNumCol.setCellValueFactory(
            new PropertyValueFactory<CheckoutBookData, String>("copyNum"));
        copyNumCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<CheckoutBookData, String> checkoutDateCol = new TableColumn<>("Checkout Date");
        checkoutDateCol.setMinWidth(100);
        checkoutDateCol.setCellValueFactory(
            new PropertyValueFactory<CheckoutBookData, String>("checkoutDate"));
        checkoutDateCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<CheckoutBookData, String> dueDateCol = new TableColumn<>("Due Date");
        dueDateCol.setMinWidth(100);
        dueDateCol.setCellValueFactory(
            new PropertyValueFactory<CheckoutBookData, String>("dueDate"));
        dueDateCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableView<CheckoutBookData> table = (TableView<CheckoutBookData>)lookup("#checkoutBookTable");
        table.getColumns().addAll(bookNameCol,copyNumCol,checkoutDateCol,dueDateCol);
	}
}
