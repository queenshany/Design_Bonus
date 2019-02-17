package boundary;

import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class SpaceController {

    @FXML
    private VBox Vbox;

    @FXML
    private Label Title;

    @FXML
    private HBox Hbox1;

    @FXML
    private ComboBox<Integer> comboBox;

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

	public void initialize() {
		
		//Fill the combobox
		   ObservableList<Integer> ints= FXCollections.observableArrayList();
		   ints.add(5);
		   ints.add(10);
		   ints.add(15);
		   ints.add(20);
		   ints.add(25);
		   ints.add(30);
		   ints.add(35);
		   ints.add(40);
		comboBox.setItems(ints);
	}
    
    @FXML
    void addNewWallet(ActionEvent event) {

//    	((Stage) UserWalletController.bp.getScene().getWindow()).close();
//    	ViewLogic.newWalletsWindow();
//    	closeWindow();
    }

    @FXML
    void calcBTC(ActionEvent event) {
   int a = comboBox.getSelectionModel().getSelectedItem();
//   a = (int) (a*control.SysData.getInstance().getLastVersionParams().getPriceForExpansion());
   a = a*10;
   String text = String.valueOf(a);
   theAmount.setText(text);
   theAmount.setVisible(true);
   BTC.setVisible(true);
   youHaveToPay.setVisible(true);
    }
}
