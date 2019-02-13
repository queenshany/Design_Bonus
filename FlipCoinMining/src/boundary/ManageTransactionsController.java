package boundary;

import java.util.ArrayList;

import entity.Block;
import entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.E_Type;

public class ManageTransactionsController {


	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox menu;

	@FXML
	private ImageView lotteries;

	@FXML
	private ImageView riddles;

	@FXML
	private ImageView blocks;

	@FXML
	private ImageView miners;

	@FXML
	private ImageView report;

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
	private TableView<Block> table;

	@FXML
	private TableColumn<Block, String> Blockid;

	@FXML
	private TableColumn<Block, Integer> blockSize;

	@FXML
	private Label errorMassage;

	@FXML
	private Label availabilityLable;

	@FXML
	private Label bytesLable;

	@FXML
	private Label sizeLable;

	@FXML
	private TableView<Transaction> transTable;

	@FXML
	private TableColumn<Transaction, Integer> ID;

	@FXML
	private TableColumn<Transaction, E_Type> type;

	@FXML
	private TableColumn<Transaction, Integer> size;

	@FXML
	private TableColumn<Transaction, Double> fee;

	@FXML
	private Button addButton;

	@FXML
	private Button viewReport;

	protected static Block currentBlock;
	
	public void initialize() {

		Blockid.setCellValueFactory(new PropertyValueFactory<>("blockAddress"));
		blockSize.setCellValueFactory(new PropertyValueFactory<>("size"));

		getBlocks();
		
		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		size.setCellValueFactory(new PropertyValueFactory<>("size"));
		fee.setCellValueFactory(new PropertyValueFactory<>("fee"));
		
		ArrayList<Transaction> trans = control.BlockTransLogic.getInstance().getTransWithoutBlock();
		ObservableList<Transaction> t= FXCollections.observableArrayList(trans);
		transTable.setItems(t);


	} 

	public void getBlocks(){

		ObservableList<Block> b= FXCollections.observableArrayList();
		ArrayList<Block> blocks = control.BlockTransLogic.getInstance().getBlocksOfMiner(LoginController.curretMiner);
		for(Block bb : blocks)
		{
			b.add(bb);
		}
		table.setItems(b);
		table.refresh();
	}

	@FXML
	void updateSizeLable(MouseEvent event) {
		String s = String.valueOf(table.getSelectionModel().getSelectedItem().getSize());
		sizeLable.setText(s);
		currentBlock = table.getSelectionModel().getSelectedItem();
	}

	@FXML
	void addTransToBlock(ActionEvent event) {
		errorMassage.setVisible(false);
		Transaction t = transTable.getSelectionModel().getSelectedItem();
		if (t.getSize() > control.BlockTransLogic.getInstance().calcBlockSizeLeft(currentBlock)) {
			errorMassage.setText("Please choose smaller transaction");
			errorMassage.setVisible(true);
		}
		else {
		control.BlockTransLogic.getInstance().attachTransToBlock(t, currentBlock);
		int currentSize = control.BlockTransLogic.getInstance().calcBlockSizeLeft(currentBlock);
		String s = String.valueOf(currentSize);
		sizeLable.setText(s);
		}
	}


	@FXML
	void pairsReport(ActionEvent event) {

	}

	@FXML
	void logOut(MouseEvent event) {
		closeWindow();
		ViewLogic.newLoginWindow();
	}

	@FXML
	void lotteriesScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newLotteriesWindow();
	}

	@FXML
	void mailsScreen(MouseEvent event) {

	}

	@FXML
	void manageBlocks(MouseEvent event) {
		closeWindow();
		ViewLogic.newBlocksWindow();
	}

	@FXML
	void minersScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newAllMinersWindow();
	}

	@FXML
	void riddlesScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newRiddlesWindow();
	}

	@FXML
	void watchReport(MouseEvent event) {

	}


	protected void closeWindow() {
		((Stage) borderPane.getScene().getWindow()).close();
	}
}