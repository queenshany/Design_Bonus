package boundary;

import java.sql.Date;
import java.time.LocalDate;

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

public class AddLotteryController {

	@FXML
	private AnchorPane pane;

	@FXML
	private Label title;

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

	@FXML
	private Label dateerror;

	public void initialize() {

		datePicker.setEditable(false);
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
			if (max <= 0) {
				maxlable.setText("invalid input");
				maxlable.setVisible(true);
			}
			else {
				try{
					maxlable.setVisible(false);
					int win = Integer.parseInt(winnersText.getText());
					if (win <= 0) {
						winlable.setText("invalid input");
						winlable.setVisible(true);
					}
					else {
						try {
							winlable.setVisible(false);
							int bon = Integer.parseInt(bonusesText.getText());
							if (bon <= 0) {
								bonlable.setText("invalid input");
								bonlable.setVisible(true);
							}
							else {
								bonlable.setVisible(false);
								if (datePicker.getValue()==null) {
									dateerror.setVisible(true);
								}
								else {
									dateerror.setVisible(false);
									int id = control.LotteryLogic.getInstance().getLotteryID();
									Lottery lot = new Lottery(id,
											Date.valueOf(datePicker.getValue()),
											max,
											win,
											bon);

									control.LotteryLogic.getInstance().insertLottery(lot);

									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setTitle("Item Added Successfully!");
									alert.setContentText(lot + " was added successfully!");
									alert.initModality(Modality.APPLICATION_MODAL);
									alert.showAndWait();

									((Stage) ManagementController.bp.getScene().getWindow()).close();
									ViewLogic.newManagementWindow();
									closeWindow();
								}
							}
							}catch(NumberFormatException e) {
								bonlable.setText("Invalid Value");
								bonlable.setVisible(true);
							}
						}
					}catch( NumberFormatException e) {
						winlable.setText("Invalid Value");
						winlable.setVisible(true);
					}
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
