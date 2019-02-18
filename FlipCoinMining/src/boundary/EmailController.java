package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EmailController {

    @FXML
    private BorderPane borderPane;

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
    private TableView<?> inbox;

    @FXML
    private TableColumn<?, ?> inboxC;

    @FXML
    private TextField dateArea;

    @FXML
    private TextArea textArea;

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void mailsScreen(MouseEvent event) {

    }

    @FXML
    void showDetails(MouseEvent event) {

    }
    
    @FXML
    void backHome(MouseEvent event) {

    }
    
}
