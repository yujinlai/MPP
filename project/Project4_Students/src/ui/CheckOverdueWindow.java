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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckOverdue.fxml"));
        fxmlLoader.setRoot(this);        
        fxmlLoader.setController(this);
 
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        TableColumn<CheckOverdueData, String> bookNameCol = new TableColumn<>("Book Name");  
        bookNameCol.setMinWidth(100);
        bookNameCol.setCellValueFactory(
            new PropertyValueFactory<CheckOverdueData, String>("bookName"));
        bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
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
        table.getColumns().addAll(bookNameCol,memberNameCol,dueDayCol);                
	}
	
	 @FXML
	    protected void CheckOverdue() {
	        System.out.println("The button was clicked!");
	    }
}
