package boundary;

import java.util.ArrayList;

import entity.Category;
import entity.Item;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

    
    
    @FXML
    void updateProduct(ActionEvent event) {
//    	Item item;
    	
//    	control.ItemLogic.getInstance().updateItem(item);
    }

	public void initialize() {

		//Fill the edit page
		itemName.setText(ProductsController.currentProduct.getItemName());
		image.setText(ProductsController.currentProduct.getImage());
		description.setText(ProductsController.currentProduct.getDescription());		
		categoryCombo.setPromptText(
				control.ItemLogic.getInstance().getCategories().get(ProductsController
						.currentProduct.getCategory()).getCategoryName()); 
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

