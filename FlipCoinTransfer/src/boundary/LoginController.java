package boundary;

import java.util.ArrayList;

import entity.Item;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.E_NetMode;

public class LoginController extends AbstractController{

	protected static User curretUser;
	protected static String keyWord;
	protected static E_NetMode netMode;

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox top;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView loginLogo;

    @FXML
    private VBox center;

    @FXML
    private Text donthave;

    @FXML
    private Text createAcount;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button logButton;

    @FXML
    private VBox bottom;

    @FXML
    private ImageView line;

    @FXML
    private Text errorMassege;
    
    @FXML
    private Label error;
    

    @FXML
    void createNewAcount(MouseEvent event) {
    	closeWindow();
		ViewLogic.newRegistrationWindow();
    }

    @FXML
    void login(ActionEvent event) {
    	error.setVisible(false);
    	
    	if(username.getText().equals("Admin") && password.getText().equals("Admin")){
    		closeWindow();
    		ViewLogic.newAdminWindow();
    }
    	else {
    	 ArrayList<User> user = control.UserLogic.getInstance().getUsers();
  	   for(User us : user)
  	   {
  		   if(us.getUsername().equalsIgnoreCase(username.getText()) &&
  				 us.getPassword().equalsIgnoreCase(password.getText()) 
  				 &&!us.getIsEmployee()) {
  			   curretUser = us;
  				closeWindow();
  	    		ViewLogic.newUserWindow();		   
  	   }
  		 if(us.getUsername().equalsIgnoreCase(username.getText()) &&
  				 us.getPassword().equalsIgnoreCase(password.getText()) 
  				 &&us.getIsEmployee()) {
  			 ViewLogic.newEmployeeOrUserWindow();
  			 closeWindow();
  		 }
 
  		   }
    	}
			   error.setVisible(true);
    }



	public void initialize() {
		netMode = control.SysData.getInstance().getMode();
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
