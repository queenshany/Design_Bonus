package boundary;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditLevelController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label levelNumber;

    @FXML
    private Button saveButton;

    @FXML
    private Label maxlable;

    @FXML
    private Label winlable;

    @FXML
    private Label bonlable;

    @FXML
    private Label errorLable;

    @FXML
    private Label lable1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private TextField levelName;

    @FXML
    private TextField diffText;

    @FXML
    private TextField blockSizeText;

    @FXML
    private Label errorM;

    public void initialize() {
    	levelNumber.setText("Level Number " + ManagementController.chosenLevel.getLevelCode());
    	levelName.setText(ManagementController.chosenLevel.getLevelName().toString());
    	diffText.setText(String.valueOf(ManagementController.chosenLevel.getDifficultyLevel()));
    	blockSizeText.setText(String.valueOf(ManagementController.chosenLevel.getBlockSize()));
    }
    
    @FXML
    void resetLable(ActionEvent event) {
    	errorM.setVisible(false);
    }

    @FXML
    void updateLevel(ActionEvent event) {
    	if (Integer.parseInt(diffText.getText()) <= 0 &&
    			Integer.parseInt(blockSizeText.getText()) <= 0) {
    		errorM.setText("Please enter positive values");
    		errorM.setVisible(true);
    	}
       	if (Integer.parseInt(diffText.getText()) >0 &&
    			Integer.parseInt(blockSizeText.getText()) > 0){
			try {
				int diff = Integer.parseInt(diffText.getText());
				try{
					int block = Integer.parseInt(blockSizeText.getText());

					ManagementController.chosenLevel.setBlockSize(block);
					ManagementController.chosenLevel.setDifficultyLevel(diff);

					control.RiddleLogic.getInstance().updateRiddleLevel(ManagementController.chosenLevel);

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Level Edited Successfully!");
					alert.setContentText("Riddle level was updated successfully!");
					alert.initModality(Modality.APPLICATION_MODAL);
					alert.showAndWait();

					((Stage) ManagementController.bp.getScene().getWindow()).close();
			    	ViewLogic.newManagementWindow();
			    	closeWindow();

				}catch(NumberFormatException e) {
					errorM.setVisible(true);
				}
			}catch( NumberFormatException e) {
				errorM.setVisible(true);
			}
    	}
    }
    
	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
