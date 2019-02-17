package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExpandSpaceController {

    @FXML
    private VBox Vbox;

    @FXML
    private Label Title;

    @FXML
    private HBox Hbox1;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private Label bytes;

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

    @FXML
    private Button charge;

    @FXML
    void addNewWallet(ActionEvent event) {

    }

    @FXML
    void calcBTC(ActionEvent event) {

    }

    @FXML
    void chargeMoney(ActionEvent event) {
    	closeWindow();
    	ViewLogic.newChargerWindow();

    }

	protected void closeWindow() {
		((Stage) Vbox.getScene().getWindow()).close();
	}
}