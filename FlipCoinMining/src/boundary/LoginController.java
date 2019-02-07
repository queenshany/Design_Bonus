package boundary;

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

    @FXML
    void createNewAcount(MouseEvent event) {

    }

    @FXML
    void login(ActionEvent event) {

    }

}
