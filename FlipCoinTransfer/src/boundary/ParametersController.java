package boundary;

import java.sql.Date;
import java.time.LocalDate;

import entity.SystemParams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParametersController {

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
    private AnchorPane pane;

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
    private VBox vbox1;

    @FXML
    private HBox hbox2;

    @FXML
    private VBox vbox2;

    @FXML
    private Label lab1;

    @FXML
    private TextField transMinSize;

    @FXML
    private HBox h3;

    @FXML
    private VBox v3;

    @FXML
    private Label lab2;

    @FXML
    private TextField transMaxSize;

    @FXML
    private HBox h4;

    @FXML
    private VBox v4;

    @FXML
    private Label lab3;

    @FXML
    private TextField sizeForExpansion;

    @FXML
    private HBox h6;

    @FXML
    private VBox v6;

    @FXML
    private Label lab4;

    @FXML
    private TextField priceForExpansion;

    @FXML
    private VBox v7;

    @FXML
    private HBox h7;

    @FXML
    private VBox v8;

    @FXML
    private Label lab5;

    @FXML
    private TextField discountPrecent;

    @FXML
    private HBox h8;

    @FXML
    private VBox v9;

    @FXML
    private Label lab6;

    @FXML
    private TextField priceForDiscount;

    @FXML
    private HBox h9;

    @FXML
    private VBox v10;

    @FXML
    private Label lab7;

    @FXML
    private TextField transSizeFree;

    @FXML
    private HBox h10;

    @FXML
    private VBox v11;

    @FXML
    private Label lab8;

    @FXML
    private TextField maxDiscount;

    @FXML
    private HBox h11;

    @FXML
    private Button saveButton;

	public void initialize() {

		String one = String.valueOf(control.SysData.getInstance().getLastVersionParams().getTransMinSize());
		String two = String.valueOf(control.SysData.getInstance().getLastVersionParams().getTransMaxSize());
		String three = String.valueOf(control.SysData.getInstance().getLastVersionParams().getTransSizeForExpansion());
		String four = String.valueOf(control.SysData.getInstance().getLastVersionParams().getPriceForExpansion());
		String five = String.valueOf(control.SysData.getInstance().getLastVersionParams().getDiscountPercentPerFee());
		String six = String.valueOf(control.SysData.getInstance().getLastVersionParams().getPriceForDiscount());
		String seven = String.valueOf(control.SysData.getInstance().getLastVersionParams().getTransSizeFree());
		String eight = String.valueOf(control.SysData.getInstance().getLastVersionParams().getMaxAllowableDiscount());

		transMinSize.setText(one);
		transMaxSize.setText(two);
		sizeForExpansion.setText(three);
		priceForExpansion.setText(four);
		discountPrecent.setText(five);
		priceForDiscount.setText(six);
		transSizeFree.setText(seven);
		maxDiscount.setText(eight);
	}
    
    @SuppressWarnings("null")
	@FXML
    void editVirsion(ActionEvent event) {
    	
    	String one = transMinSize.getText();
    	String two = transMaxSize.getText();
    	String three = sizeForExpansion.getText();
    	String four = priceForExpansion.getText();
    	String five = discountPrecent.getText();
    	String six = priceForDiscount.getText();
    	String seven = transSizeFree.getText();
    	String eigth = maxDiscount.getText();
    	
    	 int transMinSize = Integer.parseInt(one);
    	 int transMaxSize = Integer.parseInt(two);
    	 int transSizeForExpansion = Integer.parseInt(three);
    	 double priceForExpansion = Double.parseDouble(four);
    	 double discountPercentPerFee = Double.parseDouble(five);
    	 double priceForDiscount = Double.parseDouble(six);
    	 int transSizeFree = Integer.parseInt(seven);
    	 double maxAllowableDiscount = Double.parseDouble(eigth);

    	 Date date = Date.valueOf(LocalDate.now());
    	 
    	 SystemParams sys = control.SysData.getInstance().getLastVersionParams();
    	 sys.setVersion(control.SysData.getInstance().getSysVersion());
    	 sys.setVersionDate(date);
 		sys.setTransMinSize(transMinSize);
 		sys.setTransMaxSize(transMaxSize);
 		sys.setTransSizeForExpansion(transSizeForExpansion);
 		sys.setPriceForExpansion(priceForExpansion);
 		sys.setDiscountPercentPerFee(discountPercentPerFee);
 		sys.setPriceForDiscount(priceForDiscount);
 		sys.setTransSizeFree(transSizeFree);
 		sys.setMaxAllowableDiscount(maxAllowableDiscount);
 		control.SysData.getInstance().insertSysParams(sys);
    	 
    }

    @FXML
    void allRecommendations(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newViewRecommendationWindow();
    }

    @FXML
    void generateTransReport(MouseEvent event) {
    	
    }

    @FXML
    void generateUsersReport(MouseEvent event) {

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
    void newRecommendation(MouseEvent event) {
    	closeWindow();
    	ViewLogic.newCreateRecommendationWindow();
    }

    
	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}
