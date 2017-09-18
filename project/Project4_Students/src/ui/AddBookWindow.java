package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.Author;
import business.Book;
import business.ControllerInterface;

import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.controller.LibController;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class AddBookWindow extends GridPane implements LibController {
	
	Stage stg;
	GridPane mainContainer = new GridPane();
	ArrayList<Author> authors = new ArrayList<>();
	AddAuthorWindow aa;
	int authorIndex;
	ListView<String> authorList;
	boolean isNew;

	private TextField isbn;
	private TextField title;
	private TextField numOfCopies;
	private Text actiontarget;
	
	public TextField getIsbn() {
		return isbn;
	}

	public void setIsbn(TextField isbn) {
		this.isbn = isbn;
	}

	public TextField getTitle() {
		return title;
	}

	public void setTitle(TextField title) {
		this.title = title;
	}

	public TextField getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(TextField numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	public AddBookWindow() {
		init();
	}

	public void SetStage(Stage stg) {
		this.stg = stg;
		
	}
	@FXML
	@SuppressWarnings("rawtypes")
	protected void AddBook() {
		try {
			actiontarget = (Text) mainContainer.lookup("#actiontarget");
			isbn = (TextField) mainContainer.lookup("#isbn");
			title = (TextField) mainContainer.lookup("#title");			
			ComboBox maxDays = (ComboBox) mainContainer.lookup("#maxDays");
			numOfCopies = (TextField) mainContainer.lookup("#numOfCopies");
			RuleSet rules = RuleSetFactory.getRuleSet(AddBookWindow.this);
			rules.applyRules(AddBookWindow.this);
			ControllerInterface c = new SystemController();
			c.addBook(isbn.getText(), title.getText(), Integer.parseInt(maxDays.getValue().toString()), authors,
					Integer.parseInt(numOfCopies.getText()));
			actiontarget.setText("add book success");
		} catch (RuleException e) {			
			actiontarget.setText(e.getMessage() + " or please keep the author with selected state.");
		}
	}

	@FXML
	protected void NewAuthor() {
		isNew = true;
		aa = new AddAuthorWindow(stg);
		aa.setAbWindow(this);
		aa.Show();
	}

	@FXML
	protected void EditAuthor() {
		isNew = false;
		aa = new AddAuthorWindow(stg);
		aa.setAbWindow(this);
		
		String name = authorList.getSelectionModel().selectedItemProperty().asString().get();
		authorIndex = 0;

		for(Author a : authors) {
			if(name.equals(a.getFirstName() + " " + a.getLastName())) {
				aa.SetAuthor(a);
				
				break;
			}
			authorIndex++;
		}
		
		aa.Show();
	}
	
	@FXML
	protected void DeleteAuthor() {
		String name = authorList.getSelectionModel().selectedItemProperty().asString().get();
		for(Author a : authors) {
			if(name.equals(a.getFirstName() + " " + a.getLastName())) {
				authors.remove(a);
				break;
			}
		}
		
		SetData();
	}
	
	@FXML
	protected void AllBooks() {
		AllBooksWindow allBooks = new AllBooksWindow(stg);
		ArrayList<AllBooksData> data = new ArrayList<>();
		ControllerInterface c = new SystemController();
		List<Book> all = c.allLibBooks();
		for(Book b: all) {
			data.add(new AllBooksData(b.getIsbn(),b.getTitle(),String.valueOf(b.getMaxCheckoutLength())));
		}
		allBooks.setAllBooks(data);
		allBooks.Show();
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
        	mainContainer = fxmlLoader.load();
	        @SuppressWarnings("rawtypes")
			ComboBox maxDays = (ComboBox)mainContainer.lookup("#maxDays");
	        ObservableList<String> strList = FXCollections.observableArrayList("7","21"); 
	        maxDays.setItems(strList);
	        maxDays.setValue("7");
	        authorList = (ListView<String>)mainContainer.lookup("#authorList");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public void SetAuthors(Author author) {	
		if(!isNew){
			authors.remove(authorIndex);
		}
		authors.add(author);
		
		SetData();
	}
	
	void SetData() {
		ArrayList<String> authorNames = new ArrayList<>();
		for(Author a : authors) {
			authorNames.add(a.getFirstName() + " " + a.getLastName());
		}

		ObservableList<String> strList = FXCollections.observableArrayList(authorNames); 
		authorList.setItems(strList);
	}
}
