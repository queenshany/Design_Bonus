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
    	 
 			 usernameCombo.getItems().addAll(NameUser);
 		   
 			ObservableList<User> us= FXCollections.observableArrayList(NameUser);
 	 	    usernameCombo.setItems(us);	
 	 	    
 	 	    levelCombo.getItems().addAll(E_Level.values());
		   
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
    	commision.setText(null);
    	probability.setText(null);
    	newButton.setVisible(false);
    	saveButton.setVisible(true);
    	usernameCombo.setDisable(true);
    	levelCombo.setDisable(true);
    }

    //There is a problem with the probability value
    @SuppressWarnings("null")
	@FXML
    void saveMethod(ActionEvent event) {
    	newButton.setVisible(true);
    	newButton.setDisable(true);
    	saveButton.setVisible(false);
    	commision.setDisable(true);
    	probability.setDisable(true);
    	Date date= Date.valueOf(LocalDate.now());
    	int com;
    	com=Integer.parseInt(commision.getText());
    	usernameCombo.setDisable(false);
    	levelCombo.setDisable(false);
    	Recommendation rec = control.RecLogic.getInstance().getRecommendations().get(0);
    	rec.setProbability(control.RecLogic.getInstance().calcProbability(date));
    	rec.setRecNum(control.RecLogic.getInstance().getRecID());
    	rec.setCreationDate(date);
    	if (control.SysData.getInstance().getMode().equals(E_NetMode.Normal))
    	rec.setApproved(false);
    	else
    		rec.setApproved(true);
    	rec.setRecommendedFee(com);
    
    	control.RecLogic.getInstance().insertRecommendation(rec);
    	sendButton.setDisable(false);
    }

    @FXML
    void sendMethod(ActionEvent event) {

    	if(usernameCombo.getValue()==null || levelCombo.getValue()== null) {
       	 
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("EROR");
        	alert.setContentText("Please enter user and level");

        	alert.showAndWait(); 
	}
	
	if (usernameCombo.getValue()!=null && levelCombo.getValue()!=null) {
		RecommendedFor rf = control.RecLogic.getInstance().getRecommendationsFor().get(0);
		rf.setCommitmentLevel(levelCombo.getValue());
		rf.setRecommendation(control.RecLogic.getInstance().getRecommendations()
				.get(control.RecLogic.getInstance().getRecommendations().size()-1).getRecNum());
		rf.setUserAddress(usernameCombo.getValue().getPublicAddress());
		rf.setUserSignature(usernameCombo.getValue().getSignature());
	control.RecLogic.getInstance().insertRecommendedFor(rf);
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Done");
	alert.setContentText("Recommendation send to " + usernameCombo.getValue().getUsername());

	alert.showAndWait(); 
	newButton.setDisable(false);
	}
	
	if (commision.getText() == null  || probability.getText() ==null || !newButton.isVisible()){
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("EROR");
    	alert.setContentText("You have to creat a recommandation");

    	alert.showAndWait(); 
	}

    }

}
