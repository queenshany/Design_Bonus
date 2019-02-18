package boundary;

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

public class EditBonusController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label bonusNumber;

    @FXML
    private Button saveButton;

    @FXML
    private Label maxlable;

    @FXML
    private Label winlable;

    @FXML
    private Label bonlable;

    @FXML
    private TextArea desc;

    @FXML
    private Label errorLable;

    public void initialize() {
    	bonusNumber.setText("Bonus Number " + ManagementController.chosenBonus.getBonusNum());
    	desc.setText(ManagementController.chosenBonus.getDescription());
    }
    
    @FXML
    void resetLable(KeyEvent event) {
    	errorLable.setVisible(false);
    }

    @FXML
    void updateBonus(ActionEvent event) {
    	if (!desc.getText().isEmpty()) {
    		ManagementController.chosenBonus.setDescription(desc.getText());
    		control.LotteryLogic.getInstance().updateBonus(ManagementController.chosenBonus);
    		
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Bonus Edited Successfully!");
			alert.setContentText("The bonus was updated successfully!");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
			
    		((Stage) ManagementController.bp.getScene().getWindow()).close();
	    	ViewLogic.newManagementWindow();
	    	closeWindow();
    	}
    	else {
    		errorLable.setText("Please fill the field");
    		errorLable.setVisible(true);
    	}
    }
    
	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
