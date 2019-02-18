package boundary;

import java.sql.Date;
import java.util.ArrayList;

import control.Communication;
import entity.Bonus;
import entity.Consts;
import entity.Lottery;
import entity.Miner;
import entity.RiddleLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.E_Level;

public class ManagementController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private HBox topBorder;

	@FXML
	private ImageView logo;

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
	private TabPane tabPane;

	@FXML
	private Tab riddles;

	@FXML
	private AnchorPane p1;

	@FXML
	private TableView<?> t1;

	@FXML
	private Button addR;

	@FXML
	private Button editR;

	@FXML
	private Tab lotteries;

	@FXML
	private AnchorPane p2;

	@FXML
	private TableView<Lottery> lotteriesTable;

	@FXML
	private TableColumn<Lottery, Integer> lotteryNum;

	@FXML
	private TableColumn<Lottery, Date> lotteryDate;

	@FXML
	private TableColumn<Lottery, Integer> maxParticipants;

	@FXML
	private TableColumn<Lottery, Integer> numOfWinners;

	@FXML
	private TableColumn<Lottery, Integer> numOfBonuses;

	@FXML
	private Button addL;

	@FXML
	private Tab bonuses;

	@FXML
	private AnchorPane p3;

	@FXML
	private TableView<Bonus> bonusesTable;

	@FXML
	private TableColumn<Bonus, Integer> bonusNum;

	@FXML
	private TableColumn<Bonus, String> description;

	@FXML
	private Button addB;

	@FXML
	private Button editB;

	@FXML
	private Tab levels;

	@FXML
	private AnchorPane p31;

	@FXML
	private TableView<RiddleLevel> levelsTable;

	@FXML
	private TableColumn<RiddleLevel, Integer> levelCode;

	@FXML
	private TableColumn<RiddleLevel, E_Level> levelName;

	@FXML
	private TableColumn<RiddleLevel, Integer> difficultyLevel;

	@FXML
	private TableColumn<RiddleLevel, Integer> blockSize;

	@FXML
	private Button addB1;

	@FXML
	private Button editB1;

	@FXML
	private TableView<Miner> minersTable;

	@FXML
	private AnchorPane p32;

	@FXML
	private ScrollPane scrollMiners;

	@FXML
	private TableColumn<Miner, String> uniqueAddress;

	@FXML
	private TableColumn<Miner, String> MinerName;

	@FXML
	private TableColumn<Miner, String> Email;

	@FXML
	private TableColumn<Miner, Double> DigitalProfit;

	private static boolean isImported = true;

	public void initialize() {
		if(!isImported)
			addR.setDisable(true);

		uniqueAddress.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		MinerName.setCellValueFactory(new PropertyValueFactory<>("minerName"));
		Email.setCellValueFactory(new PropertyValueFactory<>("email"));
		DigitalProfit.setCellValueFactory(new PropertyValueFactory<>("digitalProfit"));

		ArrayList<Miner> m = control.MinerLogic.getInstance().viewOtherMiners(LoginController.curretMiner);
		ObservableList<Miner> miners= FXCollections.observableArrayList(m);
		minersTable.setItems(miners);

	}

	@FXML
	void addBonus(ActionEvent event) {
		//TODO
	}

	@FXML
	void addLotteries(ActionEvent event) {
		//TODO
	}
	@FXML
	void addRiddle(ActionEvent event) {
		if (Communication.importRiddlesFromXML()) {
			addR.setDisable(true);
			isImported = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Riddles Imported Successfully");
			alert.setContentText("Riddles imported successfully to\n"
					+ Consts.XML_RIDDLES_FILE_PATH);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Importing Riddles");
			alert.setContentText("Error Importing Riddles from XML");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
	}


	@FXML
	void chosenBonus(MouseEvent event) {
		//TODO
	}

	@FXML
	void chosenLevel(MouseEvent event) {
		//TODO
	}

	@FXML
	void chosenLottery(MouseEvent event) {
		//TODO
	}

	@FXML
	void chosenMiner(MouseEvent event) {
		//TODO
	}

	@FXML
	void editBonus(ActionEvent event) {
		//TODO
	}

	@FXML
	void editLotteries(ActionEvent event) {
		//TODO
	}

	@FXML
	void editRiddle(ActionEvent event) {
		//TODO
	}

	@FXML
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newAdminWindow();
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}

