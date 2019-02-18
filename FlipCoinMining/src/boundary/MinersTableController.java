package boundary;

import java.util.ArrayList;

import javax.swing.JFrame;

import control.MinerLogic;
import entity.Miner;
import entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MinersTableController {

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
	private TableView<Miner> minersTable;

	@FXML
	private TableColumn<Miner, String> Uniqe;

	@FXML
	private TableColumn<Miner, String> name;

	@FXML
	private TableColumn<Miner, String> mail;

	@FXML
	private TableColumn<Miner, Double> digprof;


	public void initialize() {

		Uniqe.setCellValueFactory(new PropertyValueFactory<>("uniqueAddress"));
		name.setCellValueFactory(new PropertyValueFactory<>("minerName"));
		mail.setCellValueFactory(new PropertyValueFactory<>("email"));
		digprof.setCellValueFactory(new PropertyValueFactory<>("digitalProfit"));

		ArrayList<Miner> m = control.MinerLogic.getInstance().viewOtherMiners(LoginController.curretMiner);
		ObservableList<Miner> miners= FXCollections.observableArrayList(m);
		minersTable.setItems(miners);
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	@FXML
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newUserWindow();
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
