package boundary;

import java.sql.Date;
import java.util.ArrayList;

import entity.Item;
import entity.Recommendation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecommendationsController {

	protected static Recommendation currentRec;
	
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
    private TableView<Recommendation> table;

    @FXML
    private TableColumn<Recommendation, Integer> recNum;

    @FXML
    private TableColumn<Recommendation, Date> creaDate;

    @FXML
    private TableColumn<Recommendation, Double> prob;

    @FXML
    private TableColumn<Recommendation, Double> fee;

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
    private Button editR;
    
	public void initialize() {

    recNum.setCellValueFactory(new PropertyValueFactory<>("recNum"));
	creaDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
	prob.setCellValueFactory(new PropertyValueFactory<>("probability"));
	fee.setCellValueFactory(new PropertyValueFactory<>("recommendedFee"));
	
	setTable();
	}
	
	public void setTable() {


		ObservableList<Recommendation> I= FXCollections.observableArrayList();
		ArrayList<Recommendation> r = control.RecLogic.getInstance().getRecommendations();
		for(Recommendation rec : r)
		{
			if(rec.getIsApproved().equals(false))
				I.add(rec);
		}
		table.setItems(I);
		table.refresh();
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
    void chosenRec(MouseEvent event) {
    	currentRec = table.getSelectionModel().getSelectedItem();
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

    @FXML
    void editRec(ActionEvent event) {
    	ViewLogic.newEditRecommendationWindow();
    }
    
    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newUserWindow();
    }
    
	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
