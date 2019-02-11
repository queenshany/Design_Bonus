package boundary;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Recommendation;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    	
    }

    @FXML
    void generateUsersReport(MouseEvent event) {

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

    }

    //There is a problem with the probability value
    @SuppressWarnings("null")
	@FXML
    void saveMethod(ActionEvent event) {
    	newButton.setVisible(true);
    	saveButton.setVisible(false);
    	commision.setDisable(true);
    	probability.setDisable(true);
    	Date date= Date.valueOf(LocalDate.now());
    	int com;
//    	int prob;
    	com=Integer.parseInt(commision.getText());
//    	prob=Integer.parseInt(probability.getText());
    	usernameCombo.setDisable(false);
    	levelCombo.setDisable(false);
    	Recommendation rec = null;
    	rec.setProbability(control.RecLogic.getInstance().calcProbability(date));
    	rec.setRecNum(control.RecLogic.getInstance().getRecID());
    	rec.setCreationDate(date);
    	if (control.SysData.getInstance().getMode().equals(E_NetMode.Normal))
    	rec.setApproved(false);
    	else
    		rec.setApproved(true);
    	rec.setRecommendedFee(com);
    
    	control.RecLogic.getInstance().insertRecommendation(rec);
    }

    @FXML
    void sendMethod(ActionEvent event) {

    }

}
