package boundary;

import java.util.ArrayList;

import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageEmployeeController {

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
    private TabPane tabPane;

    @FXML
    private Tab allUsers;

    @FXML
    private AnchorPane p1;

    @FXML
    private TableView<User> usersTable;

	@FXML
	private TableColumn<User, String> publicAddress;

	@FXML
	private TableColumn<User, String> signature;

	@FXML
	private TableColumn<User, String> username;

	@FXML
	private TableColumn<User, String> phone;

	@FXML
	private TableColumn<User, Boolean> isEmployee;

    @FXML
    private Button addButton;

    @FXML
    private Button remove;
    
    protected static User chosenUser;

	public void initialize() {

		publicAddress.setCellValueFactory(new PropertyValueFactory<>("publicAddress"));
		signature.setCellValueFactory(new PropertyValueFactory<>("signature"));
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		isEmployee.setCellValueFactory(new PropertyValueFactory<>("isEmployee"));
    
		ArrayList<User> users = control.UserLogic.getInstance().getUsers(); 	
		ObservableList<User> us= FXCollections.observableArrayList(users);
		usersTable.setItems(us);
	}
		
    @FXML
    void addEmployee(ActionEvent event) {
    	chosenUser.setEmployee(true);
    	control.UserLogic.getInstance().updateUser(chosenUser);
    	usersTable.refresh();
    }

    @FXML
    void chosenUser(MouseEvent event) {
    	chosenUser = usersTable.getSelectionModel().getSelectedItem();
    }

	@FXML
	void goHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newAdminWindow();
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

    @FXML
    void removeEmployee(ActionEvent event) {
    	chosenUser.setEmployee(false);
    	control.UserLogic.getInstance().updateUser(chosenUser);
    	usersTable.refresh();
    }
    

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}

}
