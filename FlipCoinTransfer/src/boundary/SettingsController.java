package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsController extends AbstractController {

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
    private HBox HBox4;

    @FXML
    private Label phone;

    @FXML
    private ComboBox<?> combo;

    @FXML
    private TextField phoneText;

    @FXML
    private Label phoneLable;

    @FXML
    private HBox Hbox5;

    @FXML
    private Label email;

    @FXML
    private TextField emailText;

    @FXML
    private Label emailLable;

    @FXML
    private Button saveButton;
    
    public void initialize() {
    	emailText.setText(LoginController.curretUser.getEmail());
    	phoneText.setText(LoginController.curretUser.getPhone());
    }
    
    @FXML
    void updateField(ActionEvent event) {
    	LoginController.curretUser.setEmail(emailText.getText());
    	LoginController.curretUser.setPhone(phoneText.getText());
    	control.UserLogic.getInstance().updateUser(LoginController.curretUser);
    }

    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newUserWindow();
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
    void walletsScreen(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newWalletsWindow();
    }


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}