package ui.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map.Entry;

import business.BookCopy;
import business.CheckoutRecordEntry;
import business.ControllerInterface;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import ui.CheckOverdueData;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class CheckOverDueController implements LibController {
	@FXML
	private TextField isbn;
	
	public TextField getIsbn() {
		return isbn;
	}
	@FXML
	private Text actiontarget;

	@FXML
	private TableView<CheckOverdueData> checkOverdueTable;
	
	public TableView<CheckOverdueData> getCheckOverdueTable() {
		return checkOverdueTable;
	}

	@FXML
	protected void checkOverdue() {
		try {
			emptyTableView();
			RuleSet rules = RuleSetFactory.getRuleSet(CheckOverDueController.this);
			rules.applyRules(CheckOverDueController.this);
			ControllerInterface contrl = new SystemController();			
			HashMap<CheckoutRecordEntry, LibraryMember> maps = contrl.searchOverDueBooks(isbn.getText());
			if(maps.size() == 0)
				actiontarget.setText("No overdue record for book with ISBN " + isbn.getText());
			else
				setBookRecord(maps);
		} catch (RuleException e) {
			actiontarget.setText(e.getMessage());
		} catch (LibrarySystemException e) {
			actiontarget.setText(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
        TableColumn<CheckOverdueData, String> isbnCol = new TableColumn<>("ISBN");  
        isbnCol.setMinWidth(100);
        isbnCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("isbn"));
        isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TableColumn<CheckOverdueData, String> bookTitleCol = new TableColumn<>("Book Title");  
        bookTitleCol.setMinWidth(100);
        bookTitleCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("bookTitle"));
        bookTitleCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<CheckOverdueData, String> bookNumberCol = new TableColumn<>("copy Number");  
        bookNumberCol.setMinWidth(100);
        bookNumberCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("copyNumber"));
        bookNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
        TableColumn<CheckOverdueData, String> memberNameCol = new TableColumn<>("Member ID");
        memberNameCol.setMinWidth(100);
        memberNameCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("memberID"));
        memberNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<CheckOverdueData, String> dueDateCol = new TableColumn<>("Due Date");
        dueDateCol.setMinWidth(100);
        dueDateCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("dueDay"));
        dueDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        checkOverdueTable.getColumns().addAll(isbnCol,bookTitleCol,bookNumberCol, memberNameCol, dueDateCol);	
	}
	
	public void setBookRecord(HashMap<CheckoutRecordEntry, LibraryMember> maps) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ObservableList<CheckOverdueData> checkOverDue = FXCollections.observableArrayList();
		for(Entry<CheckoutRecordEntry, LibraryMember> entry : maps.entrySet()) {
			CheckoutRecordEntry record = entry.getKey();
			LibraryMember libMem = entry.getValue();
			BookCopy bookCopy = record.getRequestedBook();
			CheckOverdueData cdata = new CheckOverdueData(bookCopy.getBook().getIsbn(),
					bookCopy.getBook().getTitle(), String.valueOf(bookCopy.getCopyNum()),
					libMem.getMemberId(), sdf.format(record.getDueDate()));
			checkOverDue.add(cdata);
		}
		setData(checkOverDue);
	}
	
	private void setData(ObservableList<CheckOverdueData> overDueData) {
		checkOverdueTable.setItems(overDueData);
	}
	
	private void emptyTableView() {
		checkOverdueTable.setItems(null);
	}
}
