package boundary;

import control.Communication;
import entity.Consts;
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
    private ImageView mailsAdmin;
    
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

    public void initialize() {
    networkStatus.setText(LoginController.netMode.toString());
    }
    
    @FXML
    void allDetails(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newDetailsWindow();
    }

    @FXML
    void exportJson(MouseEvent event) {
		if (Communication.exportTransactionsToJSON()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Transactions Exported Successfully");
			alert.setContentText("Transactions exported successfully to\n"
					+ Consts.JSON_EXPORT_FILE_PATH);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Exporting Transactions");
			alert.setContentText("Error Exporting Transactions to JSON");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
    }

    @FXML
    void importXML(MouseEvent event) {
		if (Communication.importTransactionsFromXML()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Transactions Imported Successfully");
			alert.setContentText("Transactions Imported successfully from\n"
					+ Consts.XML_IMPORT_FILE_PATH);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Importing Transactions");
			alert.setContentText("Error Importing Transactions to JSON");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
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
    	ViewLogic.newAdminParametersWindow();
    }

    @FXML
    void mailsAdmin(MouseEvent event) {
    	ViewLogic.newApproveRecWindow();
    }
    
	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
