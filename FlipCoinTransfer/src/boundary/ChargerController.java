package boundary;

import control.WalletLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField theAmount;

    @FXML
    private Button chargeButton;

    @FXML
    void charge(ActionEvent event) {
    	if (theAmount.getText()!=null && UserWalletController.currentWallet !=null) {
    	double amount = Double.parseDouble(theAmount.getText());
    	control.WalletLogic.getInstance().loadMoney(UserWalletController.currentWallet, amount);
    	control.WalletLogic.getInstance().calcAmount(UserWalletController.currentWallet);
    	control.WalletLogic.getInstance().calcPendingAmount(UserWalletController.currentWallet);
    	closeWindow();
    	}
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}