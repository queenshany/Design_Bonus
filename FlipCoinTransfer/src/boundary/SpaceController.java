package boundary;

import entity.Item;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;
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
		int temp = control.SysData.getInstance().getLastVersionParams().getTransMinSize();
		ObservableList<Integer> ints= FXCollections.observableArrayList();

		while (temp <= control.SysData.getInstance().getLastVersionParams().getTransMaxSize()) {
			ints.add(temp);
			temp = temp + control.SysData.getInstance().getLastVersionParams().getTransSizeForExpansion();
		}

		//Fill the combobox
		//		   ObservableList<Integer> ints= FXCollections.observableArrayList();
		//		   ints.add(5);
		//		   ints.add(10);
		//		   ints.add(15);
		//		   ints.add(20);
		//		   ints.add(25);
		//		   ints.add(30);
		//		   ints.add(35);
		//		   ints.add(40);
		comboBox.setItems(ints);
	}

	@FXML
	void addNewWallet(ActionEvent event) {

		String uniqueAddress = control.SysData.getInstance().generateRandomStrings(4);
		boolean isOnPC = check2.isSelected();
		boolean isOnPhone = check3.isSelected();
		boolean isOnTablet = check1.isSelected();
		double amount = 0;
		double pendingAmount = 0;
		String userAddress = LoginController.curretUser.getPublicAddress();
		String userSignature = LoginController.curretUser.getSignature();
		double price = Double.parseDouble(theAmount.getText());
		int transSize = comboBox.getValue();

		WalletBitcoinSpace space = new WalletBitcoinSpace(uniqueAddress, price, isOnPC, isOnPhone, isOnTablet, amount, pendingAmount, userAddress, userSignature, transSize);
		control.WalletLogic.getInstance().insertWallet(space);
		control.WalletLogic.getInstance().insertWalletBitcoinSpace(space);

		((Stage) UserWalletController.bp.getScene().getWindow()).close();
		ViewLogic.newWalletsWindow();
		closeWindow();
	}

	@FXML
	void calcBTC(ActionEvent event) {
		if (comboBox.getValue()==null || comboBox.getSelectionModel().getSelectedItem()==null) {
			youHaveToPay.setText("Please enter number");
			youHaveToPay.setVisible(true);
		}
		if (!(check1.isSelected()) && !(check2.isSelected()) && !(check3.isSelected())) {
			youHaveToPay.setText("Please choose platforms");
			youHaveToPay.setVisible(true);
		}
		else {
			if (comboBox.getValue()!=null) {
				double a = comboBox.getSelectionModel().getSelectedItem();
				a = a*control.SysData.getInstance().getLastVersionParams().getPriceForExpansion();
				String text = String.valueOf(a);
				theAmount.setText(text);
				theAmount.setVisible(true);
				BTC.setVisible(true);
				youHaveToPay.setText("You have to pay");
				youHaveToPay.setVisible(true);
				buyButton.setDisable(false);
			}
		}
	}

	protected void closeWindow() {
		((Stage) Vbox.getScene().getWindow()).close();
	}
}
