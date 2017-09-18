package ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.Book;
import business.BookCopy;
import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import ui.AddBookCopyData;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class AddBookCopyController implements LibController {
	@FXML
	private TextField isbn;

	@FXML
	private Text actiontarget;
	
	@FXML
	private TableView<AddBookCopyData> addBookCopyTable;
	
	private List<AddBookCopyData> addBookCopyDatas;
	/**
	 * @return the isbn
	 */
	public TextField getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(TextField isbn) {
		this.isbn = isbn;
	}
	private void loadAddBookCopyData() throws LibrarySystemException {
		Book book = findBookByISBN(isbn.getText());
		if (book==null) {
			throw new LibrarySystemException("ISBN " + isbn.getText() + " not found");
		}
		addBookCopyDatas = new ArrayList<AddBookCopyData>();
		for (BookCopy copy : book.getCopies()) {
			if (copy.isAvailable()) {
				addBookCopyDatas.
					add(new AddBookCopyData(book.getTitle(), String.valueOf(copy.getCopyNum()), "YES"));
			} else {
				addBookCopyDatas.
					add(new AddBookCopyData(book.getTitle(), String.valueOf(copy.getCopyNum()), "NO"));
			}
		}
	}
	@FXML
	public void searchBook() {
		try {
			emptyTableView();
			RuleSet rules = RuleSetFactory.getRuleSet(AddBookCopyController.this);
			rules.applyRules(AddBookCopyController.this);
			loadAddBookCopyData();
			ObservableList<AddBookCopyData> addBookCopy = FXCollections.observableArrayList(addBookCopyDatas);
			setData(addBookCopy);
			actiontarget.setText("search book success");
		} catch (RuleException e) {
			actiontarget.setText(e.getMessage());
		} catch (LibrarySystemException e1) {
			actiontarget.setText(e1.getMessage());
		}
	}
	
	@FXML
	protected void addCopy() {
		try {
			if (addBookCopyDatas==null || addBookCopyDatas.isEmpty()) {
				throw new LibrarySystemException("Please search book first");
			}
		} catch (LibrarySystemException e1) {
			// TODO: handle exception
			actiontarget.setText(e1.getMessage());
		}
		ControllerInterface c = new SystemController();
		c.addExistingBookCopy(isbn.getText());
		try {
			loadAddBookCopyData();
			ObservableList<AddBookCopyData> addBookCopy = FXCollections.observableArrayList(addBookCopyDatas);
			setData(addBookCopy);
			actiontarget.setText("add book copy success");
		} catch (LibrarySystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
	    TableColumn<AddBookCopyData, String> bookNameCol = new TableColumn<>("Book Name");
	    bookNameCol.setMinWidth(100);
	    bookNameCol.setCellValueFactory(
	        new PropertyValueFactory<AddBookCopyData, String>("bookName"));
	    bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

	    TableColumn<AddBookCopyData, String> copyNumCol = new TableColumn<>("Copy Num");
	    copyNumCol.setMinWidth(100);
	    copyNumCol.setCellValueFactory(
	        new PropertyValueFactory<AddBookCopyData, String>("copyNum"));
	    copyNumCol.setCellFactory(TextFieldTableCell.forTableColumn());

	    TableColumn<AddBookCopyData, String> availableCol = new TableColumn<>("Available");
	    availableCol.setMinWidth(100);
	    availableCol.setCellValueFactory(
	        new PropertyValueFactory<AddBookCopyData, String>("available"));
	    availableCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
	    addBookCopyTable.getColumns().addAll(bookNameCol,copyNumCol,availableCol);	

	}
	
	private void setData(ObservableList<AddBookCopyData> addBookCopy) {
		addBookCopyTable.setItems(addBookCopy);
	}
	private void emptyTableView() {
		addBookCopyTable.setItems(null);
	}
	private Book findBookByISBN(String isbn) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> booksMap = da.readBooksMap();
		if(!booksMap.containsKey(isbn)) {
			return null;
		}
		return booksMap.get(isbn);
	}
}
