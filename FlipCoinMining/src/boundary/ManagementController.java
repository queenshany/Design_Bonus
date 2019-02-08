package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManagementController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

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
    private Button addR;

    @FXML
    private Button editR;

    @FXML
    private Tab lotteries;

    @FXML
    private AnchorPane p2;

    @FXML
    private TableView<?> t2;

    @FXML
    private Button addL;

    @FXML
    private Tab allTransactions;

    @FXML
    private AnchorPane p3;

    @FXML
    private TableView<?> t3;

    @FXML
    private Button addB;

    @FXML
    private Button editB;

    @FXML
    void addBonus(ActionEvent event) {

    }

    @FXML
    void addLotteries(ActionEvent event) {

    }

    @FXML
    void addRiddle(ActionEvent event) {

    }

    @FXML
    void editBonus(ActionEvent event) {

    }

    @FXML
    void editLotteries(ActionEvent event) {

    }

    @FXML
    void editRiddle(ActionEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

}
