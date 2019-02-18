package boundary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import control.MinerLogic;
import entity.Miner;
import entity.Riddle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.E_Status;
import utils.E_Type;

public class RiddlesScreenController {

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
	private TableView<Riddle> table;

	@FXML
	private TableColumn<Riddle, Integer> id;

	@FXML
	private TableColumn<Riddle, Integer> level;

	@FXML
	private Label untile;

	@FXML
	private TextField untilText;

	@FXML
	private Label at;

	@FXML
	private TextField atText;

	@FXML
	private TextArea textField;

	@FXML
	private Label enterLable;

	@FXML
	private TextField solutionText;

	@FXML
	private Button sendButton;

	@FXML
	private Label errorMassage;

	@FXML
	private JFXDatePicker dateP;

	@FXML
	private JFXTimePicker timeP;

	protected static Riddle currentRiddle;

	public void initialize() {

		id.setCellValueFactory(new PropertyValueFactory<>("riddleNum"));
		level.setCellValueFactory(new PropertyValueFactory<>("riddleLevel"));

		getUnsolvedRiddles();

	} 

	public void getUnsolvedRiddles(){
		ObservableList<Riddle> r= FXCollections.observableArrayList();
		ArrayList<Riddle> rid = control.RiddleLogic.getInstance().getRiddles();
		for(Riddle rr : rid)
		{
			if(rr.getStatus().equals(E_Status.Unsolved) && rr.getSolutionDate() != null && rr.getSolutionTime() != null)
				r.add(rr);
		}
		table.setItems(r);
		table.refresh();
	}

	@FXML
	void showRiddle(MouseEvent event) {
		if (table.getSelectionModel().getSelectedItem() != null) {
			Riddle rid = table.getSelectionModel().getSelectedItem();
			LocalDate ld = rid.getSolutionDate().toLocalDate();
			dateP.setValue(ld);
			LocalTime tm = rid.getSolutionTime().toLocalTime();
			timeP.setValue(tm);
			textField.setText(rid.getDescription());
			currentRiddle = rid;
		}
		else {
			errorMassage.setText("Please select a riddle");
			errorMassage.setVisible(true);
		}
	}

	@FXML
	void solutionRiddle(ActionEvent event) {
		double sol = 0.0;

		if (currentRiddle != null) {
			errorMassage.setVisible(false);
			if (!solutionText.getText().isEmpty()) {
				errorMassage.setVisible(false);
				try {
					sol = Double.parseDouble(solutionText.getText());

					if (control.RiddleLogic.getInstance().isSolvedCorrectly(sol, currentRiddle, LoginController.curretMiner)) {
						//sendButton.setDisable(true);
						getUnsolvedRiddles();
						dateP.setValue(null);
						timeP.setValue(null);
						textField.clear();
						solutionText.clear();
						if (control.RiddleLogic.getInstance().isFirstSolved(currentRiddle, LoginController.curretMiner)) {
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Congrats!");
							alert.setContentText("You have solved the riddle Correctly. \n"
									+ "You solved it first, and you received a new block! \n" 
									+ "You can view it under Block Management");
							alert.initModality(Modality.APPLICATION_MODAL);
							alert.showAndWait();
							currentRiddle = null;
						}
						else {
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Congrats!");
							alert.setContentText("You have solved the riddle Correctly. \n"
									+ "You didn't solve it first, but you were still right... :)");
							alert.initModality(Modality.APPLICATION_MODAL);
							alert.showAndWait();
							currentRiddle = null;
						}
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("You have not solved the riddle");
						alert.setContentText("You have not solved the riddle Correctly. \n"
								+ "But you can try again... :)");
						alert.initModality(Modality.APPLICATION_MODAL);
						alert.showAndWait();
					}
				}
				catch(NumberFormatException e) {
					errorMassage.setText("Solution must be a number");
					errorMassage.setVisible(true);
				}
			}else {
				errorMassage.setText("Please write a solution.");
				errorMassage.setVisible(true);
			}
		}else {
			errorMassage.setVisible(true);
			errorMassage.setText("Please choose a riddle to solve.");
		}
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
		closeWindow();
		ViewLogic.newEmailWindow();
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
