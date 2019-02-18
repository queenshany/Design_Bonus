package boundary;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import entity.Riddle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditRiddleController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label riddleNumber;

    @FXML
    private Label time;

    @FXML
    private Label date;

    @FXML
    private Label level;

    @FXML
    private ComboBox<?> levelsCombo;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    private Button saveButton;

	public void initialize() {
		
	riddleNumber.setText("Riddle Number" + String.valueOf(ManagementController.chosenRiddle.getRiddleNum()));
	
	LocalDate ld = ManagementController.chosenRiddle.getSolutionDate().toLocalDate();
	datePicker.setValue(ld);
	LocalTime tm = ManagementController.chosenRiddle.getSolutionTime().toLocalTime();
	timePicker.setValue(tm);
	
	}
	
    @FXML
    void updateRiddle(ActionEvent event) {
    	ManagementController.chosenRiddle.setSolutionDate(
    			Date.valueOf(datePicker.getValue()));
    	ManagementController.chosenRiddle.setSolutionTime(
    			Time.valueOf(timePicker.getValue()));
    	control.RiddleLogic.getInstance().updateRiddle(ManagementController.chosenRiddle);
    	((Stage) ManagementController.bp.getScene().getWindow()).close();
    	ViewLogic.newManagementWindow();
    	closeWindow();
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
