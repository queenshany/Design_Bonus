package boundary;

import java.util.ArrayList;

import javax.swing.JFrame;

import control.MinerLogic;
import entity.Lottery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LotteriesScreenController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox menu;

	@FXML
	private ImageView lotteries;

	@FXML
	private ImageView riddles;

	@FXML
	private ImageView blocks;

	@FXML
	private ImageView miners;

	@FXML
	private ImageView report;

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
	private ComboBox<Lottery> lorretycombo;

	@FXML
	private ImageView enterButton;

	@FXML
	private Label lable;

	@FXML
	private Label errorMassage;


	public void initialize() {

		ArrayList<Lottery> l = new ArrayList<Lottery>();
		l = control.LotteryLogic.getInstance().getLotteries();

		lorretycombo.getItems().addAll(l);

		ObservableList<Lottery> lot= FXCollections.observableArrayList(l);
		lorretycombo.setItems(lot);	

	}

	@FXML
	void addUserToLottery(MouseEvent event) {
		if (lorretycombo.getValue () !=null) {
			if (!(control.LotteryLogic.getInstance().joinLottery(LoginController.curretMiner, lorretycombo.getValue()))){
				errorMassage.setVisible(true);
				errorMassage.setText("You can't sign to this lottery");
			}
			else {
				errorMassage.setVisible(true);
				errorMassage.setText("You have successfully joined");
			}
		}
		else { 
			errorMassage.setVisible(true);
			errorMassage.setText("Please choose a lottery first");
		}
	}

	@FXML
	void clean(ActionEvent event) {
		errorMassage.setVisible(false);
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
	void lotteriesScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newLotteriesWindow();
	}

	@FXML
	void mailsScreen(MouseEvent event) {
		//TODO
	}

	@FXML
	void manageBlocks(MouseEvent event) {
		closeWindow();
		ViewLogic.newBlocksWindow();
	}

	@FXML
	void minersScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newAllMinersWindow();
	}

	@FXML
	void riddlesScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newRiddlesWindow();
	}

	@FXML
	void watchReport(MouseEvent event) {
		if (LoginController.curretMiner == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Miner is Null");
			alert.setContentText("Miner is Null");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}else {
			JFrame reportFrame = MinerLogic.getInstance().produceMarketPredictionReport();
			reportFrame.setVisible(true);
		}

	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}

