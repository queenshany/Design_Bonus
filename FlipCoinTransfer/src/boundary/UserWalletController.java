package boundary;

import java.util.ArrayList;

import entity.Item;
import entity.Wallet;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import utils.E_WalletType;

public class UserWalletController {

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
	private TabPane tabPane;

	@FXML
	private Tab yourWallet;

	@FXML
	private AnchorPane walletPane;

	@FXML
	private TableView<Wallet> walletTable;

	@FXML
	private TableColumn<Wallet, String> id;

	@FXML
	private TableColumn<Wallet, Double> amount;

	@FXML
	private TableColumn<Wallet, Double> pending;

	@FXML
	private TableColumn<Wallet, Boolean> pc;

	@FXML
	private TableColumn<Wallet, Boolean> phone;

	@FXML
	private TableColumn<Wallet, Boolean> tablet;

	@FXML
	private Button chargeButton;

	@FXML
	private Tab bitcoinSpace;

	@FXML
	private AnchorPane walletPane1;

	@FXML
	private TableView<WalletBitcoinSpace> walletTable1;

	@FXML
	private TableColumn<WalletBitcoinSpace, String> id1;

	@FXML
	private TableColumn<WalletBitcoinSpace, Integer> transSize;

	@FXML
	private TableColumn<WalletBitcoinSpace, Double> amount1;

	@FXML
	private TableColumn<WalletBitcoinSpace, Double> pending1;

	@FXML
	private TableColumn<WalletBitcoinSpace, Boolean> pc1;

	@FXML
	private TableColumn<WalletBitcoinSpace, Boolean> phone1;

	@FXML
	private TableColumn<WalletBitcoinSpace, Boolean> tablet1;

	@FXML
	private Button editSpaceButton;

	@FXML
	private Tab BitcoinKnots;

	@FXML
	private AnchorPane walletPane11;

	@FXML
	private TableView<WalletBitcoinKnots> walletTable11;

	@FXML
	private TableColumn<WalletBitcoinKnots, String> id11;

	@FXML
	private TableColumn<WalletBitcoinKnots, Double> discount;

	@FXML
	private TableColumn<WalletBitcoinKnots, Double> amount11;

	@FXML
	private TableColumn<WalletBitcoinKnots, Double> pending11;

	@FXML
	private TableColumn<WalletBitcoinKnots, Boolean> pc11;

	@FXML
	private TableColumn<WalletBitcoinKnots, Boolean> phone11;

	@FXML
	private TableColumn<WalletBitcoinKnots, Boolean> tablet11;

	@FXML
	private Button editKnotsButton;

	@FXML
	private Tab newWallet;

	@FXML
	private AnchorPane newPane;

	@FXML
	private Button space;

	@FXML
	private Button knots;

	@FXML
	private Label pleaseChoose;
	
	protected static Wallet currentWallet;

	public void initialize() {
		bp = borderPane;

		//Space Wallet
		id1.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		transSize.setCellValueFactory(new PropertyValueFactory<>("transSize"));
		amount1.setCellValueFactory(new PropertyValueFactory<>("amount"));
		pending1.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));
		pc1.setCellValueFactory(new PropertyValueFactory<>("isOnPC"));
		phone1.setCellValueFactory(new PropertyValueFactory<>("isOnPhone"));
		tablet1.setCellValueFactory(new PropertyValueFactory<>("isOnTablet"));

		getSpace(); 

		//Basic Wallet
		id.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		pending.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));
		pc.setCellValueFactory(new PropertyValueFactory<>("isOnPC"));
		phone.setCellValueFactory(new PropertyValueFactory<>("isOnPhone"));
		tablet.setCellValueFactory(new PropertyValueFactory<>("isOnTablet"));
		
		//Knots Wallet
		id11.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		discount.setCellValueFactory(new PropertyValueFactory<>("discountPercent"));
		amount11.setCellValueFactory(new PropertyValueFactory<>("amount"));
		pending11.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));
		pc11.setCellValueFactory(new PropertyValueFactory<>("isOnPC"));
		phone11.setCellValueFactory(new PropertyValueFactory<>("isOnPhone"));
		tablet11.setCellValueFactory(new PropertyValueFactory<>("isOnTablet"));

		getKnots();
		
//		ObservableList<Wallet> w= FXCollections.observableArrayList();
//		ArrayList<Wallet> basic = control.WalletLogic.getInstance().getWalletsOfUser(LoginController.curretUser);
//		w.addAll(basic);
//		walletTable.setItems(w);
//		walletTable.refresh();
		
		getWallet();

	} 
	
	
	public void getWallet(){
		ObservableList<Wallet> w= FXCollections.observableArrayList();
		ArrayList<Wallet> basic = control.WalletLogic.getInstance().getWalletsOfUser(LoginController.curretUser);
		w.addAll(basic);
		walletTable.setItems(w);
		walletTable.refresh();
	}

	public void getSpace(){

		ObservableList<WalletBitcoinSpace> s= FXCollections.observableArrayList();
		ArrayList<WalletBitcoinSpace> space = control.WalletLogic.getInstance().getWalletsSpaceOfUser(LoginController.curretUser);
		s.addAll(space);
		walletTable1.setItems(s);
		walletTable1.refresh();
	}
	
	public void getKnots(){

		ObservableList<WalletBitcoinKnots> k= FXCollections.observableArrayList();
		ArrayList<WalletBitcoinKnots> knots = control.WalletLogic.getInstance().getWalletsKnotsOfUser(LoginController.curretUser);
		k.addAll(knots);
		walletTable11.setItems(k);
		walletTable11.refresh();
	}

	@FXML
	void chargeMoney(ActionEvent event) {
		if (currentWallet!=null)
		ViewLogic.newChargerWindow();
		//else - Add Massage
	}
	
    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newUserWindow();
    }

    @FXML
    void chosenKnots(MouseEvent event) {
    	currentWallet = walletTable11.getSelectionModel().getSelectedItem();
    }

    @FXML
    void chosenSpace(MouseEvent event) {
    	currentWallet = walletTable1.getSelectionModel().getSelectedItem();
    }

	   @FXML
	    void chosenWallet(MouseEvent event) {
		   currentWallet = walletTable.getSelectionModel().getSelectedItem();
	    }
	
	@FXML
	void editKnots(ActionEvent event) {
		if (currentWallet.getType().equals(E_WalletType.BitcoinKnots))
		ViewLogic.newExpandKnotsWindow();
		//else - Massage
	}

	@FXML
	void editSpace(ActionEvent event) {
		if (currentWallet.getType().equals(E_WalletType.BitcoinSpace))
		ViewLogic.newExpandSpaceWindow();
		//else - Massage
	}


	@FXML
	void newBitcoinKnots(ActionEvent event) {
		ViewLogic.newBitcoinKnotsWindow();
	}

	@FXML
	void newBitcoinSpace(ActionEvent event) {
		ViewLogic.newBitcoinSpaceWindow();
	}

	@FXML
	void expandWallet(ActionEvent event) {

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