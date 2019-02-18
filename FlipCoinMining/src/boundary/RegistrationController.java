package boundary;

import entity.Consts;
import entity.Miner;
import entity.MinerCompany;
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

public class RegistrationController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox topBorder;

	@FXML
	private ImageView registerTitle;

	@FXML
	private Label clickHere;

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
	private HBox Hbox51;

	@FXML
	private Label email1;

	@FXML
	private TextField emailText1;

	@FXML
	private Label emailLable1;

	@FXML
	private HBox HBox11;

	@FXML
	private Label username1;

	@FXML
	private TextField usernameText1;

	@FXML
	private TextField usernameText11;

	@FXML
	private Label usernameLable1;

	@FXML
	private HBox HBox4;

	@FXML
	private Label phone;

	@FXML
	private ComboBox<E_Phone> combo;

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

	protected static int flag = 0;

	public void initialize() {
		setPhoneCombo();
	}

	private void setPhoneCombo() {
		combo.getItems().setAll(E_Phone.values());
		combo.getSelectionModel().select(0);
		System.out.println(combo.getSelectionModel().getSelectedItem());
	}

	@FXML
	void newAccount(MouseEvent event) {

		//Miner miner = control.MinerLogic.getInstance().getMiners().get(0);
		if (control.Validation.validName(usernameText.getText())) {
			usernameLable.setVisible(false);

			if (passwordText.getText() != null){
				passwordLable.setVisible(false);

				if (!passwordText.getText().isEmpty()) {
					passwordLable.setVisible(false);

					if (passwordText.getText().equals(verifyText.getText())) {
						passwordLable.setVisible(false);
						if (control.Validation.validEmailAddress(emailText1.getText())) {
							emailLable1.setVisible(false);

							String uniqueAddress;
							do {
								uniqueAddress = control.SysData.getInstance().generateRandomStrings(Consts.MINER_ADDRESS_LENGTH);
							}
							while (control.MinerLogic.getInstance().getMiners().contains(new Miner(uniqueAddress)));

							if (flag == 1) {

								// contact first name
								if (control.Validation.validName(usernameText1.getText())) {
									usernameLable1.setVisible(false);

									// contact last name
									if (control.Validation.validName(usernameText11.getText())) {
										usernameLable1.setVisible(false);

										if (combo.getSelectionModel().getSelectedItem() != null) {
											phoneLable.setVisible(false);

											if (control.Validation.validPhone(phoneText.getText())){
												phoneLable.setVisible(false);

												if (control.Validation.validEmailAddress(emailText.getText())){
													emailLable.setVisible(false);

													MinerCompany miner = new MinerCompany(uniqueAddress,
															usernameText.getText(),
															passwordText.getText(),
															emailText1.getText(), 
															0,
															usernameText1.getText(),
															usernameText11.getText(),
															combo.getSelectionModel().getSelectedItem() + "-" + phoneText.getText(),
															emailText.getText());
													control.MinerLogic.getInstance().insertMinerCompany(miner);
													Alert alert = new Alert(AlertType.CONFIRMATION);
													alert.setTitle("Congrats!");
													alert.setContentText("You have registered Successfully. +\n"
															+"Your username is: " + uniqueAddress +" .\nWe recommend you write it down, as it will be used to use the system");
													alert.initModality(Modality.APPLICATION_MODAL);
													alert.showAndWait();
													closeWindow();
													ViewLogic.newLoginWindow();
												}else {
													emailLable.setVisible(true);
													emailLable.setText("Email is invalid.");
												}
											}else {
												phoneLable.setVisible(true);
												phoneLable.setText("Phone is invalid.");
											}
										}else {
											phoneLable.setVisible(true);
											phoneLable.setText("Please select an area code.");
										}
									}else {
										usernameLable1.setVisible(true);
										usernameLable1.setText("Last name is invalid.");
									}
								}else {
									usernameLable1.setVisible(true);
									usernameLable1.setText("Last name is invalid.");
								}
							}
							else {
								Miner miner = new Miner(uniqueAddress, usernameText.getText(),passwordText.getText(),emailText1.getText(), 0);
								control.MinerLogic.getInstance().insertMiner(miner);
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setTitle("Congrats!");
								alert.setContentText("You have registered Successfully. +\n"
										+"Your username is: " + uniqueAddress +" .\nWe recommend you write it down, as it will be used to use the system");
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.showAndWait();
								closeWindow();
								ViewLogic.newLoginWindow();
							}
						}else {
							emailLable1.setVisible(true);
							emailLable1.setText("Email is invalid.");
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

	@FXML
	void openCompanyField(MouseEvent event) {
		flag = 1;
		HBox11.setVisible(true);
		HBox4.setVisible(true);
		Hbox5.setVisible(true);
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
