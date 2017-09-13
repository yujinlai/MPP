package ui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainWindow extends Stage {

	/*
	private static Stage primStage = null;
	public static Stage primStage() {
		return primStage;
	}
	
	public static class Colors {
		static Color green = Color.web("#034220");
		static Color red = Color.FIREBRICK;
	}
	
	private static Stage[] allWindows = { 
		LoginWindow.INSTANCE,
		AllMembersWindow.INSTANCE,	
		AllBooksWindow.INSTANCE
	};
	
	public static void hideAllWindows() {
		primStage.hide();
		for(Stage st: allWindows) {
			st.hide();
		}
	}
	
*/
	Stage primaryStage;
	VBox mainContainer = new VBox();
	//Parent root;
	
	public MainWindow(Stage ps) {
		
		/*

				
		primaryStage = primaryStage;
		primaryStage.setTitle("Main Page");	
				
		VBox topContainer = new VBox();
		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();
		VBox imageHolder = new VBox();
		Image image = new Image("ui/library.jpg", 400, 300, false, false);

        // simply displays in ImageView the image as is
        ImageView iv = new ImageView();
        iv.setImage(image);
        imageHolder.getChildren().add(iv);
        imageHolder.setAlignment(Pos.CENTER);
        HBox splashBox = new HBox();
        Label splashLabel = new Label("The Library System");
        splashLabel.setFont(Font.font("Trajan Pro", FontWeight.BOLD, 30));
        splashBox.getChildren().add(splashLabel);
        splashBox.setAlignment(Pos.CENTER);
		
		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(splashBox);
		topContainer.getChildren().add(imageHolder);
		
		Menu optionsMenu = new Menu("Options");
		MenuItem login = new MenuItem("Login");
		
		login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	hideAllWindows();
    			if(!LoginWindow.INSTANCE.isInitialized()) {
    				LoginWindow.INSTANCE.init();
    			}
    			LoginWindow.INSTANCE.clear();
    			LoginWindow.INSTANCE.show();
            }
        });			
							
		MenuItem bookIds = new MenuItem("All Book Ids");
		bookIds.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
				hideAllWindows();
				if(!AllBooksWindow.INSTANCE.isInitialized()) {
					AllBooksWindow.INSTANCE.init();
				}
				ControllerInterface ci = new SystemController();
				List<String> ids = ci.allBookIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for(String s: ids) {
					sb.append(s + "\n");
				}
				AllBooksWindow.INSTANCE.setData(sb.toString());
				AllBooksWindow.INSTANCE.show();
            }
		});
		
		MenuItem memberIds = new MenuItem("All Member Ids");
		memberIds.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
				hideAllWindows();
				if(!AllMembersWindow.INSTANCE.isInitialized()) {
					AllMembersWindow.INSTANCE.init();
				}
				ControllerInterface ci = new SystemController();
				List<String> ids = ci.allMemberIds();
				Collections.sort(ids);
				System.out.println(ids);
				StringBuilder sb = new StringBuilder();
				for(String s: ids) {
					sb.append(s + "\n");
				}
				System.out.println(sb.toString());
				AllMembersWindow.INSTANCE.setData(sb.toString());
				AllMembersWindow.INSTANCE.show();
            }
		});	
		optionsMenu.getItems().addAll(login, bookIds, memberIds);

		mainMenu.getMenus().addAll(optionsMenu);
		Scene scene = new Scene(topContainer, 420, 375);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
		primaryStage.show();
		*/
		
		//Stage primaryStage = ps;
		setTitle("Library System");
		try {
			mainContainer = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scene scene = new Scene(mainContainer, 800, 600,Color.BEIGE);
		setScene(scene);
		
/*				
		//VBox mainContainer = new VBox();
		Label welcome = new Label("Welcome: XXXXXXXX");
		welcome.setPadding(new Insets(25, 25, 25, 25));
		HBox allFunctions = new HBox();
		
		//allFunctions.setPadding(new Insets(25, 25, 25, 25)); 
		Button addMemberBtn = new Button("Add member");
		//addMemberBtn.setPadding(new Insets(25, 25, 25, 25));
		Button checkoutBtn = new Button("Check out a book");
		//checkoutBtn.setPadding(new Insets(25, 25, 25, 25));
		Button addCopyBtn = new Button("Add copy");
		//addCopyBtn.setPadding(new Insets(25, 25, 25, 25));
		Button addBookBtn = new Button("Add book");
		//addBookBtn.setPadding(new Insets(25, 25, 25, 25));
		Button printCheckoutBtn = new Button("Print checkout record");
		//printCheckoutBtn.setPadding(new Insets(25, 25, 25, 25));
		Button checkOverdueBtn = new Button("Check overdue");
		//checkOverdueBtn.setPadding(new Insets(25, 25, 25, 25));
		allFunctions.getChildren().addAll(addMemberBtn,checkoutBtn,addCopyBtn,
				addBookBtn,printCheckoutBtn,checkOverdueBtn);
		HBox.setMargin(addMemberBtn, new Insets(5, 5, 5, 25));
		HBox.setMargin(checkoutBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(addCopyBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(addBookBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(printCheckoutBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(checkOverdueBtn, new Insets(5, 5, 5, 5));
		Color color = Color.rgb(200, 0, 0, 0.35);
	    BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY,
	            Insets.EMPTY);
	    Background background = new Background(fill);
	    allFunctions.setBackground(background);
		//allFunctions.setBackground(new Background(new BackgroundFill(Color.web("#" + "abcdef"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
		GridPane addMemberGrid = new GridPane();
		addMemberGrid.setId("top-container");
		addMemberGrid.setAlignment(Pos.CENTER);
		addMemberGrid.setHgap(10);
		addMemberGrid.setVgap(10);
		addMemberGrid.setPadding(new Insets(25, 25, 25, 25)); 
        Text scenetitle = new Text("Add member");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma
        addMemberGrid.add(scenetitle, 0, 0, 2, 1);
        
        Label id = new Label("ID:");
        addMemberGrid.add(id, 0, 1);
        TextField idTextField = new TextField();
        addMemberGrid.add(idTextField, 1, 1);
        Label firstName = new Label("First Name:");
        addMemberGrid.add(firstName, 0, 2);
        TextField firstNameTextField = new TextField();
        addMemberGrid.add(firstNameTextField, 1, 2);
        Label lastName = new Label("Last Name:");
        addMemberGrid.add(lastName, 0, 3);
        TextField lastNameTextField = new TextField();
        addMemberGrid.add(lastNameTextField, 1, 3);
        Label street = new Label("Street:");
        addMemberGrid.add(street, 0, 4);
        TextField streetTextField = new TextField();
        addMemberGrid.add(streetTextField, 1, 4);
        Label city = new Label("City:");
        addMemberGrid.add(city, 0, 5);
        TextField cityTextField = new TextField();
        addMemberGrid.add(cityTextField, 1, 5);
        Label state = new Label("State:");
        addMemberGrid.add(state, 0, 6);
        TextField stateTextField = new TextField();
        addMemberGrid.add(stateTextField, 1, 6);
        Label zipCode = new Label("Zip Code:");
        addMemberGrid.add(zipCode, 0, 7);
        TextField zipCodeTextField = new TextField();
        addMemberGrid.add(zipCodeTextField, 1, 7);
        Label telephone = new Label("Telephone:");
        addMemberGrid.add(telephone, 0, 8);
        TextField telephoneTextField = new TextField();
        addMemberGrid.add(telephoneTextField, 1, 8);
        Button addBtn = new Button("Add library member");
        addMemberGrid.add(addBtn, 1, 9);
        
        VBox checkBookVBox = new VBox();
        checkBookVBox.setId("top-container");
        checkBookVBox.setAlignment(Pos.CENTER);
        checkBookVBox.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Checkout book");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma        
        HBox checkBookHBox = new HBox();              
        id = new Label("ID:");
        idTextField = new TextField();
        Label isbn = new Label("ISBN:"); 
        TextField isbnTextField = new TextField(); 
        Button checkBtn = new Button("Check out book");
        checkBookHBox.getChildren().addAll(id,idTextField,isbn,isbnTextField,checkBtn);
        HBox.setMargin(id, new Insets(5, 5, 5, 5));
        HBox.setMargin(idTextField, new Insets(5, 5, 5, 5));
        HBox.setMargin(isbn, new Insets(5, 5, 5, 5));
        HBox.setMargin(isbnTextField, new Insets(5, 5, 5, 5));
        HBox.setMargin(checkBtn, new Insets(5, 5, 5, 5));
        
        TableView table = new TableView();
        TableColumn bookNameCol = new TableColumn("Book Name");
        
        TableColumn copyNumCol = new TableColumn("Copy Num");
        TableColumn checkoutDateCol = new TableColumn("Checkout Date");
        TableColumn dueDateCol = new TableColumn("Due Date");
        table.getColumns().addAll(bookNameCol, copyNumCol, checkoutDateCol,dueDateCol);

        checkBookVBox.setSpacing(5);
        checkBookVBox.getChildren().addAll(scenetitle,checkBookHBox,table);
        checkBookVBox.setVisible(false);
        
        VBox addCopyVBox = new VBox();
        addCopyVBox.setId("top-container");
        addCopyVBox.setAlignment(Pos.CENTER);
        addCopyVBox.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Add copy");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma        
        HBox addCopyHBox = new HBox();              
        isbn = new Label("ISBN:");
        isbnTextField = new TextField();        
        Button searchBtn = new Button("Search book");
        Button copyBtn = new Button("Add copy");
        addCopyHBox.getChildren().addAll(isbn,isbnTextField,searchBtn,copyBtn);        
        HBox.setMargin(isbn, new Insets(5, 5, 5, 5));
        HBox.setMargin(isbnTextField, new Insets(5, 5, 5, 5));
        HBox.setMargin(searchBtn, new Insets(5, 5, 5, 5));
        HBox.setMargin(copyBtn, new Insets(5, 5, 5, 5));
        
        table = new TableView();
        bookNameCol = new TableColumn("Book Name");        
        copyNumCol = new TableColumn("Copy Num");
        TableColumn availableCol = new TableColumn("Available");        
        table.getColumns().addAll(bookNameCol, copyNumCol, availableCol);

        addCopyVBox.setSpacing(5);
        addCopyVBox.getChildren().addAll(scenetitle,addCopyHBox,table);
        addCopyVBox.setVisible(false);  
        
        GridPane addCopyGrid = new GridPane();
        addCopyGrid.setId("top-container");
        addCopyGrid.setAlignment(Pos.CENTER);
        addCopyGrid.setHgap(10);
        addCopyGrid.setVgap(10);
        addCopyGrid.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Add copy");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma
        addCopyGrid.add(scenetitle, 0, 0, 2, 1);
        addCopyGrid.setVisible(false);
        
        GridPane addBookGrid = new GridPane();
        addBookGrid.setId("top-container");
        addBookGrid.setAlignment(Pos.CENTER);
        addBookGrid.setHgap(10);
        addBookGrid.setVgap(10);
        addBookGrid.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Add Book");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma
        addBookGrid.add(scenetitle, 0, 0, 2, 1);
        
        isbn = new Label("ISBN:");
        addBookGrid.add(isbn, 0, 1);
        isbnTextField = new TextField();
        addBookGrid.add(idTextField, 1, 1);
        Label bookName = new Label("Book Name:");
        addBookGrid.add(bookName, 0, 2);
        TextField bookNameTextField = new TextField();
        addBookGrid.add(bookNameTextField, 1, 2);
        Label authors = new Label("Authors:");
        addBookGrid.add(authors, 0, 3);
        TextField authorsTextField = new TextField();
        addBookGrid.add(authorsTextField, 1, 3);
        Label maxDay = new Label("Max Day:");
        addBookGrid.add(maxDay, 0, 4);
        TextField maxDayTextField = new TextField();
        addBookGrid.add(maxDayTextField, 1, 4);
        Label copyNum = new Label("Copy Num:");
        addBookGrid.add(copyNum, 0, 5);
        TextField copyNumTextField = new TextField();
        addBookGrid.add(copyNumTextField, 1, 5);       
        addBtn = new Button("Add New Book");
        addBookGrid.add(addBtn, 1, 6);
        addBookGrid.setVisible(false);
        
        GridPane printCheckoutGrid = new GridPane();
        printCheckoutGrid.setId("top-container");
        printCheckoutGrid.setAlignment(Pos.CENTER);
        printCheckoutGrid.setHgap(10);
        printCheckoutGrid.setVgap(10);
        printCheckoutGrid.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Print Checkout Record");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma
        printCheckoutGrid.add(scenetitle, 0, 0, 2, 1);
        
        id = new Label("ID:");
        printCheckoutGrid.add(id, 0, 1);
        idTextField = new TextField();
        printCheckoutGrid.add(idTextField, 1, 1);          
        Button printBtn = new Button("Print");
        printCheckoutGrid.add(printBtn, 1, 2);
        printCheckoutGrid.setVisible(false);
        
        VBox checkOverdueVBox = new VBox();
        checkOverdueVBox.setId("top-container");
        checkOverdueVBox.setAlignment(Pos.CENTER);
        checkOverdueVBox.setPadding(new Insets(25, 25, 25, 25)); 
        scenetitle = new Text("Check Overdue");
        scenetitle.setFont(Font.font("Harlow Solid Italic", FontWeight.NORMAL, 20)); //Tahoma        
        HBox checkOverdueHBox = new HBox();              
        isbn = new Label("ISBN:");
        isbnTextField = new TextField();  
        copyNum = new Label("Copy Num:");
        copyNumTextField = new TextField();
        Button overdueBtn = new Button("Check Overdue");
        checkOverdueHBox.getChildren().addAll(isbn,isbnTextField,copyNum,copyNumTextField,overdueBtn);        
        HBox.setMargin(isbn, new Insets(5, 5, 5, 5));
        HBox.setMargin(isbnTextField, new Insets(5, 5, 5, 5));
        HBox.setMargin(copyNum, new Insets(5, 5, 5, 5));
        HBox.setMargin(copyNumTextField, new Insets(5, 5, 5, 5));
        HBox.setMargin(overdueBtn, new Insets(5, 5, 5, 5));
        
        table = new TableView();
        bookNameCol = new TableColumn("Book Name");        
        TableColumn memberNameCol = new TableColumn("Memeber Name");
        TableColumn dueDayCol = new TableColumn("Due Day");        
        table.getColumns().addAll(bookNameCol, memberNameCol, dueDayCol);

        checkOverdueVBox.setSpacing(5);
        checkOverdueVBox.getChildren().addAll(scenetitle,checkOverdueHBox,table);
        checkOverdueVBox.setVisible(false);         
        
        StackPane funcPane = new StackPane();
        funcPane.getChildren().addAll(addMemberGrid,checkBookVBox,addCopyVBox,addBookGrid,
        		printCheckoutGrid,checkOverdueVBox);
        color = Color.rgb(0, 200, 0, 0.35);
	    fill = new BackgroundFill(color, CornerRadii.EMPTY,
	            Insets.EMPTY);
	    background = new Background(fill);
	    funcPane.setBackground(background);
        mainContainer.getChildren().addAll(welcome,allFunctions,funcPane);
        Scene scene = new Scene(mainContainer, 800, 600,Color.BEIGE);
		setScene(scene);
		//scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
		//primaryStage.show();
		
		addMemberBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {        			        			
        			addMemberGrid.setVisible(true);
        			checkBookVBox.setVisible(false);
        			addCopyVBox.setVisible(false);
        			addBookGrid.setVisible(false);
        			printCheckoutGrid.setVisible(false);
        			checkOverdueVBox.setVisible(false);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });
		
		checkoutBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {
        			
        			addMemberGrid.setVisible(false);
        			checkBookVBox.setVisible(true);
        			addCopyVBox.setVisible(false);
        			addBookGrid.setVisible(false);
        			printCheckoutGrid.setVisible(false);
        			checkOverdueVBox.setVisible(false);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });
		
		addCopyBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {
        			
        			addMemberGrid.setVisible(false);
        			checkBookVBox.setVisible(false);
        			addCopyVBox.setVisible(true);
        			addBookGrid.setVisible(false);
        			printCheckoutGrid.setVisible(false);
        			checkOverdueVBox.setVisible(false);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });
		
		addBookBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {
        			
        			addMemberGrid.setVisible(false);
        			checkBookVBox.setVisible(false);
        			addCopyVBox.setVisible(false);
        			addBookGrid.setVisible(true);
        			printCheckoutGrid.setVisible(false);
        			checkOverdueVBox.setVisible(false);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });
		
		printCheckoutBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {
        			
        			addMemberGrid.setVisible(false);
        			checkBookVBox.setVisible(false);
        			addCopyVBox.setVisible(false);
        			addBookGrid.setVisible(false);
        			printCheckoutGrid.setVisible(true);
        			checkOverdueVBox.setVisible(false);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });
		
		checkOverdueBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		try {
        			
        			addMemberGrid.setVisible(false);
        			checkBookVBox.setVisible(false);
        			addCopyVBox.setVisible(false);
        			addBookGrid.setVisible(false);
        			printCheckoutGrid.setVisible(false);
        			checkOverdueVBox.setVisible(true);
        			
        		} catch(Exception ex) {
        			//messageBar.setFill(Start.Colors.red);
        			ex.printStackTrace();
        		}
        	   
        	}
        });*/
		
	}
	
}
