package boundary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entity.Message;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailScreenController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private HBox topBorder;

	@FXML
	private ImageView logo;

	@FXML
	private ImageView searchIcon;

	@FXML
	private TextField searchText;

	@FXML
	private ImageView mailIcon;

	@FXML
	private ImageView settingsIcon;

	@FXML
	private ImageView logoutIcon;

	@FXML
	private VBox bottom;

	@FXML
	private ImageView line;

	@FXML
	private HBox hbox;

	@FXML
	private Label networkStatus;

	@FXML
	private ImageView homeIcon;

	@FXML
	private VBox menu;

	@FXML
	private ImageView products;

	@FXML
	private ImageView transactions;

	@FXML
	private ImageView wallets;

	@FXML
	private ImageView arrow1;

	@FXML
	private ImageView arrow2;

	@FXML
	private ImageView arrow3;

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
		//		
		//		//Fill Table
		//		//Table
		//		inboxC.setCellValueFactory(new PropertyValueFactory<>("title"));
		//		
		//		//Fill Table
		//Table
		//		inboxC.setCellValueFactory(new PropertyValueFactory<>("title"));

		//Fill Table

		ArrayList<Message> m = control.UserLogic.getInstance().getMessagesOfUser(LoginController.curretUser);
		ObservableList<Message> ms= FXCollections.observableArrayList(m);
		inbox.setItems(ms);

	}

	@FXML
	void hide1(MouseEvent event) {
		//    	arrow1.setVisible(true);
		//    	products.setVisible(false);
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
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
	void mailsScreen(MouseEvent event) {
		//TODO
	}

	@FXML
	void productsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newProductsWindow();
	}

	@FXML
	void searchProducts(MouseEvent event) {
		LoginController.keyWord = searchText.getText();
		closeWindow();
		ViewLogic.newSearchPageWindow();
	}

	@FXML
	void settingsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newSettingsWindow();
	}

	@FXML
	void show1(MouseEvent event) {
		//    	arrow1.setVisible(false);
		//    	products.setVisible(true);
		//TODO
	}

	@FXML
	void show2(DragEvent event) {
		//TODO
	}

	@FXML
	void show3(DragEvent event) {
		//TODO
	}

	@FXML
	void transactionsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newTransactionsWindow();
	}

	@FXML
	void walletsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newWalletsWindow();
	}

	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}

}
