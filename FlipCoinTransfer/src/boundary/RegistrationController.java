package boundary;

import control.Validation;
import entity.Consts;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.E_Phone;

public class RegistrationController extends AbstractController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox topBorder;

    @FXML
    private ImageView registerTitle;

    @FXML
    private Label titleLable;

    @FXML
    private VBox centerBorder;

    @FXML
    private HBox HBox1;

    @FXML
    private Label username;

    @FXML
    private TextField usernameText;

    @FXML
    private Label usernameLable;

    @FXML
    private HBox HBox2;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Label passwordLable;

    @FXML
    private HBox HBox3;

    @FXML
    private Label verify;

    @FXML
    private PasswordField verifyText;

    @FXML
    private Label verifyLable;

    @FXML
    private HBox HBox4;

    @FXML
    private Label phone;

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
    private Label registerLable;
    
    @FXML
	private ComboBox<E_Phone> combo;

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
    
    @FXML
    void newAccount(MouseEvent event) {
    	
    	User user = control.UserLogic.getInstance().getUsers().get(0);
    	
//    	if (Validation.validName(usernameText.getText()))

    	
		String publicAddress;
		String sig;
		
    	do {
    		publicAddress = control.SysData.getInstance().generateRandomStrings(Consts.USER_ADDRESS_LENGTH);
    		sig = control.SysData.getInstance().generateRandomStrings(Consts.USER_SIGNATURE_LENGTH);
		}
		while (control.UserLogic.getInstance().getUsers().contains(new User(publicAddress, sig)));
//		miner.setUniqueAddress(uniqueAddress);		
    	
    	user.setPublicAddress(publicAddress);
    	user.setSignature(sig);
    	
//    	user.setPublicAddress(control.SysData.getInstance().generateRandomStrings(Consts.USER_ADDRESS_LENGTH));
//    	user.setSignature(control.SysData.getInstance().generateRandomStrings(Consts.USER_SIGNATURE_LENGTH));
    	user.setUsername(usernameText.getText());
    	user.setPassword(passwordText.getText());
    	user.setPhone(combo.getSelectionModel().getSelectedItem() + "-" + phoneText.getText());
    	user.setEmail(emailText.getText());
    	if (passwordText.getText().equals(verifyText.getText())) {
    		control.UserLogic.getInstance().insertUser(user);
    		//Wallet for new user
    		control.WalletLogic.getInstance().generateWalletForNewUser(user);
    	closeWindow();
    	ViewLogic.newLoginWindow();
    	}
    }

	public void initialize() {
//		System.out.println("h");
		setPhoneCombo();
	}

	private void setPhoneCombo() {
		combo.getItems().setAll(E_Phone.values());
		combo.getSelectionModel().select(0);
		System.out.println(combo.getSelectionModel().getSelectedItem());
	}
	
}
