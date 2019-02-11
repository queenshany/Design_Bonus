package boundary;

import java.sql.Date;
import java.util.ArrayList;

import entity.User;
import entity.Wallet;
import entity.Item;
import entity.ItemInTransaction;
import entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.E_TransType;

public class TransactionsController {

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
	private TabPane tabPane;

	@FXML
	private Tab newPT;

	@FXML
	private AnchorPane pane1;

	@FXML
	private ComboBox<User> usersCombo;

	@FXML
	private ComboBox<Item> productsCombo;

	@FXML
	private TextField amountText;

	@FXML
	private Button addButton;

    private TableView<Item> table;

    @FXML
    private TableColumn<Item, Integer> itemID;

    @FXML
    private TableColumn<Item, Integer> quantity;

	@FXML
	private Label lable;

	@FXML
	private Label price;

	@FXML
	private Label btc;

	@FXML
	private Button createButton;

	@FXML
	private Button delettButton;

	@FXML
	private Label errorMassage;

	@FXML
	private Button recButton;

	@FXML
	private TextField feeText;

	@FXML
	private ComboBox<Wallet> walletCombo;

	@FXML
	private ScrollPane scroll;

	@FXML
	private TableView<Transaction> waitingTable;

	@FXML
	private TableColumn<Transaction, Date> creationDate;

	@FXML
	private TableColumn<Transaction, Date> executionDate;

	@FXML
	private TableColumn<Transaction, String> status;

	@FXML
	private TableColumn<Transaction, String> adress;

	@FXML
	private TableColumn<Transaction, String> signature;

	@FXML
	private Button confirmButton;

	@FXML
	private Button unButton;

	@FXML
	private ComboBox<Wallet> walletsCombo;


	public void initialize() {
		
		//Fill the User Combo Box
		ArrayList<User> users = new ArrayList<User>();
		users= control.UserLogic.getInstance().getUsers();
    	 
 			 usersCombo.getItems().addAll(users);
 		   
 			ObservableList<User> us= FXCollections.observableArrayList(users);
 	 	    usersCombo.setItems(us);	
 	 	    
 	 	    //Fill the pay transaction table
		creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		executionDate.setCellValueFactory(new PropertyValueFactory<>("executionDate"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		adress.setCellValueFactory(new PropertyValueFactory<>("destinationAdress"));
		signature.setCellValueFactory(new PropertyValueFactory<>("destinationSignature"));

		//Fill the Pay transactions of the current user
		getPayTransactions();
		
		//Fill the wallets comboBox of the current user
		ObservableList<Wallet> w=getWallets();
	 	    walletCombo.setItems(w);
	 	    walletsCombo.setItems(w);
	 	    
	} 
	

	//Fill the wallet comboBox
	 @FXML
	   public ObservableList<Wallet> getWallets() {
		 	ArrayList<Wallet> wallets = new ArrayList<Wallet>();
			wallets= control.WalletLogic.getInstance().getWallets();
			ObservableList<Wallet> w = FXCollections.observableArrayList();
		  
		   for(Wallet wt : wallets)
		   {
			   if(wt.getUserAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress())
					   && wt.getUserSignature().equalsIgnoreCase
					   (LoginController.curretUser.getSignature()))
			   w.add(wt);
		   }			
		   return w;
//	 	    walletsCombo.setItems(w);
		   }
	 
	
	
	//Fill the product combo according to the chosen user
	
	 @FXML
	    void productsOfUser(ActionEvent event) {

		   ObservableList<Item> I= FXCollections.observableArrayList();
		   ArrayList<Item> Items = control.ItemLogic.getInstance().getItems();
		   if (usersCombo.getSelectionModel()!=null) {
		   for(Item itms : Items)
		   {
			   if(itms.getSellerAddress().equalsIgnoreCase(usersCombo.getSelectionModel().getSelectedItem().getPublicAddress())
					   && itms.getSellerSignature().equalsIgnoreCase
					   (usersCombo.getSelectionModel().getSelectedItem().getSignature()))
			   I.add(itms);
		   }			
		   
	 	    productsCombo.setItems(I);
		   }
		   
		   
		   itemID.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
			quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	 }
	 
	    
	public void getPayTransactions(){

		ObservableList<Transaction> t= FXCollections.observableArrayList();
		ArrayList<Transaction> pay = control.TransLogic.getInstance().getAllTrans();
		for(Transaction tp : pay)
		{
			if(E_TransType.Pay.equals(tp.getType()) &&
					tp.getCreatingAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress()) && 
					tp.getCreatingSignature().equalsIgnoreCase(LoginController.curretUser.getSignature()))

				t.add(tp);
		}

		waitingTable.setItems(t);	   
		waitingTable.refresh();
	}


	@FXML
	void NewConfirmTransaction(ActionEvent event) {

	}

	@FXML
	void NewPayTransaction(ActionEvent event) {

	}

	@FXML
	void addToTable(ActionEvent event) {
		int itemID = productsCombo.getSelectionModel().getSelectedItem().getCatalogNumber();
		if (quantity.getText()!=null && productsCombo.getSelectionModel()!=null) {
			try {
		String convert = (quantity.getText());
    	Integer x = Integer.parseInt(convert);
    	Item items = new Item(itemID);
    	items.setQuantity(x);
    	ObservableList<Item> item= FXCollections.observableArrayList();
    	item.add(items);
    	table.setItems(item);
		}
			catch (NumberFormatException e){
				lable.setText("Invalid Value");
			}
	}
    	
	}


	@FXML
	void switch1(MouseEvent event) {

	}

	@FXML
	void switch2(MouseEvent event) {

	}

	@FXML
	void switch3(MouseEvent event) {

	}


	@FXML
	void unconfirmed(ActionEvent event) {

	}

	@FXML
	void viewRecommendations(ActionEvent event) {
		ViewLogic.newViewRecommendationWindow();
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
		closeWindow();
		ViewLogic.newProductsWindow();
	}

	@FXML
	void searchProducts(MouseEvent event) {
		closeWindow();
		ViewLogic.newSearchPageWindow();
	}

	@FXML
	void settingsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newSettingsWindow();
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

