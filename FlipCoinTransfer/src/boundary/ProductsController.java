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

	protected static BorderPane bp;
	
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

    @FXML
    private Label errorM;
    
    protected static Item currentProduct;
    
	public void initialize() {
		
		bp = borderPane;
		
		catalogNumber.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		image.setCellValueFactory(new PropertyValueFactory<>("image"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		category.setCellValueFactory(new PropertyValueFactory<>("category"));
			
		getProducts();
		   
 } 
 
 public void getProducts(){
	   
	   ObservableList<Item> I= FXCollections.observableArrayList();
	   ArrayList<Item> Items = control.ItemLogic.getInstance().getItems();
	   for(Item itms : Items)
	   {
		   if(itms.getSellerAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress()) &&
				   itms.getSellerSignature().equalsIgnoreCase(LoginController.curretUser.getSignature()))
		   I.add(itms);
	   }
		table.setItems(I);
		table.refresh();
 }
	
    
    @FXML
    void addProduct(ActionEvent event) {
    	ViewLogic.newAddProductWindow();
    }

    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
		ViewLogic.newUserWindow();
    }
    
    @FXML
    void editProduct(ActionEvent event) {
    	errorM.setVisible(false);
    	if(table.getSelectionModel().getSelectedItem()!=null) {
    	currentProduct=table.getSelectionModel().getSelectedItem();
    	ViewLogic.newEditProductWindow();
    	}
    	else {
    	errorM.setVisible(true);	 
    	}
    		
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
    	LoginController.keyWord = searchText.getText();
    	closeWindow();
    	ViewLogic.newSearchPageWindow();
    }

    @FXML
    void removeProduct(ActionEvent event) {
    	errorM.setVisible(false);
    	if(table.getSelectionModel().getSelectedItem()!=null) {
    	control.ItemLogic.getInstance().deleteItem(table.getSelectionModel().getSelectedItem());
    	getProducts();
    	table.refresh();
    	}
    	else
    		errorM.setVisible(true);
    }

    @FXML
    void searchProducts(MouseEvent event) {

    }

    @FXML
    void settingsScreen(MouseEvent event) {

    }

    @FXML
    void switch1(MouseEvent event) {
    products.setId("productsPic.png");
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
