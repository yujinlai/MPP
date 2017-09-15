package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

public class CheckOverdueWindow extends VBox {
	public CheckOverdueWindow() {
		init();
	}
	
	@FXML
	protected void CheckOverdue() {
		System.out.println("The button was clicked!");
	}

	@SuppressWarnings("unchecked")
	public void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckOverdue.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

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
        
        TableColumn<CheckOverdueData, String> bookNumberCol = new TableColumn<>("Book Number");  
        bookNumberCol.setMinWidth(100);
        bookNumberCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("bookNumber"));
        bookNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
        TableColumn<CheckOverdueData, String> memberNameCol = new TableColumn<>("Member Name");
        memberNameCol.setMinWidth(100);
        memberNameCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("memberName"));
        memberNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<CheckOverdueData, String> dueDayCol = new TableColumn<>("Due Day");
        dueDayCol.setMinWidth(100);
        dueDayCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("dueDay"));
        dueDayCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableView<CheckOverdueData> table = (TableView<CheckOverdueData>)lookup("#checkOverdueTable");
        table.getColumns().addAll(isbnCol,bookTitleCol,bookNumberCol,memberNameCol,dueDayCol); 
	}
}
