package boundary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import entity.Miner;
import entity.Riddle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
			if(rr.getStatus().equals(E_Status.Unsolved))
				r.add(rr);
		}
		table.setItems(r);
		table.refresh();
	}

	@FXML
	void showRiddle(MouseEvent event) {
		Riddle rid = table.getSelectionModel().getSelectedItem();
		LocalDate ld = rid.getSolutionDate().toLocalDate();
		dateP.setValue(ld);
		LocalTime tm = rid.getSolutionTime().toLocalTime();
		timeP.setValue(tm);
		textField.setText(rid.getDescription());
		currentRiddle = rid;
	}

	@FXML
    void solutionRiddle(ActionEvent event) {
		double sol = Double.parseDouble(solutionText.getText());
		control.RiddleLogic.getInstance().getSolutions();
//		control.RiddleLogic.getInstance().insertSolvedRiddle(sr);
//		control.RiddleLogic.getInstance().isSolvedCorrectly(solutions, riddle, miner);
//		control.RiddleLogic.getInstance().isFirstSolved(riddle, miner);
//		control.BlockTransLogic.getInstance().generateBlockForMiner(miner, riddle);
		
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

	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
