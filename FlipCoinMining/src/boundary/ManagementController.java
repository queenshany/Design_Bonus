package boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
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
    private Tab riddles;

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
    private TableView<?> lotteriesTable;

    @FXML
    private TableColumn<?, ?> lotteryNum;

    @FXML
    private TableColumn<?, ?> lotteryDate;

    @FXML
    private TableColumn<?, ?> maxParticipants;

    @FXML
    private TableColumn<?, ?> numOfWinners;

    @FXML
    private TableColumn<?, ?> numOfBonuses;

    @FXML
    private Button addL;

    @FXML
    private Tab bonuses;

    @FXML
    private AnchorPane p3;

    @FXML
    private TableView<?> bonusesTable;

    @FXML
    private TableColumn<?, ?> bonusNum;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private Button addB;

    @FXML
    private Button editB;

    @FXML
    private Tab levels;

    @FXML
    private AnchorPane p31;

    @FXML
    private TableView<?> levelsTable;

    @FXML
    private TableColumn<?, ?> levelCode;

    @FXML
    private TableColumn<?, ?> levelName;

    @FXML
    private TableColumn<?, ?> difficultyLevel;

    @FXML
    private TableColumn<?, ?> blockSize;

    @FXML
    private Button addB1;

    @FXML
    private Button editB1;

    @FXML
    private TableView<?> minersTable;

    @FXML
    private AnchorPane p32;

    @FXML
    private ScrollPane scrollMiners;

    @FXML
    private TableColumn<?, ?> uniqueAddress;

    @FXML
    private TableColumn<?, ?> MinerName;

    @FXML
    private TableColumn<?, ?> Email;

    @FXML
    private TableColumn<?, ?> DigitalProfit;

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
    void chosenBonus(MouseEvent event) {

    }

    @FXML
    void chosenLevel(MouseEvent event) {

    }

    @FXML
    void chosenLottery(MouseEvent event) {

    }

    @FXML
    void chosenMiner(MouseEvent event) {

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
