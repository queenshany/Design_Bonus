package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DetailsForAdminController {

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
    private TableView<?> t1;

    @FXML
    private Tab allProducts;

    @FXML
    private AnchorPane p2;

    @FXML
    private TableView<?> t2;

    @FXML
    private Tab allTransactions;

    @FXML
    private AnchorPane p3;

    @FXML
    private TableView<?> t3;

    @FXML
    void logOut(MouseEvent event) {

    }

}
