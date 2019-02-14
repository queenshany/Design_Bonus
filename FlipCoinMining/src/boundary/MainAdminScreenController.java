package boundary;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainAdminScreenController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox menu;

    @FXML
    private ImageView importJ;

    @FXML
    private ImageView exportE;

    @FXML
    private ImageView management;

    @FXML
    private ImageView report;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView mailIcon;

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
    void exportXML(MouseEvent event) {

    }

    @FXML
    void generateReport(MouseEvent event) {

    }
   

    @FXML
    void importJSON(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newLoginWindow();
    }

    @FXML
    void mailsScreen(MouseEvent event) {

    }

    @FXML
    void manageScreen(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newManagementWindow();
    }


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}

