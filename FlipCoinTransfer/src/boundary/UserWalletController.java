package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserWalletController {

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
    private TableView<?> walletTable;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> amount;

    @FXML
    private TableColumn<?, ?> pending;

    @FXML
    private TableColumn<?, ?> pc;

    @FXML
    private TableColumn<?, ?> phone;

    @FXML
    private TableColumn<?, ?> tablet;

    @FXML
    private Button chargeButton;

    @FXML
    private Tab bitcoinSpace;

    @FXML
    private AnchorPane walletPane1;

    @FXML
    private TableView<?> walletTable1;

    @FXML
    private TableColumn<?, ?> id1;

    @FXML
    private TableColumn<?, ?> transSize;

    @FXML
    private TableColumn<?, ?> amount1;

    @FXML
    private TableColumn<?, ?> pending1;

    @FXML
    private TableColumn<?, ?> pc1;

    @FXML
    private TableColumn<?, ?> phone1;

    @FXML
    private TableColumn<?, ?> tablet1;

    @FXML
    private Button editSpaceButton;

    @FXML
    private Tab BitcoinKnots;

    @FXML
    private AnchorPane walletPane11;

    @FXML
    private TableView<?> walletTable11;

    @FXML
    private TableColumn<?, ?> id11;

    @FXML
    private TableColumn<?, ?> discount;

    @FXML
    private TableColumn<?, ?> amount11;

    @FXML
    private TableColumn<?, ?> pending11;

    @FXML
    private TableColumn<?, ?> pc11;

    @FXML
    private TableColumn<?, ?> phone11;

    @FXML
    private TableColumn<?, ?> tablet11;

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

    @FXML
    void chargeMoney(ActionEvent event) {

    }

    @FXML
    void editKnots(ActionEvent event) {

    }

    @FXML
    void editSpace(ActionEvent event) {

    }

	public void initialize() {

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