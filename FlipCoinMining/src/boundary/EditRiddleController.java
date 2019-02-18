package boundary;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import entity.Riddle;
import entity.RiddleLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ComboBox<RiddleLevel> levelsCombo;

	@FXML
	private JFXDatePicker datePicker;

	@FXML
	private JFXTimePicker timePicker;

	@FXML
	private Button saveButton;
//
//	public void initialize() {
//
//		datePicker.setEditable(false);
//		timePicker.setEditable(false);
//
//		riddleNumber.setText("Riddle Number " + String.valueOf(ManagementController.chosenRiddle.getRiddleNum()));
//
//		if (ManagementController.chosenRiddle.getSolutionDate() != null) {
//			LocalDate ld = ManagementController.chosenRiddle.getSolutionDate().toLocalDate();
//			datePicker.setValue(ld);
//		}
//		if (ManagementController.chosenRiddle.getSolutionTime() != null) {
//			LocalTime tm = ManagementController.chosenRiddle.getSolutionTime().toLocalTime();
//			timePicker.setValue(tm);
//		}
//		//fill combobox
//		ArrayList<RiddleLevel> rd = new ArrayList<RiddleLevel>();
//		rd = control.RiddleLogic.getInstance().getRiddleLevels();
//
//		levelsCombo.getItems().addAll(rd);
//
//		ObservableList<RiddleLevel> levels= FXCollections.observableArrayList(rd);
//		levelsCombo.setItems(levels);
//
//		//set the value
//		levelsCombo.setValue(control.RiddleLogic.getInstance().getRiddleLevels().get(ManagementController.chosenRiddle.getRiddleLevel()-1)); 	    
//
//	}

//	@FXML
//	void updateRiddle(ActionEvent event) {
//		ManagementController.chosenRiddle.setSolutionDate(
//				Date.valueOf(datePicker.getValue()));
//		ManagementController.chosenRiddle.setSolutionTime(
//				Time.valueOf(timePicker.getValue()));
//		ManagementController.chosenRiddle.setRiddleLevel(levelsCombo.getValue().getLevelCode());
//		control.RiddleLogic.getInstance().updateRiddle(ManagementController.chosenRiddle);
//		((Stage) ManagementController.bp.getScene().getWindow()).close();
//		ViewLogic.newManagementWindow();
//		closeWindow();
//	}

    
    @FXML
    private Label errorLable;


	public void initialize() {
		
	datePicker.setEditable(false);
	timePicker.setEditable(false);
	
	riddleNumber.setText("Riddle Number " + String.valueOf(ManagementController.chosenRiddle.getRiddleNum()));
	if (ManagementController.chosenRiddle.getSolutionDate()!=null && 
			ManagementController.chosenRiddle.getSolutionTime()!=null) {
	LocalDate ld = ManagementController.chosenRiddle.getSolutionDate().toLocalDate();
	datePicker.setValue(ld);
	LocalTime tm = ManagementController.chosenRiddle.getSolutionTime().toLocalTime();
	timePicker.setValue(tm);
	}
	
	//fill combobox
	ArrayList<RiddleLevel> rd = new ArrayList<RiddleLevel>();
	rd = control.RiddleLogic.getInstance().getRiddleLevels();
	 
			 levelsCombo.getItems().addAll(rd);
		   
			ObservableList<RiddleLevel> levels= FXCollections.observableArrayList(rd);
	 	    levelsCombo.setItems(levels);
	 	    
	 	    if (ManagementController.chosenRiddle.getRiddleLevel() > 0)
	//set the value
	levelsCombo.setValue(control.RiddleLogic.getInstance().getRiddleLevels().get(ManagementController.chosenRiddle.getRiddleLevel()-1)); 	    
	 	    
	}
	
    @FXML
    void updateRiddle(ActionEvent event) {
    	if (datePicker.getValue() == null) {
    		errorLable.setText("Please select date");
    		errorLable.setVisible(true);
    	}
    	if (timePicker.getValue() == null) {
    		errorLable.setText("Please select time");
    		errorLable.setVisible(true);
    	}
    	if (levelsCombo.getValue() == null) {
    		errorLable.setText("Please select level");
    		errorLable.setVisible(true);
    	}
    	else {
    	ManagementController.chosenRiddle.setSolutionDate(
    			Date.valueOf(datePicker.getValue()));
    	ManagementController.chosenRiddle.setSolutionTime(
    			Time.valueOf(timePicker.getValue()));
    	ManagementController.chosenRiddle.setRiddleLevel(levelsCombo.getValue().getLevelCode());
    	control.RiddleLogic.getInstance().updateRiddle(ManagementController.chosenRiddle);
    	((Stage) ManagementController.bp.getScene().getWindow()).close();
    	ViewLogic.newManagementWindow();
    	closeWindow();
    	}
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
