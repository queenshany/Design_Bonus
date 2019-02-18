package boundary;

import control.Validation;
import entity.Consts;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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

		if (control.Validation.validName(usernameText.getText())) {
			usernameLable.setVisible(false);

			if (passwordText.getText() != null){
				passwordLable.setVisible(false);

				if (!passwordText.getText().isEmpty()) {
					passwordLable.setVisible(false);

					if (passwordText.getText().equals(verifyText.getText())) {
						passwordLable.setVisible(false);

						if (control.Validation.validEmailAddress(emailText.getText())) {
							emailLable.setVisible(false);

							if (combo.getSelectionModel().getSelectedItem() != null) {
								phoneLable.setVisible(false);

								if (control.Validation.validPhone(phoneText.getText())){
									phoneLable.setVisible(false);

									String publicAddress;
									String sig;

									do {
										publicAddress = control.SysData.getInstance().generateRandomStrings(Consts.USER_ADDRESS_LENGTH);
										sig = control.SysData.getInstance().generateRandomStrings(Consts.USER_SIGNATURE_LENGTH);
									}
									while (control.UserLogic.getInstance().getUsers().contains(new User(publicAddress, sig)));

									User user = new User(publicAddress,
											sig,
											usernameText.getText(),
											passwordText.getText(), 
											combo.getSelectionModel().getSelectedItem() + "-" + phoneText.getText(),
											emailText.getText(), 
											false);
									control.UserLogic.getInstance().insertUser(user);

									//Wallet for new user
									control.WalletLogic.getInstance().generateWalletForNewUser(user);
									closeWindow();
									ViewLogic.newLoginWindow();
								}else {
									phoneLable.setVisible(true);
									phoneLable.setText("Phone is invalid.");
								}
							}else {
								phoneLable.setVisible(true);
								phoneLable.setText("Please select an area code.");
							}
						}else {
							emailLable.setVisible(true);
							emailLable.setText("Email is invalid.");
						}
					}else {
						passwordLable.setText("Please try again.");
						passwordLable.setVisible(true);
					}
				}else {
					passwordLable.setText("Please enter a password.");
					passwordLable.setVisible(true);
				}
			}else {
				passwordLable.setText("Please enter a password.");
				passwordLable.setVisible(true);
			}

		}else {
			usernameLable.setVisible(true);
			usernameLable.setText(("Username is invalid."));
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
