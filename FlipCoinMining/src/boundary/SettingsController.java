package boundary;

import entity.Consts;
import entity.Miner;
import entity.MinerCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	private ComboBox<E_Phone> comboPhone;

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

	private static boolean flag;
	MinerCompany mc;

	public void initialize() {

		nameText.setText(LoginController.curretMiner.getMinerName());
		emailText.setText(LoginController.curretMiner.getEmail());

		if (control.MinerLogic.getInstance().isMinerACompany(LoginController.curretMiner)) {
			mc = control.MinerLogic.getInstance().getMinerCompanyDetails(LoginController.curretMiner);
			flag = true;
			firstText.setDisable(false);
			lastText.setDisable(false);
			phoneText.setDisable(false);
			comboPhone.setDisable(false);
			contactMailText.setDisable(false);

			contactMailText.setText(mc.getContactEmail());
			lastText.setText(mc.getContactLastName());
			firstText.setText(mc.getContactFirstName());
			String[] phoneParts = mc.getContactPhone().split("-");
			setPhoneCombo(phoneParts[0]);
			phoneText.setText(phoneParts[1]);
		}else
			flag = false;

	}

	private void setPhoneCombo(String s) {
		comboPhone.getItems().setAll(E_Phone.values());
		comboPhone.getSelectionModel().select(E_Phone.getPhone(s));
		System.out.println(comboPhone.getSelectionModel().getSelectedItem());
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
		//Miner miner = control.MinerLogic.getInstance().getMiners().get(0);
		if (control.Validation.validName(nameText.getText())) {
			errorMinerName.setVisible(false);

			if (control.Validation.validEmailAddress(emailText.getText())) {
				errorMinerEmail.setVisible(false);

				if (flag) {

					// contact first name
					if (control.Validation.validName(firstText.getText())) {
						errorContactFirst.setVisible(false);

						// contact last name
						if (control.Validation.validName(lastText.getText())) {
							errorContactLast.setVisible(false);

							if (comboPhone.getSelectionModel().getSelectedItem() != null) {
								errorPhone.setVisible(false);

								if (control.Validation.validPhone(phoneText.getText())){
									errorPhone.setVisible(false);

									if (control.Validation.validEmailAddress(contactMailText.getText())){
										errorContactMail.setVisible(false);

										mc.setMinerName(nameText.getText());
										mc.setEmail(emailText.getText());
										mc.setContactPhone(comboPhone.getSelectionModel().getSelectedItem() + "-" + phoneText.getText());
										mc.setContactLastName(lastText.getText());
										mc.setContactFirstName(firstText.getText());
										mc.setContactEmail(contactMailText.getText());

										control.MinerLogic.getInstance().updateMiner(mc);
										control.MinerLogic.getInstance().updateMinerCompany(mc);

										Alert alert = new Alert(AlertType.CONFIRMATION);
										alert.setTitle("Congrats!");
										alert.setContentText("Details Updated Successfully");
										alert.initModality(Modality.APPLICATION_MODAL);
										alert.showAndWait();

									}else {
										errorContactMail.setVisible(true);
										errorContactMail.setText("Email is invalid.");
									}
								}else {
									errorPhone.setVisible(true);
									errorPhone.setText("Phone is invalid.");
								}
							}else {
								errorPhone.setVisible(true);
								errorPhone.setText("Please select an area code.");
							}
						}else {
							errorContactLast.setVisible(true);
							errorContactLast.setText("Last is invalid.");
						}
					}else {
						errorContactFirst.setVisible(true);
						errorContactFirst.setText("First is invalid.");
					}
				}
				else {

					LoginController.curretMiner.setMinerName(nameText.getText());
					LoginController.curretMiner.setEmail(emailText.getText());

					control.MinerLogic.getInstance().updateMiner(LoginController.curretMiner);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Congrats!");
					alert.setContentText("Details Updated Successfully.");
					alert.initModality(Modality.APPLICATION_MODAL);
					alert.showAndWait();

				}
			}else {
				errorMinerEmail.setVisible(true);
				errorMinerEmail.setText("Email is invalid.");
			}
		}else {
			errorMinerName.setVisible(true);
			errorMinerName.setText(("Miner name is invalid."));
		}
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}

}
