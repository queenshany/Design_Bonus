package boundary;

import com.jfoenix.controls.JFXTimePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddRiddlesController {

    @FXML
    private Label description;

    @FXML
    private TextField riddleText;

    @FXML
    private Label sDate;

    @FXML
    private Label sTime;

    @FXML
    private Label rLevel;

    @FXML
    private Label sokutions;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<?> levelsCombo;

    @FXML
    private ListView<?> solutionsList;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    private Button saveB;

    @FXML
    private Button nextB;

    @FXML
    void nextRiddle(ActionEvent event) {
    	//TODO
    }

    @FXML
    void saveRiddle(ActionEvent event) {
    	//TODO
    }

}
