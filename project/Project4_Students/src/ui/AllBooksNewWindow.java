package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AllBooksNewWindow extends VBox {
	
	final Stage stage = new Stage();

	VBox mainContainer = new VBox();
	public AllBooksNewWindow(final Stage stg) {
		init(stg);
	}
	
	@SuppressWarnings("unchecked")
	public void init(final Stage stg) {

		//Initialize the Stage with type of modal
		stage.initModality(Modality.APPLICATION_MODAL);
		//Set the owner of the Stage 
		stage.initOwner(stg);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllBooks.fxml"));
        //fxmlLoader.setRoot(this);
        //fxmlLoader.setController(this);

        try {
        	mainContainer = fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        TableColumn<AllBooksData, String> isbnCol = new TableColumn<>("ISBN");  
        isbnCol.setMinWidth(100);
        isbnCol.setCellValueFactory(
            new PropertyValueFactory<AllBooksData, String>("isbn"));
        isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TableColumn<AllBooksData, String> bookTitleCol = new TableColumn<>("Book Title");  
        bookTitleCol.setMinWidth(200);
        bookTitleCol.setCellValueFactory(
            new PropertyValueFactory<AllBooksData, String>("title"));
        bookTitleCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<AllBooksData, String> maxCheckoutLenCol = new TableColumn<>("Max Checkout Length");  
        maxCheckoutLenCol.setMinWidth(100);
        maxCheckoutLenCol.setCellValueFactory(
            new PropertyValueFactory<AllBooksData, String>("maxCheckoutLen"));
        maxCheckoutLenCol.setCellFactory(TextFieldTableCell.forTableColumn());

        
        @SuppressWarnings("unchecked")
		TableView<AllBooksData> table = (TableView<AllBooksData>)mainContainer.lookup("#allBooksTable");
        table.getColumns().addAll(isbnCol,bookTitleCol,maxCheckoutLenCol); 
        
        Scene scene = new Scene(mainContainer, 400, 300,Color.BEIGE);
        stage.setScene(scene);
        
	}

	public void Show() {
		stage.show();
	}
	
	public void setAllBooks(ArrayList<AllBooksData> data) {
		
		ObservableList<AllBooksData> allData = FXCollections.observableArrayList(data);
		@SuppressWarnings("unchecked")
		TableView<AllBooksData> table = (TableView<AllBooksData>)mainContainer.lookup("#allBooksTable");
		table.setItems(allData);
	}
}
