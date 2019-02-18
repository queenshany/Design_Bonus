package boundary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entity.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private TableView<Message> inbox;

    @FXML
    private TableColumn<Message, String> inboxC;

    @FXML
    private TextField dateArea;

    @FXML
    private TextArea textArea;

    public void initialize() {

    	textArea.setEditable(false);
    	dateArea.setEditable(false);
    	
//		//Table
		inboxC.setCellValueFactory(new PropertyValueFactory<>("title"));

		ArrayList<Message> m = control.MinerLogic.getInstance().getMessages();	
		ObservableList<Message> ms= FXCollections.observableArrayList(m);
		inbox.setItems(ms);
	
    }
    
    @FXML
    void logOut(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newLoginWindow();
    }

    @FXML
    void mailsScreen(MouseEvent event) {

    }

    @FXML
    void showDetails(MouseEvent event) {
    	Message m = inbox.getSelectionModel().getSelectedItem();
      	textArea.setText(m.getDescription());
    	String pattern = "MM/dd/yyyy HH:mm:ss";
    	DateFormat df = new SimpleDateFormat(pattern);
    	dateArea.setText(df.format(inbox.getSelectionModel().getSelectedItem().getMessageDate()));
    }
    
    @FXML
    void backHome(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newUserWindow();
    }
    
    protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
