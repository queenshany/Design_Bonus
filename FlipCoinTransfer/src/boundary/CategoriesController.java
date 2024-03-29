package boundary;

import java.util.ArrayList;

import javax.swing.JFrame;

import control.TransLogic;
import control.UserLogic;
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

	public void initialize() {
		setCombo();
		editText.setEditable(false);

	}

	private void setCombo() {
		//Fill the category combobox
		ArrayList<Category> ct = new ArrayList<Category>();
		ct=control.ItemLogic.getInstance().getCategories();
		categoriesCombo.getItems().setAll(ct);
		ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		categoriesCombo.setItems(cate);
	}

	@FXML
	void theChosen(ActionEvent event) {
		editText.setText(categoriesCombo.getSelectionModel().getSelectedItem().getCategoryName());
		editText.setEditable(true);
	}

	@FXML
	void addCategory(ActionEvent event) {
//		Category c = control.ItemLogic.getInstance().getCategories().get(0);
//		c.setSerialNumber(control.ItemLogic.getInstance().getCategoryID());
//		c.setCategoryName(newText.getText());
//		control.ItemLogic.getInstance().insertCategory(c);
//		lable.setVisible(true);
//		lable.setText("You added new category");
		if (!newText.getText().isEmpty() || !newText.getText().equals("")) {
			Category c = new Category (control.ItemLogic.getInstance().getCategoryID(),
					newText.getText());
			control.ItemLogic.getInstance().insertCategory(c);
			lable.setVisible(true);
			lable.setText("A new category has been added");
			setCombo();
		}
		else {
			lable.setVisible(true);
			lable.setText("Invalid Category name");
		}
	}


	@FXML
	void updateCategoty(ActionEvent event) {
//		if (categoriesCombo.getSelectionModel().getSelectedItem() != null) {
//			Category ct = categoriesCombo.getSelectionModel().getSelectedItem();
//			if (editText.getText()!=null || !editText.getText().equals("")) {
//				ct.setCategoryName(editText.getText());
//				control.ItemLogic.getInstance().updateCategory(ct);
//				lable.setVisible(true);
//				lable.setText("You edit the category");
//			}
//		}
		//			}
		//			else {
		//			control.ItemLogic.getInstance().deleteCategory(ct);
		//			lable.setVisible(true);
		//			lable.setText("You delete the category");
		//			}
		//		}	
		
		if (categoriesCombo.getSelectionModel().getSelectedItem() != null) {
			Category ct = categoriesCombo.getSelectionModel().getSelectedItem();
			if (!editText.getText().isEmpty() || !editText.getText().equals("")) {
				ct.setCategoryName(editText.getText());
				control.ItemLogic.getInstance().updateCategory(ct);
				lable.setVisible(true);
				lable.setText("Category has been edited");
				setCombo();

			}
			else {
				lable.setVisible(true);
				lable.setText("Invalid Category name");
			}
		}else {
			lable.setVisible(true);
			lable.setText("Please choose a category to edit");
		}		
	}


	@FXML
	void allRecommendations(MouseEvent event) {
		closeWindow();
		ViewLogic.newViewRecommendationWindow();
	}

	@FXML
	void generateTransReport(MouseEvent event) {
		//ViewLogic.newViewRecommendationWindow();
		//		if (LoginController.curretUser == null) {
		//			Alert alert = new Alert(AlertType.ERROR);
		//			alert.setTitle("User is null");
		//			alert.setContentText("Please select user");
		//			alert.initModality(Modality.APPLICATION_MODAL);
		//			alert.showAndWait();
		//		}else {
		JFrame reportFrame = TransLogic.getInstance().produceTransStatusReport();
		reportFrame.setVisible(true);
		//		}
	}

	@FXML
	void generateUsersReport(MouseEvent event) {
		//ViewLogic.newViewRecommendationWindow();
		//		if (LoginController.curretUser == null) {
		//			Alert alert = new Alert(AlertType.ERROR);
		//			alert.setTitle("User is null");
		//			alert.setContentText("Please select user");
		//			alert.initModality(Modality.APPLICATION_MODAL);
		//			alert.showAndWait();
		//		}else {
		JFrame reportFrame = UserLogic.getInstance().produceUsersReport();
		reportFrame.setVisible(true);
		//		}
	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	@FXML
	void manageCategories(MouseEvent event) {
		closeWindow();
		ViewLogic.newCategoriesWindow();
	}

	@FXML
	void manageParameters(MouseEvent event) {
		closeWindow();
		ViewLogic.newParametersWindow();

	}

	@FXML
	void backhome(MouseEvent event) {
		closeWindow();
		ViewLogic.newEmployeeWindow();

	}

	@FXML
	void newRecommendation(MouseEvent event) {
		closeWindow();
		ViewLogic.newCreateRecommendationWindow();
	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
