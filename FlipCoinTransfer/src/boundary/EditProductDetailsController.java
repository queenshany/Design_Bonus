package boundary;

import java.util.ArrayList;

import control.ItemLogic;
import control.Validation;
import entity.Category;
import entity.Item;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditProductDetailsController extends AbstractController{

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
	private Label alertLabel;

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
	private Button saveButton;

	//	Category c = control.ItemLogic.getInstance().getCategories().get(ProductsController
			//			.currentProduct.getCategory());

	@FXML
	void updateProduct(ActionEvent event) {


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

										Item item = new Item(ProductsController.currentProduct.getCatalogNumber(),
												itemName.getText(),
												image.getText(),
												description.getText(),
												pr,
												qua,
												categoryCombo.getSelectionModel().getSelectedItem().getSerialNumber(),
												LoginController.curretUser.getPublicAddress(),
												LoginController.curretUser.getSignature());

										control.ItemLogic.getInstance().updateItem(item);


										Alert alert = new Alert(AlertType.CONFIRMATION);
										alert.setTitle("Item added Successfully!");
										alert.setContentText(item + " was updated successfully!");
										alert.initModality(Modality.APPLICATION_MODAL);
										alert.showAndWait();

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

		//Fill the edit page
		itemName.setText(ProductsController.currentProduct.getItemName());
		image.setText(ProductsController.currentProduct.getImage());
		description.setText(ProductsController.currentProduct.getDescription());

		Category c = control.ItemLogic.getInstance().getCategories().get(ProductsController.currentProduct.getCategory()-1);
		categoryCombo.setValue(c);
		Double convert = (ProductsController.currentProduct.getPrice());
		String pric = String.valueOf(convert);
		price.setText(pric);
		Integer convert2 = (ProductsController.currentProduct.getQuantity());
		String qua = String.valueOf(convert2);
		quantity.setText(qua);

		//Fill the category combobox
		ArrayList<Category> ct = new ArrayList<Category>();
		ct=control.ItemLogic.getInstance().getCategories();
		categoryCombo.getItems().addAll(ct);
		ObservableList<Category> cate= FXCollections.observableArrayList(ct);
		categoryCombo.setItems(cate);	
	}

	protected void closeWindow() {
		((Stage) pane.getScene().getWindow()).close();
	}
}

