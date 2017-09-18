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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AllMembersNewWindow extends VBox {
	final Stage stage = new Stage();

	VBox mainContainer = new VBox();
	public AllMembersNewWindow(final Stage stg) {
		init(stg);
	}
	
	@SuppressWarnings("unchecked")
	public void init(final Stage stg) {
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(stg);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllMembers.fxml"));

        try {
        	mainContainer = fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        TableColumn<AllMembersData, String> idCol = new TableColumn<>("Member ID");  
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
            new PropertyValueFactory<AllMembersData, String>("id"));
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TableColumn<AllMembersData, String> firstNameCol = new TableColumn<>("First Name");  
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<AllMembersData, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<AllMembersData, String> lastNameCol = new TableColumn<>("Last Name");  
        lastNameCol.setMinWidth(200);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<AllMembersData, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

		TableView<AllMembersData> table = (TableView<AllMembersData>)mainContainer.lookup("#allMembersTable");
        table.getColumns().addAll(idCol,firstNameCol,lastNameCol); 
        
        Scene scene = new Scene(mainContainer, 400, 300,Color.BEIGE);
        stage.setScene(scene);
	}
	
	public void Show() {
		stage.show();
	}

	@SuppressWarnings("unchecked")
	public void setAllMembers(ArrayList<AllMembersData> data) {
		ObservableList<AllMembersData> allData = FXCollections.observableArrayList(data);
		TableView<AllMembersData> table = (TableView<AllMembersData>)mainContainer.lookup("#allMembersTable");
		table.setItems(allData);		
	}
}
