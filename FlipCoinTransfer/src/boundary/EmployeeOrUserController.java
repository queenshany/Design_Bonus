package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeOrUserController {

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Button userButton;

    @FXML
    private Button employeeButton;

    @FXML
    private ImageView line;

    @FXML
    private AnchorPane pane;
    
    @FXML
    void logasEmployee(ActionEvent event) {
    	closeWindow();
    	ViewLogic.newEmployeeWindow();
    }

    @FXML
    void logasUser(ActionEvent event) {
    	closeWindow();
    	ViewLogic.newUserWindow();
    }
    
	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
