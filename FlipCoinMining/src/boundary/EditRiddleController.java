package boundary;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void updateRiddle(ActionEvent event) {

    }

}
