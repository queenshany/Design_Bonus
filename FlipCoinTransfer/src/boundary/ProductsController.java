package boundary;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductsController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox menu;

    @FXML
    private ImageView products;

    @FXML
    private ImageView transactions;

    @FXML
    private ImageView wallets;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView searchIcon;

    @FXML
    private TextField searchText;

    @FXML
    private ImageView mailIcon;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private VBox bottom;

    @FXML
    private ImageView line;

    @FXML
    private HBox hbox;

    @FXML
    private Label networkStatus;

    @FXML
    private ImageView homeIcon;

    @FXML
    private Label yourproducts;

    @FXML
    private TableView<Item> table;
    
    @FXML
    private TableColumn<Item, Integer> catalogNumber;

    @FXML
    private TableColumn<Item, String> itemName;

    @FXML
    private TableColumn<Item, String> image;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, Double> price;

    @FXML
    private TableColumn<Item, Integer> quantity;

    @FXML
    private TableColumn<Item, String> category;
    
    @FXML
    private Button removeButton;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    
	public void initialize() {
		
		catalogNumber.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		image.setCellValueFactory(new PropertyValueFactory<>("image"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		category.setCellValueFactory(new PropertyValueFactory<>("category"));
		
		
		table.setItems(getProducts());
		table.refresh();
		   
 } 
 
 public ObservableList<Item> getProducts(){
	   
	   ObservableList<Item> I= FXCollections.observableArrayList();
	   ArrayList<Item> Items = control.ItemLogic.getInstance().getItems();
	   System.out.println(Items);
	   for(Item itms : Items)
	   {
		   if(itms.getSellerAddress().equalsIgnoreCase("A1A1A1") && itms.getSellerSignature().equalsIgnoreCase("A11"))
		   I.add(itms);
	   }
		return I;
 }
	
    
    @FXML
    void addProduct(ActionEvent event) {

    }

    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
		ViewLogic.newUserWindow();
    }
    
    @FXML
    void editProduct(ActionEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newLoginWindow();
    }

    @FXML
    void mailsScreen(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newEmailWindow();
    }

    @FXML
    void productsScreen(MouseEvent event) {

    }

    @FXML
    void removeProduct(ActionEvent event) {

    }

    @FXML
    void searchProducts(MouseEvent event) {

    }

    @FXML
    void settingsScreen(MouseEvent event) {

    }

    @FXML
    void switch1(MouseEvent event) {
    products.setId("..\\rsc\\productsPic.png");
    }

    @FXML
    void switch2(MouseEvent event) {

    }

    @FXML
    void switch3(MouseEvent event) {

    }

    @FXML
    void transactionsScreen(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newTransactionsWindow();
    }

    @FXML
    void walletsScreen(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newWalletsWindow();
    }




	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
