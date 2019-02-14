package boundary;

import javax.swing.JFrame;

import control.RecLogic;
import control.TransLogic;
import control.UserLogic;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainEmployeeScreenController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

    @FXML
    private Label networkStatus;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private VBox bottom;

    @FXML
    private ImageView line;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView homeIcon;

    @FXML
    private ImageView createRec;

    @FXML
    private ImageView viewRec;

    @FXML
    private ImageView transRpt;

    @FXML
    private ImageView usersRpt;

    @FXML
    private ImageView categories;

    @FXML
    private ImageView parameters;

    @FXML
    void allRecommendations(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newViewRecommendationWindow();
    }

    @FXML
    void generateTransReport(MouseEvent event) {
		//ViewLogic.newViewRecommendationWindow();
//		if (LoginController.curretUser == null) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("User is null");
//			alert.setContentText("Please select user");
//			alert.initModality(Modality.APPLICATION_MODAL);
//			alert.showAndWait();
//		}else {
			JFrame reportFrame = TransLogic.getInstance().produceTransStatusReport();
			reportFrame.setVisible(true);
//		}
    }

    @FXML
    void generateUsersReport(MouseEvent event) {
		//ViewLogic.newViewRecommendationWindow();
//		if (LoginController.curretUser == null) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("User is null");
//			alert.setContentText("Please select user");
//			alert.initModality(Modality.APPLICATION_MODAL);
//			alert.showAndWait();
//		}else {
			JFrame reportFrame = UserLogic.getInstance().produceUsersReport();
			reportFrame.setVisible(true);
//		}
    }

    @FXML
    void logOut(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newLoginWindow();
    }

    @FXML
    void manageCategories(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newCategoriesWindow();
    }

    @FXML
    void manageParameters(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newParametersWindow();
 
    }

    @FXML
    void newRecommendation(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newCreateRecommendationWindow();
    }

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}