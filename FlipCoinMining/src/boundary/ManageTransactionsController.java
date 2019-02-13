package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManageTransactionsController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox menu;

    @FXML
    private ImageView lotteries;

    @FXML
    private ImageView riddles;

    @FXML
    private ImageView blocks;

    @FXML
    private ImageView miners;

    @FXML
    private ImageView report;

    @FXML
    private HBox topBorder;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView mailIcon;

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
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> level;

    @FXML
    private Label errorMassage;

    @FXML
    private Label availabilityLable;

    @FXML
    private Label bytesLable;

    @FXML
    private Label sizeLable;

    @FXML
    private TableView<?> transTable;

    @FXML
    private TableColumn<?, ?> c1;

    @FXML
    private TableColumn<?, ?> c2;
    
    @FXML
    private Button addButton;

    @FXML
    private Button viewReport;

    @FXML
    void addTransToBlock(ActionEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void lotteriesScreen(MouseEvent event) {

    }

    @FXML
    void mailsScreen(MouseEvent event) {

    }

    @FXML
    void manageBlocks(MouseEvent event) {

    }

    @FXML
    void minersScreen(MouseEvent event) {

    }

    @FXML
    void pairsReport(ActionEvent event) {

    }

    @FXML
    void riddlesScreen(MouseEvent event) {

    }

    @FXML
    void watchReport(MouseEvent event) {

    }

}
