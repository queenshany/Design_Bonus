package boundary;

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
    private TableColumn<?, ?> c1;

    @FXML
    private TableColumn<?, ?> c2;

    @FXML
    private Button expandButton;

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
    void logOut(MouseEvent event) {

    }

    @FXML
    void mailsScreen(MouseEvent event) {

    }

    @FXML
    void productsScreen(MouseEvent event) {

    }

    @FXML
    void searchProducts(MouseEvent event) {

    }

    @FXML
    void settingsScreen(MouseEvent event) {

    }

    @FXML
    void transactionsScreen(MouseEvent event) {

    }

    @FXML
    void walletsScreen(MouseEvent event) {

    }

}
