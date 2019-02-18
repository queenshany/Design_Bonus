package boundary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditRecController {

	@FXML
	private AnchorPane pane;

	@FXML
	private Label l1;

	@FXML
	private Label l11;

	@FXML
	private Label l12;

	@FXML
	private Label l13;

	@FXML
	private Label title;

	@FXML
	private TextField recNumText;

	@FXML
	private TextField dateText;

	@FXML
	private TextField probText;

	@FXML
	private TextField feeText;

	@FXML
	private Button saveButton;

	@FXML
	private Label alertLabel;

	public void initialize() {
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		if (RecommendationsController.currentRec != null) {
			recNumText.setText(String.valueOf(RecommendationsController.currentRec.getRecNum()));
			dateText.setText(df.format(RecommendationsController.currentRec.getCreationDate()));
			probText.setText(String.valueOf(RecommendationsController.currentRec.getProbability()));
			feeText.setText(String.valueOf(RecommendationsController.currentRec.getRecommendedFee()));
		}
	}


	@FXML
	void saveRec(ActionEvent event) {
		double f = 0.0;
		try {
			f = Double.parseDouble(feeText.getText());
			if ( f <= 0) {
				alertLabel.setText("Fee must be a positive number.");
			}
			else {
				RecommendationsController.currentRec.setRecommendedFee(f);
				control.RecLogic.getInstance().updateRecommendation(RecommendationsController.currentRec);
				((Stage) RecommendationsController.bp.getScene().getWindow()).close();
				ViewLogic.newViewRecommendationWindow();
				closeWindow();
			}
		}catch (NumberFormatException e) {
			alertLabel.setText("Fee must be a number.");
		}

	}

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}