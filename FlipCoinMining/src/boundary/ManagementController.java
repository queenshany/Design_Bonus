package boundary;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import control.Communication;
import entity.Bonus;
import entity.Consts;
import entity.Lottery;
import entity.Miner;
import entity.Riddle;
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
import utils.E_Status;

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
	private TableView<Riddle> riddleTable;

	@FXML
	private TableColumn<Riddle, Integer> riddleNum;

	@FXML
	private TableColumn<Riddle, Date> publishedDate;

	@FXML
	private TableColumn<Riddle, Time> publishedTime;

	@FXML
	private TableColumn<Riddle, String> descriptionRiddle;

	@FXML
	private TableColumn<Riddle, Date> solutionDate;

	@FXML
	private TableColumn<Riddle, Time> solutionTime;

	@FXML
	private TableColumn<Riddle, E_Status> statusRiddle;

	@FXML
	private TableColumn<Riddle, Integer> riddleLevel;

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

		//Miners Table
		uniqueAddress.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		MinerName.setCellValueFactory(new PropertyValueFactory<>("minerName"));
		Email.setCellValueFactory(new PropertyValueFactory<>("email"));
		DigitalProfit.setCellValueFactory(new PropertyValueFactory<>("digitalProfit"));

		ArrayList<Miner> m = control.MinerLogic.getInstance().getMiners();
		ObservableList<Miner> miners= FXCollections.observableArrayList(m);
		minersTable.setItems(miners);
		
		//Bonuses Table
		bonusNum.setCellValueFactory(new PropertyValueFactory<>("bonusNum"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		
		ArrayList<Bonus> b = control.LotteryLogic.getInstance().getBonuses();
		ObservableList<Bonus> bonus= FXCollections.observableArrayList(b);
		bonusesTable.setItems(bonus);
		
		//Riddles Table
		riddleNum.setCellValueFactory(new PropertyValueFactory<>("riddleNum"));
		publishedDate.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));
		publishedTime.setCellValueFactory(new PropertyValueFactory<>("publishedTime"));
		descriptionRiddle.setCellValueFactory(new PropertyValueFactory<>("description"));
		solutionDate.setCellValueFactory(new PropertyValueFactory<>("solutionDate"));
		solutionTime.setCellValueFactory(new PropertyValueFactory<>("solutionTime"));
		statusRiddle.setCellValueFactory(new PropertyValueFactory<>("status"));
		riddleLevel.setCellValueFactory(new PropertyValueFactory<>("riddleLevel"));
		
		ArrayList<Riddle> r = control.RiddleLogic.getInstance().getRiddles();
		ObservableList<Riddle> riddle= FXCollections.observableArrayList(r);
		riddleTable.setItems(riddle);
		
		
		//Levels Table
		levelCode.setCellValueFactory(new PropertyValueFactory<>("levelCode"));
		levelName.setCellValueFactory(new PropertyValueFactory<>("levelName"));
		difficultyLevel.setCellValueFactory(new PropertyValueFactory<>("difficultyLevel"));
		blockSize.setCellValueFactory(new PropertyValueFactory<>("blockSize"));
		
		ArrayList<RiddleLevel> rl = control.RiddleLogic.getInstance().getRiddleLevels();
		ObservableList<RiddleLevel> level = FXCollections.observableArrayList(rl);
		levelsTable.setItems(level);
		
		//Lotteries Table
		lotteryNum.setCellValueFactory(new PropertyValueFactory<>("lotteryNum"));
		lotteryDate.setCellValueFactory(new PropertyValueFactory<>("lotteryDate"));
		maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));
		numOfWinners.setCellValueFactory(new PropertyValueFactory<>("numOfWinners"));
		numOfBonuses.setCellValueFactory(new PropertyValueFactory<>("numOfBonuses"));

		ArrayList<Lottery> l = control.LotteryLogic.getInstance().getLotteries();
		ObservableList<Lottery> lott = FXCollections.observableArrayList(l);
		lotteriesTable.setItems(lott);
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
	void chosenRiddle(MouseEvent event) {
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

