package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private ComboBox<?> usersCombo;

    @FXML
    private ComboBox<?> productsCombo;

    @FXML
    private TextField amountText;

    @FXML
    private Button addButton;

    @FXML
    private TableView<?> table;

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
    private ComboBox<?> walletCombo;

    @FXML
    private Button confirmButton;

    @FXML
    private Button unButton;

    @FXML
    private ComboBox<?> walletsCombo;

    @FXML
    void NewConfirmTransaction(ActionEvent event) {

    }

    @FXML
    void NewPayTransaction(ActionEvent event) {

    }

    @FXML
    void addToTable(ActionEvent event) {

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



	public void initialize() {
//		System.out.println("h");
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}

