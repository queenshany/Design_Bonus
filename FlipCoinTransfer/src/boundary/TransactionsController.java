package boundary;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

import control.RecLogic;
import control.Validation;
import entity.User;
import entity.Wallet;
import entity.Item;
import entity.ItemInTransaction;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.E_Status;
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

	@FXML
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
	private TableView<TransactionPay> waitingTable;

	@FXML
	private TableColumn<TransactionPay, Date> creationDate;

	@FXML
	private TableColumn<TransactionPay, Date> executionDate;

	@FXML
	private TableColumn<TransactionPay, String> status;

	@FXML
	private TableColumn<TransactionPay, String> adress;

	@FXML
	private TableColumn<TransactionPay, String> signature;

	@FXML
	private TableView<TransactionPay> confirmTable;

	@FXML
	private TableColumn<TransactionPay, Integer> IDconfirm;

	@FXML
	private TableColumn<TransactionPay, Date> creationDateConfirm;

	@FXML
	private TableColumn<TransactionPay, String> creating1confirm;

	@FXML
	private TableColumn<TransactionPay, String> creating2confirm;

	@FXML
	private Button confirmButton;

	@FXML
	private Button unButton;

	@FXML
	private ComboBox<Wallet> walletsCombo;
	
    @FXML
    private Label alertConfrim;

	protected User user;

	protected static TransactionPay tranConfirm;
	protected static Item chosenItem;

	private ArrayList<Item> chosenItems = new ArrayList();

	//ObservableList<Item> i = FXCollections.observableArrayList();

	public void initialize() {
		btc.setVisible(false);
		price.setText("0");
		unButton.setVisible(false);

		//Fill the User Combo Box
		ArrayList<User> users = new ArrayList<User>();
		users= control.UserLogic.getInstance().getUsers();

		usersCombo.getItems().addAll(users);

		ObservableList<User> us= FXCollections.observableArrayList(users);
		us.remove(LoginController.curretUser);
		usersCombo.setItems(us);


		//Fill the pay transaction table
		creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		executionDate.setCellValueFactory(new PropertyValueFactory<>("executionDate"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		adress.setCellValueFactory(new PropertyValueFactory<>("destinationAdress"));
		signature.setCellValueFactory(new PropertyValueFactory<>("destinationSignature"));

		//i.setAll(chosenItems);

		//	table.setItems(i);
		//Fill the Pay transactions of the current user
		getPayTransactions();

		//Fill the wallets comboBox of the current user
		ObservableList<Wallet> w=getWallets();
		walletCombo.setItems(w);
		walletsCombo.setItems(w);

		//Chosen Products
		itemID.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		//		ArrayList<Item> i = new ArrayList<Item>();
		//		i = control.ItemLogic.getInstance().getItems();
		//		ObservableList<Item> pro = FXCollections.observableArrayList();
		//		pro.addAll(i);
		//		table.setItems(pro);


		//Fill Confirm Table
		IDconfirm.setCellValueFactory(new PropertyValueFactory<>("transID"));
		creationDateConfirm.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		creating1confirm.setCellValueFactory(new PropertyValueFactory<>("creatingAddress"));
		creating2confirm.setCellValueFactory(new PropertyValueFactory<>("creatingSignature"));

		//Fill the confirm transactions of the current user
		getConfrimTransactions();
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

	@FXML
	void deleteProduct(ActionEvent event) {
		chosenItem=table.getSelectionModel().getSelectedItem();
		if (chosenItem!=null) {
			ObservableList<Item> items = table.getItems();
			items.remove(chosenItem);
			table.setItems(items);
			calcAmount();
		}
	}

	void calcAmount() {
		double price = 0;
		ObservableList<Item> items = table.getItems();
		for (Item i : items) {
			price = price + (i.getPrice()*i.getQuantity());
		}
		this.price.setText(String.valueOf(price) + "BTC");
	}

	//Fill the product combo according to the chosen user

	@FXML
	void productsOfUser(ActionEvent event) {

		//		usersCombo.setDisable(true);
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
	}



	public void getPayTransactions(){

		ObservableList<TransactionPay> t= FXCollections.observableArrayList();
		ArrayList<TransactionPay> pay = control.TransLogic.getInstance().getAllPayTrans();
		for(TransactionPay tp : pay)
		{
			if(E_TransType.Pay.equals(tp.getType()) &&
					tp.getCreatingAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress()) && 
					tp.getCreatingSignature().equalsIgnoreCase(LoginController.curretUser.getSignature()))

				t.add(tp);
		}

		waitingTable.setItems(t);	   
		waitingTable.refresh();
	}



	public void getConfrimTransactions(){

		ObservableList<TransactionPay> t= FXCollections.observableArrayList();
		ArrayList<TransactionPay> confirm = control.TransLogic.getInstance().getAllPayTrans();
		for(TransactionPay tp : confirm)
		{
			if(E_TransType.Pay.equals(tp.getType()) &&
					tp.getStatus().equals(E_Status.Pending) &&
					tp.getDestinationAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress()) && 
					tp.getDestinationSignature().equalsIgnoreCase(LoginController.curretUser.getSignature()))

				t.add(tp);
		}

		confirmTable.setItems(t);	   
		confirmTable.refresh();
	}


	@FXML
	void chosenConfrimTrans(MouseEvent event) {
		tranConfirm = confirmTable.getSelectionModel().getSelectedItem();
	}

	@FXML
	void NewConfirmTransaction(ActionEvent event) {
		double fee = Double.parseDouble(feeText.getText());
		if (tranConfirm!=null)
		if (feeText.getText()!=null && Validation.isPositiveDouble(fee)
				&&walletsCombo.getSelectionModel() != null) {
			TransactionPay tc = tranConfirm;
			TransactionConfirm confirm = control.TransLogic.getInstance().getAllConfirmTrans().get(0);
			confirm.setTransID(control.TransLogic.getInstance().getTransID());
			confirm.setDestinationAddress(tc.getCreatingAddress());
			confirm.setDestinationSignature(tc.getCreatingSignature());
			confirm.setCreatingAddress(LoginController.curretUser.getPublicAddress());
			confirm.setCreatingSignature(LoginController.curretUser.getSignature());
			confirm.setWalletAddress(walletsCombo.getSelectionModel().getSelectedItem().getUniqueAddress());
			confirm.setTransPayID(tc.getTransID());
			control.TransLogic.getInstance().insertTransConfirm(confirm);
		}
		else 
			alertConfrim.setVisible(true);
			alertConfrim.setText("Please choose a transaction and a wallet");
	}

	@FXML
	void NewPayTransaction(ActionEvent event) {

		//		int transID = control.TransLogic.getInstance().getTransID();
		//		String description = null;
		//		int size = 6;
		////		Date creationDate = Date(LocalDate.now());
		////		Date executionDate = Date(LocalDate.now());
		////		try {
		//		double fee = Double.parseDouble(feeText.getText());
		////		}
		////		catch(NumberFormatException e){
		////			feeText.setText("Invalid Value");
		////		}
		//		E_Status status = E_Status.Pending;
		//		String creatingAddress = LoginController.curretUser.getPublicAddress();
		//		String creatingSignature = LoginController.curretUser.getSignature();
		////		if (walletCombo.getSelectionModel().getSelectedItem() != null) {
		//		String walletAddress = walletCombo.getSelectionModel().getSelectedItem().getUniqueAddress();
		////		}
		//		E_TransType type = E_TransType.Pay;
		//		double payValue = Double.parseDouble(amountText.getText()) + Double.parseDouble(feeText.getText());
		//		String destinationAddress = usersCombo.getSelectionModel().getSelectedItem().getPublicAddress();
		//		String destinationSignature = usersCombo.getSelectionModel().getSelectedItem().getSignature();
		//			
		//		TransactionPay tp = new TransactionPay(transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, payValue)
		//		
		//				control.TransLogic.getInstance().insertTransPay(tp);

		networkStatus.setText(control.SysData.getInstance().getMode().toString());
		
	}

	@FXML
	void addToTable(ActionEvent event) {
		//		int itemID = productsCombo.getSelectionModel().getSelectedItem().getCatalogNumber();
		//		if ((quantity.getText()!=null || quantity.getText() =="" ) && productsCombo.getSelectionModel()!=null) {
		////			try {
		////				String convert = (amountText.getText());
		//				Integer x = Integer.parseInt(amountText.getText());
		//				Item item = productsCombo.getValue();
		//System.out.println(item);
		//				Item items = new Item(itemID);
		//				item.setQuantity(x);
		//				System.out.println(item);
		//				itemID.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		//				quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		//				ObservableList<Item> i = FXCollections.observableArrayList();
		//				chosenItems.add(item);

		//				i.setAll(chosenItems);

		table.setItems(getProductsTable());
		//i.setAll(item);
		//table.getItems().setAll(i);
		table.refresh();
		calcAmount();
		//table.setItems(i);
		//			}	
		//			catch (NumberFormatException e){
		//				lable.setText("Invalid Value");
	}
	//		}
	//		}

	ObservableList<Item> getProductsTable(){
		if ((quantity.getText()!=null || quantity.getText() =="" ) && productsCombo.getSelectionModel()!=null) {
			Integer x = Integer.parseInt(amountText.getText());
			Item item = productsCombo.getValue();
			item.setQuantity(x);
			ObservableList<Item> i = FXCollections.observableArrayList();
			chosenItems.add(item);
			i.setAll(chosenItems);
			productsCombo.setValue(null);
			amountText.setText("");
			return i;
		}
		return null;
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
		//ViewLogic.newViewRecommendationWindow();
		if (LoginController.curretUser == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("User is null");
			alert.setContentText("Please select user");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}else {
			JFrame reportFrame = RecLogic.getInstance().produceViewRecommendationsReport(LoginController.curretUser);
			reportFrame.setVisible(true);
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
		closeWindow();
		ViewLogic.newProductsWindow();
	}

	@FXML
	void searchProducts(MouseEvent event) {
		LoginController.keyWord = searchText.getText();
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
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newUserWindow();
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

