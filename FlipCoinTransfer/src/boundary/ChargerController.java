import org.apache.velocity.runtime.directive.Parse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    	double amount = Double.parseDouble(theAmount.getText());
//    	control.WalletLogic.getInstance().loadMoney(wallet, amount);
    }

}
