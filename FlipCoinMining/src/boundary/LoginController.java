package boundary;

import java.util.ArrayList;

import entity.Miner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

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

	protected static Miner curretMiner;

    @FXML
    void createNewAcount(MouseEvent event) {
    	closeWindow();
		ViewLogic.newRegistrationWindow();
    }

    @FXML
    void login(ActionEvent event) {
    	if(username.getText().equals("Admin") && password.getText().equals("Admin")){
    		closeWindow();
    		ViewLogic.newAdminWindow();
    }
    	 ArrayList<Miner> miners = control.MinerLogic.getInstance().getMiners();
  	   for(Miner m : miners)
  	   {
  		   if(m.getUniqueAddress().equalsIgnoreCase(username.getText()) &&
  				 m.getPassword().equalsIgnoreCase(password.getText())) {
  			   curretMiner = m;
  				closeWindow();
  	    		ViewLogic.newUserWindow();		   
  	   }
  
    }
    }


	public void initialize() {
//		System.out.println("h");
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
