package boundary;

import java.sql.Date;
import java.util.ArrayList;

import entity.Item;
import entity.Transaction;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailsForAdminController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private HBox topBorder;

	@FXML
	private ImageView logo;

	@FXML
	private Label networkStatus;

	@FXML
	private ImageView logoutIcon;

	@FXML
	private VBox bottom;

	@FXML
	private ImageView line;

	@FXML
	private HBox hbox;

	@FXML
	private ImageView homeIcon;

	@FXML
	private TabPane tabPane;

	@FXML
	private Tab allUsers;

	@FXML
	private AnchorPane p1;

	@FXML
	private TableView<User> t1;

	@FXML
	private TableColumn<User, String> publicAddress;

	@FXML
	private TableColumn<User, String> signature;

	@FXML
	private TableColumn<User, String> username;

	@FXML
	private TableColumn<User, String> phone;

	@FXML
	private TableColumn<User, Boolean> isEmployee;

	@FXML
	private Tab allProducts;

	@FXML
	private AnchorPane p2;

	@FXML
	private TableView<Item> t2;

	@FXML
	private TableColumn<Item, Integer> catalogNum;

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
	private TableColumn<Item, String> sellerA;

	@FXML
	private TableColumn<Item, String> sellerS;

	@FXML
	private Tab allTransactions;

	@FXML
	private AnchorPane p3;

	@FXML
	private TableView<Transaction> t3;

	@FXML
	private TableColumn<Transaction, Integer> tranId;

	@FXML
	private TableColumn<Transaction, Integer> size;

	@FXML
	private TableColumn<Transaction, Date> creaDate;

	@FXML
	private TableColumn<Transaction, Date> execDate;

	@FXML
	private TableColumn<Transaction, Double> fee;

	@FXML
	private TableColumn<Transaction, String> status;

	@FXML
	private TableColumn<Transaction, String> creaAddress;

	@FXML
	private TableColumn<Transaction, String> creaSig;

	@FXML
	private TableColumn<Transaction, String> DesAddress;

	@FXML
	private TableColumn<Transaction, String> DesSig;

	@FXML
	private TableColumn<Transaction, String> type;

	@FXML
	void goHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newAdminWindow();
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	public void initialize() {

		//Users
		publicAddress.setCellValueFactory(new PropertyValueFactory<>("publicAddress"));
		signature.setCellValueFactory(new PropertyValueFactory<>("signature"));
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		isEmployee.setCellValueFactory(new PropertyValueFactory<>("isEmployee"));
		
		//Products
		catalogNum.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		image.setCellValueFactory(new PropertyValueFactory<>("image"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		category.setCellValueFactory(new PropertyValueFactory<>("category"));
		sellerA.setCellValueFactory(new PropertyValueFactory<>("sellerAddress"));
		sellerS.setCellValueFactory(new PropertyValueFactory<>("sellerSignature"));


		//Trans
		tranId.setCellValueFactory(new PropertyValueFactory<>("transID"));
		size.setCellValueFactory(new PropertyValueFactory<>("size"));
		creaDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		execDate.setCellValueFactory(new PropertyValueFactory<>("executionDate"));
		fee.setCellValueFactory(new PropertyValueFactory<>("fee"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		creaAddress.setCellValueFactory(new PropertyValueFactory<>("creatingAddress"));
		creaSig.setCellValueFactory(new PropertyValueFactory<>("creatingSignature"));
		DesAddress.setCellValueFactory(new PropertyValueFactory<>("destinationAddress"));
		DesSig.setCellValueFactory(new PropertyValueFactory<>("destinationSignature"));
		type.setCellValueFactory(new PropertyValueFactory<>("type"));

		
		//Fill Users Table
		ArrayList<User> users = control.UserLogic.getInstance().getUsers(); 	
//		users= control.UserLogic.getInstance().getUsers(); 		   
		ObservableList<User> us= FXCollections.observableArrayList(users);
		t1.setItems(us);
		

		//Fill Product Table
		ArrayList<Item> product = new ArrayList<Item>();
		product= control.ItemLogic.getInstance().getItems(); 		   
		ObservableList<Item> p= FXCollections.observableArrayList(product);
		t2.setItems(p);

		
		//Fill Trans Table
		ArrayList<Transaction> tr = new ArrayList<Transaction>();
		tr=control.TransLogic.getInstance().getAllTrans(); 		   
		ObservableList<Transaction> trans= FXCollections.observableArrayList(tr);
		t3.setItems(trans);

	} 

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}