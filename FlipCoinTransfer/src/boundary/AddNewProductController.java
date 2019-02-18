package boundary;

import java.util.ArrayList;

import control.Validation;
import entity.Category;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewProductController {

	@FXML
	private AnchorPane pane;

	@FXML
	private Label l;

	@FXML
	private ImageView title;

	@FXML
	private Label l2;

	@FXML
	private Label l3;

	@FXML
	private Label l4;

	@FXML
	private Label l5;

	@FXML
	private Label l6;

	@FXML
	private TextField itemName;

	@FXML
	private TextField image;

	@FXML
	private TextField description;

	@FXML
	private TextField price;

	@FXML
	private TextField quantity;

	@FXML
	private ComboBox<Category> categoryCombo;

	@FXML
	private Button addButton;

	@FXML
	private Label alertLabel;

	@FXML
	void addNewProduct(ActionEvent event) {

		if (!itemName.getText().isEmpty()) {
			alertLabel.setText("");
			if (Validation.validName(itemName.getText())) {
				alertLabel.setText("");
				if (!image.getText().isEmpty()) {
					alertLabel.setText("");
					if (Validation.isValidURL(image.getText())) {
						alertLabel.setText("");
						if (!description.getText().isEmpty()) {
							alertLabel.setText("");
							if (categoryCombo.getSelectionModel().getSelectedItem() != null) {
								alertLabel.setText("");
								try {
									double pr = Double.parseDouble(price.getText());
									alertLabel.setText("");
									try{
										int qua = Integer.parseInt(quantity.getText());
										alertLabel.setText("");
										Item item = new Item(control.ItemLogic.getInstance().getItemID(),
												itemName.getText(),
												image.getText(),
												description.getText(),
												pr,
												qua,
												categoryCombo.getSelectionModel().getSelectedItem().getSerialNumber(),
												LoginController.curretUser.getPublicAddress(),
												LoginController.curretUser.getSignature());
										control.ItemLogic.getInstance().insertItem(item);
										Alert alert = new Alert(AlertType.CONFIRMATION);
										alert.setTitle("Item added Successfully!");
										alert.setContentText(item + " was added successfully!");
										alert.initModality(Modality.APPLICATION_MODAL);
										alert.showAndWait();

										((Stage) pane.getScene().getWindow()).setTitle("You can add more products");

										((Stage) ProductsController.bp.getScene().getWindow()).close();
										ViewLogic.newProductsWindow();
										closeWindow();

									}catch(NumberFormatException e) {
										alertLabel.setText("Invalid quantity");
									}
								}catch( NumberFormatException e) {
									alertLabel.setText("Invalid price");
								}
							}else {
								alertLabel.setText("Please select a category");
							}
						}else {
							alertLabel.setText("Please write a description");
						}
					}else {
						alertLabel.setText("Invalid image url");
					}
				}else {
					alertLabel.setText("Invalid image url");
				}
			}else {
				alertLabel.setText("Invalid item name");
			}
		}else {
			alertLabel.setText("Invalid item name");
		}
	}

	public void initialize() {

		//Fill the category combobox
		ArrayList<Category> ct = new ArrayList<Category>();
		ct=control.ItemLogic.getInstance().getCategories();
		categoryCombo.getItems().setAll(ct);
		ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		categoryCombo.setItems(cate);	
	}

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}

