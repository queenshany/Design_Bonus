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

public class SettingsController {


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView mailIcon;

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
    private Button updateButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField firstText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField lastText;

    @FXML
    private TextField contactMailText;

    @FXML
    private ComboBox<?> comboPhone;

    @FXML
    private Label errorMinerName;

    @FXML
    private Label errorContactFirst;

    @FXML
    private Label errorPhone;

    @FXML
    private Label errorMinerEmail;

    @FXML
    private Label errorContactLast;

    @FXML
    private Label errorContactMail;


    public void initialize() {
    	
    	nameText.setText(LoginController.curretMiner.getMinerName());
    	emailText.setText(LoginController.curretMiner.getEmail());
    	
    	if (control.MinerLogic.getInstance().isMinerACompany(LoginController.curretMiner)) {
    	firstText.setDisable(false);
    	lastText.setDisable(false);
    	phoneText.setDisable(false);
    	comboPhone.setDisable(false);
    	contactMailText.setDisable(false);
        	
    	}
    	
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
    void updateMiner(ActionEvent event) {

    }

    protected void closeWindow() {
 		((Stage) borderPane.getScene().getWindow()).close();
 	}
    
}
