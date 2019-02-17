package boundary;

import java.util.ArrayList;

import entity.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

public class CategoriesAdmin {

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
	private ImageView importXML;

	@FXML
	private ImageView expJson;

	@FXML
	private ImageView viewDetails;

	@FXML
	private ImageView employeesManag;

	@FXML
	private ImageView categories;

	@FXML
	private ImageView parameters;

	@FXML
	private ComboBox<Category> categoriesCombo;

	@FXML
	private TextField editText;

	@FXML
	private Button save;

	@FXML
	private Label lable2;

	@FXML
	private TextField newText;

	@FXML
	private Button addButton;

	@FXML
	private Label lable;

	@FXML
	private Button removeButton;


	public void initialize() {
		//Fill the category combobox
		ArrayList<Category> ct = new ArrayList<Category>();
		ct=control.ItemLogic.getInstance().getCategories();
		categoriesCombo.getItems().addAll(ct);
		ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		categoriesCombo.setItems(cate);

	}

	@FXML
	void allDetails(MouseEvent event) {
		closeWindow();
		ViewLogic.newDetailsWindow();
	}

	@FXML
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newAdminWindow();
	}

	@FXML
	void exportJson(MouseEvent event) {

	}

	@FXML
	void importXML(MouseEvent event) {

	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	@FXML
	void manageCategories(MouseEvent event) {
		closeWindow();
		ViewLogic.newAdminCategoriesWindow();
	}

	@FXML
	void manageEmployees(MouseEvent event) {
		closeWindow();
		ViewLogic.newManageEmployeesWindow();
	}

	@FXML
	void manageParameters(MouseEvent event) {

	}

	@FXML
	void theChosen(ActionEvent event) {
		editText.setText(categoriesCombo.getSelectionModel().getSelectedItem().getCategoryName());
		editText.setEditable(true);
	}

	@FXML
	void addCategory(ActionEvent event) {
		Category c = control.ItemLogic.getInstance().getCategories().get(0);
		c.setSerialNumber(control.ItemLogic.getInstance().getCategoryID());
		c.setCategoryName(newText.getText());
		control.ItemLogic.getInstance().insertCategory(c);
		lable.setVisible(true);
		lable.setText("You added new category");
	}


	@FXML
	void removeCat(ActionEvent event) {
		if (categoriesCombo.getSelectionModel().getSelectedItem() != null) {
			Category ct = categoriesCombo.getSelectionModel().getSelectedItem();
			control.ItemLogic.getInstance().deleteCategory(ct);
			lable.setVisible(true);
			lable.setText("You delete the category");
		}
	}

	@FXML
	void updateCategoty(ActionEvent event) {
		if (categoriesCombo.getSelectionModel().getSelectedItem() != null) {
			Category ct = categoriesCombo.getSelectionModel().getSelectedItem();
			if (editText.getText()!=null || !editText.getText().equals("")) {
				ct.setCategoryName(editText.getText());
				control.ItemLogic.getInstance().updateCategory(ct);
				lable.setVisible(true);
				lable.setText("You edit the category");
			}
			//			else {
			//			control.ItemLogic.getInstance().deleteCategory(ct);
			//			lable.setVisible(true);
			//			lable.setText("You delete the category");
			//			}
		}		
	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}