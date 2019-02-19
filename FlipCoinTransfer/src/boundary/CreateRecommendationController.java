package boundary;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import control.TransLogic;
import control.UserLogic;
import entity.Recommendation;
import entity.RecommendedFor;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.management.ConnectorAddressLink;
import utils.E_Level;
import utils.E_NetMode;

public class CreateRecommendationController {

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
	private Label commisionLable;

	@FXML
	private Label probabilityLable;

	@FXML
	private TextField commision;

	@FXML
	private TextField probability;

	@FXML
	private Button newButton;

	@FXML
	private Button saveButton;

	@FXML
	private Label usernameLable;

	@FXML
	private Label levelOfCommitment;

	@FXML
	private ComboBox<User> usernameCombo;

	@FXML
	private ComboBox<E_Level> levelCombo;

	@FXML
	private Button sendButton;

	public void initialize() {

		ArrayList<User> NameUser = new ArrayList<User>();
		NameUser= control.UserLogic.getInstance().getUsers();

		usernameCombo.getItems().setAll(NameUser);

		ObservableList<User> us= FXCollections.observableArrayList(NameUser);
		usernameCombo.setItems(us);	

		levelCombo.getItems().setAll(E_Level.values());

		ObservableList<E_Level> lev= FXCollections.observableArrayList(E_Level.values());
		levelCombo.setItems(lev);	

		Date date= Date.valueOf(LocalDate.now());	 	    
		probability.setText(String.valueOf(control.RecLogic.getInstance().calcProbability(date)));


	}

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
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newUserWindow();
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

	@FXML
	void newMethod(ActionEvent event) {
		commision.setDisable(false);
		probability.setDisable(false);
		commision.setText("");
		newButton.setVisible(false);
		saveButton.setVisible(true);
		usernameCombo.setDisable(true);
		levelCombo.setDisable(true);
		Date date= Date.valueOf(LocalDate.now());	
		probability.setText(String.valueOf(control.RecLogic.getInstance().calcProbability(date)));
		sendButton.setDisable(true);
	}

	@FXML
	void saveMethod(ActionEvent event) {

		double com = 0.0;
		try{
			com = Double.parseDouble(commision.getText());
			if (com <= 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("Commission Fee must be a Positive number");
				alert.showAndWait(); 
			}
			else {
				usernameCombo.setDisable(false);
				levelCombo.setDisable(false);
				Recommendation rec = new Recommendation(control.RecLogic.getInstance().getRecID(), 
						Date.valueOf(LocalDate.now()),
						control.RecLogic.getInstance().calcProbability(Date.valueOf(LocalDate.now())),
						com, 
						control.SysData.getInstance().getMode().equals(E_NetMode.Normal) ? false : true);
				control.RecLogic.getInstance().insertRecommendation(rec);
				sendButton.setDisable(false);
				newButton.setVisible(true);
				newButton.setDisable(true);
				saveButton.setVisible(false);
				commision.setDisable(true);
				probability.setDisable(true);
			}
		}catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Commission Fee must be a number");
			alert.showAndWait(); 
		}

	}

	@FXML
	void sendMethod(ActionEvent event) {

		if (levelCombo.getValue() != null) {

			if (usernameCombo.getValue() != null) {

				RecommendedFor rf = new RecommendedFor(usernameCombo.getValue().getPublicAddress(),
						usernameCombo.getValue().getSignature(),
						control.RecLogic.getInstance().getRecommendations()
						.get(control.RecLogic.getInstance().getRecommendations().size()-1).getRecNum(),
						levelCombo.getValue());

				if (!control.RecLogic.getInstance().getRecommendationsFor().contains(rf)) {

					control.RecLogic.getInstance().insertRecommendedFor(rf);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Done");
					alert.setContentText("Recommendation sent to " + usernameCombo.getValue().getUsername());
					alert.showAndWait(); 
					UserLogic.getInstance().sendMessage("A New Recommendation is waiting for you!",
							"You can view the new recommendation in View Recommendations.",
							usernameCombo.getValue());
					newButton.setDisable(false);

				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("User already exists in this Recommendation");
					alert.showAndWait(); 
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("Please choose a user");
				alert.showAndWait(); 
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Please choose a level");
			alert.showAndWait(); 
		}


		if (commision.getText().isEmpty() || probability.getText().isEmpty() || !newButton.isVisible()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("You have to create a recommandation first");

			alert.showAndWait(); 
		}
	}
}
