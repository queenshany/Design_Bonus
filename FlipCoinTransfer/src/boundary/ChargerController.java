package boundary;

import java.io.IOException;

import control.WalletLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChargerController {

	@FXML
	private AnchorPane pane;

	@FXML
	private ImageView i1;

	@FXML
	private ImageView i3;

	@FXML
	private ImageView i2;

	@FXML
	private ImageView i4;

	@FXML
	private ImageView i5;

	@FXML
	private ImageView i6;

	@FXML
	private ImageView logo;

	@FXML
	private Label l1;

	@FXML
	private Label l2;

	@FXML
	private Label alertLabel;

	@FXML
	private TextField theAmount;

	@FXML
	private Button chargeButton;

	@FXML
	void charge(ActionEvent event) throws IOException {
		double amount = 0.0;

		if (theAmount.getText() != null) {
			if (UserWalletController.currentWallet != null) {
				try {
					amount = Double.parseDouble(theAmount.getText());

					if (amount <= 0) {
						alertLabel.setText("Amount must be positive");
					}
					else {
						control.WalletLogic.getInstance().loadMoney(UserWalletController.currentWallet, amount);
						//refresh the table
						((Stage) UserWalletController.bp.getScene().getWindow()).close();
						ViewLogic.newWalletsWindow();
						closeWindow();
					}
				}catch (NumberFormatException e) {
					alertLabel.setText("Please enter a number");
				}
			}else {
				alertLabel.setText("Please enter a number");
			}
		}else {
			alertLabel.setText("A wallet wasn't selected...");
		}
	}

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}