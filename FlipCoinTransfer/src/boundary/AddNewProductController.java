package boundary;

import java.util.ArrayList;

import entity.Category;
import entity.Item;
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

    @SuppressWarnings("null")
	@FXML
    void addNewProduct(ActionEvent event) {
    	Item item = control.ItemLogic.getInstance().getItems().get(0);
    	item.setCatalogNumber(control.ItemLogic.getInstance().getItemID());
    	item.setItemName(itemName.getText());
    	item.setImage(image.getText());
    	item.setDescription(description.getText());
    	item.setCategory(categoryCombo.getVisibleRowCount());
    	String convert = (price.getText());
    	double x = Double.parseDouble(convert);
    	item.setPrice(x);
    	String convert2 = (quantity.getText());
    	int y = Integer.parseInt(convert2);
    	item.setQuantity(y);
    	
    	control.ItemLogic.getInstance().insertItem(item);
    
    	((Stage) pane.getScene().getWindow()).setTitle("You can add more products");
    }

	public void initialize() {

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

