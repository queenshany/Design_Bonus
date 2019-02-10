package boundary;

import entity.Wallet;
import entity.WalletBitcoinKnots;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KnotsController {

    @FXML
    private VBox Vbox;

    @FXML
    private Label Title;

    @FXML
    private HBox Hbox1;

    @FXML
    private TextField textField;

    @FXML
    private Label precent;

    @FXML
    private Button calculate;

    @FXML
    private HBox Hbox2;

    @FXML
    private Label lablePlatforms;

    @FXML
    private HBox Hbox3;

    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private CheckBox check3;

    @FXML
    private HBox Hbox4;

    @FXML
    private ImageView line;

    @FXML
    private HBox Hbox5;

    @FXML
    private Label youHaveToPay;

    @FXML
    private Label theAmount;

    @FXML
    private Label BTC;

    @FXML
    private Button buyButton;

    @SuppressWarnings("null")
	@FXML
    void addNewWallet(ActionEvent event) {
    	WalletBitcoinKnots wallet = null;
    	wallet.setUniqueAddress(control.SysData.getInstance().generateRandomStrings(4));
//    	wallet.setPendingAmount(textField.getText());
    	control.WalletLogic.getInstance().insertWalletBitcoinKnots(wallet);
    }

    @FXML
    void calcBTC(ActionEvent event) {

    }

}
