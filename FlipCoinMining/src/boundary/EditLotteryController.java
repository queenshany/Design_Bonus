package boundary;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import com.jfoenix.controls.JFXDatePicker;

import entity.Lottery;
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

public class EditLotteryController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label lotteryNumber;

    @FXML
    private Label maxPart;

    @FXML
    private Label date;

    @FXML
    private Label NumOfWin;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private Button saveButton;

    @FXML
    private Label NumOfBon;

    @FXML
    private TextField maxPasText;

    @FXML
    private TextField winnersText;

    @FXML
    private TextField bonusesText;

    @FXML
    private Label maxlable;

    @FXML
    private Label winlable;

    @FXML
    private Label bonlable;

    public void initialize() {
		
    	datePicker.setEditable(false);
    	
    	lotteryNumber.setText("Lottery Number " + String.valueOf(ManagementController.chosenLottery.getLotteryNum()));
    	
    	LocalDate ld = ManagementController.chosenLottery.getLotteryDate().toLocalDate();
    	datePicker.setValue(ld);
    	
    	bonusesText.setText(String.valueOf(ManagementController.chosenLottery.getNumOfBonuses()));
    	winnersText.setText(String.valueOf(ManagementController.chosenLottery.getNumOfWinners()));
    	maxPasText.setText(String.valueOf(ManagementController.chosenLottery.getMaxParticipants()));
    	
    }
    	
    
    @FXML
    void reset1(ActionEvent event) {
    	maxlable.setVisible(false);
    }

    @FXML
    void reset2(ActionEvent event) {
    	winlable.setVisible(false);
    }

    @FXML
    void reset3(ActionEvent event) {
    	bonlable.setVisible(false);
    }

    @FXML
    void updateLottery(ActionEvent event) {
    	
			try {
				int max = Integer.parseInt(maxPasText.getText());
				try{
					int win = Integer.parseInt(winnersText.getText());
					try {
						int bon = Integer.parseInt(bonusesText.getText());

					Lottery lot = new Lottery(ManagementController.chosenLottery.getLotteryNum(),
							Date.valueOf(datePicker.getValue()),
							max,
							win,
							bon);

					control.LotteryLogic.getInstance().updateLottery(lot);

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Item Edited Successfully!");
					alert.setContentText(lot + " was updated successfully!");
					alert.initModality(Modality.APPLICATION_MODAL);
					alert.showAndWait();

					((Stage) ManagementController.bp.getScene().getWindow()).close();
			    	ViewLogic.newManagementWindow();
			    	closeWindow();

				}catch(NumberFormatException e) {
					bonlable.setText("Invalid Value");
					bonlable.setVisible(true);
				}
			}catch( NumberFormatException e) {
				winlable.setText("Invalid Value");
				winlable.setVisible(true);
			}
			}catch( NumberFormatException e) {
				maxlable.setText("Invalid Value");
				maxlable.setVisible(true);
			}
       	
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
