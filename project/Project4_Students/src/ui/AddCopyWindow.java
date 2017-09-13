package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

public class AddCopyWindow extends VBox {
	public AddCopyWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCopy.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        TableColumn<AddCopyData, String> bookNameCol = new TableColumn<>("Book Name");  
        bookNameCol.setMinWidth(100);
        bookNameCol.setCellValueFactory(
            new PropertyValueFactory<AddCopyData, String>("bookName"));
        bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
        TableColumn<AddCopyData, String> copyNumCol = new TableColumn<>("Copy Num");
        copyNumCol.setMinWidth(100);
        copyNumCol.setCellValueFactory(
            new PropertyValueFactory<AddCopyData, String>("copyNum"));
        copyNumCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<AddCopyData, String> isAvailableCol = new TableColumn<>("Available");
        isAvailableCol.setMinWidth(100);
        isAvailableCol.setCellValueFactory(
            new PropertyValueFactory<AddCopyData, String>("isAvailable"));
        isAvailableCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableView<AddCopyData> table = (TableView<AddCopyData>)lookup("#addCopyTable");
        table.getColumns().addAll(bookNameCol,copyNumCol,isAvailableCol);        
	}
	
	 @FXML
	    protected void SearchBook() {
	        System.out.println("The button was clicked!");
	    }
	 
	 @FXML
	    protected void AddCopy() {
	        System.out.println("The button was clicked!");
	    }
}
