package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstSolverController {

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView fireworks1;

    @FXML
    private ImageView fireworks2;

    @FXML
    private Label lable;

    @FXML
    private ImageView congPic;

    @FXML
    private Button checkOutButton;

    @FXML
    void OpenBlocksScreen(ActionEvent event) {
    	closeWindow();
		ViewLogic.newBlocksWindow();
    }
    
	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}
