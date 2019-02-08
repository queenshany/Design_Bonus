package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CategoriesController {

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
    private ComboBox<?> categoriesCombo;

    @FXML
    private TextField editText;

    @FXML
    private Button save;

    @FXML
    private Label lable;

    @FXML
    private TextField newText;

    @FXML
    private Button addButton;

    @FXML
    void addCategory(ActionEvent event) {

    }

    @FXML
    void allRecommendations(MouseEvent event) {

    }

    @FXML
    void generateTransReport(MouseEvent event) {

    }

    @FXML
    void generateUsersReport(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void manageCategories(MouseEvent event) {

    }

    @FXML
    void manageParameters(MouseEvent event) {

    }

    @FXML
    void newRecommendation(MouseEvent event) {

    }

    @FXML
    void updateCategoty(ActionEvent event) {

    }

}
