package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegistrationController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox topBorder;

    @FXML
    private ImageView registerTitle;

    @FXML
    private Label titleLable;

    @FXML
    private VBox centerBorder;

    @FXML
    private HBox HBox1;

    @FXML
    private Label username;

    @FXML
    private TextField usernameText;

    @FXML
    private Label usernameLable;

    @FXML
    private HBox HBox2;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Label passwordLable;

    @FXML
    private HBox HBox3;

    @FXML
    private Label verify;

    @FXML
    private PasswordField verifyText;

    @FXML
    private Label verifyLable;

    @FXML
    private HBox HBox4;

    @FXML
    private Label phone;

    @FXML
    private TextField phoneText;

    @FXML
    private Label phoneLable;

    @FXML
    private HBox Hbox5;

    @FXML
    private Label email;

    @FXML
    private TextField emailText;

    @FXML
    private Label emailLable;

    @FXML
    private Label registerLable;

    @FXML
    void newAccount(MouseEvent event) {

    }

}
