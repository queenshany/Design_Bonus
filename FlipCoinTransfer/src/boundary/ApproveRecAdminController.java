package boundary;

import java.sql.Date;
import java.util.ArrayList;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ApproveRecAdminController {

    @FXML
    private AnchorPane pane;

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
    private Label title;

    @FXML
    private Button approveButton;

    @FXML
    private Label errorLable;

    protected static Recommendation chosenRec;
    
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
    void approveRec(ActionEvent event) {
    	if (chosenRec == null) {
    		errorLable.setVisible(true);
    	}
    	else {
    		chosenRec.setApproved(true);
    		control.RecLogic.getInstance().updateRecommendation(chosenRec);
    		setTable();
    	}
    }

    @FXML
    void chosenRec(MouseEvent event) {
    	errorLable.setVisible(false);
    	chosenRec = table.getSelectionModel().getSelectedItem();
    }

}
