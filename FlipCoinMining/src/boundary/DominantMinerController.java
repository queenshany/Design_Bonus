package boundary;

import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JFrame;

import control.MinerLogic;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class DominantMinerController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox menu;

	@FXML
	private ImageView importJ;

	@FXML
	private ImageView exportE;

	@FXML
	private ImageView management;

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
	private AnchorPane anchorPane;

	@FXML
	private Label start;

	@FXML
	private DatePicker startDate;

	@FXML
	private Label end;

	@FXML
	private DatePicker endDate;

	@FXML
	private Label generateLable;

	@FXML
	private TableView<?> table;

	@FXML
	private ImageView V;

	@FXML
	void generateDominant(MouseEvent event) {
		LocalDate stDate = startDate.getValue();
		LocalDate edDate = endDate.getValue();
		if (stDate == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Select Start Date");
			alert.setContentText("Please select start date");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else if (edDate == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Select End Date");
			alert.setContentText("Please select end date");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Date dateStart = Date.valueOf(stDate);
			Date dateEnd = Date.valueOf(edDate);
			JFrame reportFrame = MinerLogic.getInstance().produceDominantMinerReport(dateStart, dateEnd);
			reportFrame.setVisible(true);
			//HIIIIIIIIIIIIII
		}
	}


	@FXML
	void exportXML(MouseEvent event) {

	}

	@FXML
	void generateReport(MouseEvent event) {

	}

	@FXML
	void importJSON(MouseEvent event) {

	}

	@FXML
	void logOut(MouseEvent event) {

	}

	@FXML
	void mailsScreen(MouseEvent event) {

	}

	@FXML
	void manageScreen(MouseEvent event) {

	}

}
