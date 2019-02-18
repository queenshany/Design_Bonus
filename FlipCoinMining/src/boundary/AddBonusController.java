package boundary;

import entity.Bonus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBonusController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label title;

    @FXML
    private Button saveButton;

    @FXML
    private TextArea desc;

    @FXML
    private Label errorLable;

    @FXML
    void resetLable(KeyEvent event) {
    	errorLable.setVisible(false);
    }

    @FXML
    void updateBonus(ActionEvent event) {
    	if (desc.getText().isEmpty()) {
    		errorLable.setVisible(true);
    	}
    	else {
    	int id = control.LotteryLogic.getInstance().getBonusID();
    	Bonus b = new Bonus(id, desc.getText());
    	control.LotteryLogic.getInstance().insertBonus(b);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Bonus Added Successfully!");
		alert.setContentText(b + " was added successfully!");
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();

		((Stage) ManagementController.bp.getScene().getWindow()).close();
		ViewLogic.newManagementWindow();
		closeWindow();
    	}
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
