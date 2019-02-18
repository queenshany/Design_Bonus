package boundary;

import entity.Wallet;
import entity.WalletBitcoinKnots;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    public void initialize() {
    	String discount = String.valueOf(control.SysData.getInstance().getLastVersionParams().getMaxAllowableDiscount()*100);
    	theAmount.setText(discount);
    }
    
    @SuppressWarnings("null")
	@FXML
    void addNewWallet(ActionEvent event) {
//    	WalletBitcoinKnots wallet = null;
//    	String s = control.SysData.getInstance().generateRandomStrings(4);
//		System.out.println(s);    	
////    	wallet.setUniqueAddress(control.SysData.getInstance().generateRandomStrings(4));
////    	if(wallet.getUniqueAddress()==null || wallet.getUniqueAddress()=="")
//		if (textField.getText()!=null || !textField.getText().equals("")) {
//    	String myString = (textField.getText());
//    	try {
//    	wallet.setDiscountPercent(Integer.parseInt(myString));
//    	if (!(check1.isSelected()) &&!(check2.isSelected()) && !(check3.isSelected())) {
////    		Alert alert = new Alert(AlertType.ERROR);
////    		alert.setTitle("Error");
////    		alert.setHeaderText("");
////    		alert.setContentText("Please choose platforms");
////
////    		alert.showAndWait();  
//    		System.out.println("CHECKKKKKKKKK");
//    	}
//    	else {
//    	wallet.setOnPC(check2.isSelected());
//    	wallet.setOnTablet(check1.isSelected());
//    	wallet.setOnPhone(check3.isSelected());
//    	control.WalletLogic.getInstance().insertWallet(wallet);
//    	control.WalletLogic.getInstance().insertWalletBitcoinKnots(wallet);
//    	}
//		}
//		
//		 	catch (NumberFormatException e) {
//				theAmount.setText("Invalid Value");
//				theAmount.setVisible(true);
//    	}
//		}
    	
//    	((Stage) UserWalletController.bp.getScene().getWindow()).close();
//    	ViewLogic.newWalletsWindow();
//    	closeWindow();
    }

    @FXML
    void calcBTC(ActionEvent event) {
    	if (textField.getText().isEmpty() || textField.getText().equals("")) {
    		youHaveToPay.setText("Please enter number");
    		youHaveToPay.setVisible(true);
    	}
    	else {
    		try {
    	
    	String convert = (textField.getText());
    	double x = Double.parseDouble(convert)*control.SysData.getInstance().getLastVersionParams().getPriceForDiscount();
    	convert = String.valueOf(x);
    	theAmount.setText(convert);
    	youHaveToPay.setVisible(true);
    	theAmount.setVisible(true);
    	BTC.setVisible(true);
    	buyButton.setDisable(false);
    	}
    	catch (NumberFormatException e) {
		theAmount.setText("Invalid Value");
		theAmount.setVisible(true);
    	}
    	}
    }
    

    @FXML
    void clearAll(KeyEvent event) {
    	youHaveToPay.setVisible(false);
    	theAmount.setVisible(false);
    	BTC.setVisible(false);	
    	buyButton.setDisable(true);
    }

}
