package ui.controller;

import business.CheckoutRecordEntry;
import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import ui.CheckoutBookData;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class CheckoutBookController implements LibController {
	@FXML
	private TextField memberID;
	
	@FXML
	private TextField isbn;
	
	@FXML
	private Text actiontarget;
	
	@FXML
	private TableView<CheckoutRecordEntry> checkoutBookTable;
	
	@FXML
	public void checkoutBook() {
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(CheckoutBookController.this);
			rules.applyRules(CheckoutBookController.this);
			ControllerInterface c = new SystemController();
			CheckoutRecordEntry entry = c.checkoutBook(memberID.getText().trim(), isbn.getText().trim());
			emptyAllFields();
			actiontarget.setText("check out success");
		} catch (RuleException e) {
			actiontarget.setText(e.getMessage());
		} catch (LibrarySystemException e1) {
			actiontarget.setText(e1.getMessage());
		}
	}
	
	@FXML
	private void initialize() {
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

	    //checkoutBookTable.getColumns().addAll(bookNameCol,copyNumCol,checkoutDateCol, dueDateCol);
			
	}
	
	private void emptyAllFields() {
		memberID.setText("");
		isbn.setText("");
	}
}
