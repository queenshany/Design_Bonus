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
    private Button removeButton;
    
    public void initialize() {
    	String pattern = "MM/dd/yyyy HH:mm:ss";
    	DateFormat df = new SimpleDateFormat(pattern);
    	recNumText.setText(String.valueOf(RecommendationsController.currentRec.getRecNum()));
    	dateText.setText(df.format(RecommendationsController.currentRec.getCreationDate()));
    	probText.setText(String.valueOf(RecommendationsController.currentRec.getProbability()));
    	feeText.setText(String.valueOf(RecommendationsController.currentRec.getRecommendedFee()));
    }
    

    @FXML
    void removeRec(ActionEvent event) {
    	control.RecLogic.getInstance().deleteRecommendation(RecommendationsController.currentRec);
    }

    @FXML
    void saveRec(ActionEvent event) {
    	//If I set the values - it is not enough?
    	
//    	RecommendationsController.currentRec.setProbability(probText);
//    	control.RecLogic.getInstance().updateRecommendation(rec);
    }

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}