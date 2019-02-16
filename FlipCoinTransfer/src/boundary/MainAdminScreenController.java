package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private ImageView importXML;

    @FXML
    private ImageView expJson;

    @FXML
    private ImageView viewDetails;

    @FXML
    private ImageView employeesManag;

    @FXML
    private ImageView categories;

    @FXML
    private ImageView parameters;

    @FXML
    void allDetails(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newDetailsWindow();
    }

    @FXML
    void exportJson(MouseEvent event) {

    }

    @FXML
    void importXML(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newLoginWindow();
    }

    @FXML
    void manageCategories(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newAdminCategoriesWindow();
    	}

    @FXML
    void manageEmployees(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newManageEmployeesWindow();
    }

    @FXML
    void manageParameters(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newParametersWindow();
    }

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
