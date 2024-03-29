package boundary;

import java.util.ArrayList;

import entity.Category;
import entity.Item;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.web.servlets.Controller;

public class SearchPageController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox menu;

	@FXML
	private ImageView products;

	@FXML
	private ImageView transactions;

	@FXML
	private ImageView wallets;

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
	private TextField keywords;

	@FXML
	private TextField from;

	@FXML
	private TextField until;

	@FXML
	private ComboBox<Category> categoryCombo;

	@FXML
	private Button searchButton;
	@FXML
	private TableView<Item> table;

	@FXML
	private TableColumn<Item, Integer> catalogNumber;

	@FXML
	private TableColumn<Item, String> itemName;

	@FXML
	private TableColumn<Item, String> image;

	@FXML
	private TableColumn<Item, String> description;

	@FXML
	private TableColumn<Item, Double> price;

	@FXML
	private TableColumn<Item, Integer> quantity;

	@FXML
	private TableColumn<Item, String> category;

	public void initialize() {

		catalogNumber.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		image.setCellValueFactory(new PropertyValueFactory<>("image"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		category.setCellValueFactory(new PropertyValueFactory<>("category"));
		//			
		//		getProducts();

		ArrayList<Item> search =
				control.ItemLogic.getInstance().searchItem(null, null, null, LoginController.keyWord, null);
		ObservableList<Item> s= FXCollections.observableArrayList(search);
		table.setItems(s);

		//Fill Category Combo
		comboCat();
		//		ArrayList<Category> ct = new ArrayList<Category>();
		//		ct=control.ItemLogic.getInstance().getCategories();
		// 			 categoryCombo.getItems().addAll(ct);
		// 			ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		// 	 	    categoryCombo.setItems(cate);
		// 	 	    System.out.println(LoginController.keyWord);

	} 

	public void comboCat() {
		ArrayList<Category> ct = new ArrayList<Category>();
		ct=control.ItemLogic.getInstance().getCategories();
		categoryCombo.getItems().addAll(ct);
		ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		categoryCombo.setItems(cate);
	}

	public void getProducts(){

		//	 control.ItemLogic.getInstance().searchItem(minPrice, maxPrice, cat, str, seller);

		//	   ObservableList<Item> I= FXCollections.observableArrayList();
		//	   ArrayList<Item> Items = control.ItemLogic.getInstance().getItems();
		//	   for(Item itms : Items)
		//	   {
		//		   if(itms.getSellerAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress()) &&
		//				   itms.getSellerSignature().equalsIgnoreCase(LoginController.curretUser.getSignature()))
		//		   I.add(itms);
		//	   }
		//		table.setItems(I);
		//		table.refresh();
	}


	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	@FXML
	void mailsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newEmailWindow();
	}

	@FXML
	void productsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newProductsWindow();
	}

	@FXML
	void searchProduct(ActionEvent event) {
		Double minPrice = null;
		Double maxPrice = null;
		Category cat = null;
		String str = null;
		User seller = null;

		if (!from.getText().isEmpty() && !from.getText().equals("")) {
			try { 
				minPrice=Double.parseDouble(from.getText());
				if (minPrice < 0)
					throw new NumberFormatException();
			}
			catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Value");
				alert.setContentText("Invalid Min Price");
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.showAndWait();
			}
		}
		if (!until.getText().isEmpty() && !until.getText().equals("")) {
			try { 
				maxPrice=Double.parseDouble(until.getText());
				if (maxPrice < 0)
					throw new NumberFormatException();
			}
			catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Value");
				alert.setContentText("Invalid Max Price");
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.showAndWait();
			}
		}
		if (categoryCombo.getSelectionModel().getSelectedItem() != null)
			cat=categoryCombo.getSelectionModel().getSelectedItem();
		if (!keywords.getText().isEmpty() && !keywords.getText().equals(""))
			str=keywords.getText();

		ArrayList<Item> search =
				control.ItemLogic.getInstance().searchItem(minPrice, maxPrice, cat, str, seller);
		ObservableList<Item> s= FXCollections.observableArrayList(search);
		table.setItems(s);
		table.refresh();
		keywords.clear();
		from.clear();
		until.clear();
		//		categoryCombo.setPromptText(null);
		categoryCombo.getSelectionModel().clearSelection();
	}

	@FXML
	void searchProducts(MouseEvent event) {
		closeWindow();
		ViewLogic.newSearchPageWindow();
	}

	@FXML
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newUserWindow();
	}

	@FXML
	void settingsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newSettingsWindow();
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
