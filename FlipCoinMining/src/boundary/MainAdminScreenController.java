package boundary;

import control.Communication;
import entity.Consts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
		if (Communication.exportToXML()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Transactions Exported Successfully");
			alert.setContentText("Transactions exported successfully to\n"
					+ Consts.XML_EXPORT_FILE_PATH);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Exporting Transactions");
			alert.setContentText("Error Exporting Transactions to XML");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
	}

	@FXML
	void generateReport(MouseEvent event) {
		closeWindow();
		ViewLogic.newDominantUserWindow();
	}


	@FXML
	void importJSON(MouseEvent event) {
		if (Communication.importFromJSON()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Transactions Imported Successfully");
			alert.setContentText("Transactions imported successfully to\n"
					+ Consts.JSON_IMPORT_FILE_PATH);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Importing Transactions");
			alert.setContentText("Error Importing Transactions from JSON");
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
	void manageScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newManagementWindow();
	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}

