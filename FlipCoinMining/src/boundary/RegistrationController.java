package boundary;

import entity.Consts;
import entity.Miner;
import entity.MinerCompany;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
	private ComboBox<?> combo;

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

	 public void initialize() {

	 }
	 
	protected static int flag = 0;

	@FXML
	void newAccount(MouseEvent event) {
			if (!passwordText.getText().equals(verifyText.getText())) {
				passwordLable.setText("Please try again");
				passwordLable.setVisible(true);
			}
			else {
			Miner miner = control.MinerLogic.getInstance().getMiners().get(0);
			miner.setMinerName(usernameText.getText());
			miner.setDigitalProfit(0);
			miner.setEmail(emailText.getText());
			miner.setPassword(passwordText.getText());
			
			String uniqueAddress;
			do {
				uniqueAddress = control.SysData.getInstance().generateRandomStrings(Consts.MINER_ADDRESS_LENGTH);
			}
			while (control.MinerLogic.getInstance().getMiners().contains(new Miner(uniqueAddress)));
			
			miner.setUniqueAddress(uniqueAddress);
			
			control.MinerLogic.getInstance().insertMiner(miner);
			
			if (flag==1) {
				MinerCompany comp = control.MinerLogic.getInstance().getCompanies().get(0);
				comp.setMinerName(usernameText.getText());
				comp.setDigitalProfit(0);
				comp.setEmail(emailText.getText());
				comp.setPassword(passwordText.getText());
				
//				String ua;
//				do {
//					ua = control.SysData.getInstance().generateRandomStrings(Consts.MINER_ADDRESS_LENGTH);
//				}
//				while (control.MinerLogic.getInstance().getMiners().contains(new Miner(ua)));
				
				comp.setUniqueAddress(miner.getUniqueAddress());
				
				comp.setContactEmail(emailText.getText());
				comp.setContactFirstName(usernameText1.getText());
				comp.setContactLastName(usernameText11.getText());
				comp.setContactPhone(phoneText.getText());
				
				control.MinerLogic.getInstance().insertMinerCompany(comp);
				closeWindow();
				ViewLogic.newLoginWindow();
				}

			closeWindow();
			ViewLogic.newLoginWindow();
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
