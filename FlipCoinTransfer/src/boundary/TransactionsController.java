package boundary;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

import control.RecLogic;
import control.SysData;
import control.TransLogic;
import control.Validation;
import control.WalletLogic;
import entity.User;
import entity.Wallet;
import entity.WalletBitcoinSpace;
import entity.Item;
import entity.ItemInTransaction;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.E_Status;
import utils.E_TransType;

public class TransactionsController {

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
	private TabPane tabPane;

	@FXML
	private Tab newPT;

	@FXML
	private AnchorPane pane1;

	@FXML
	private ComboBox<User> usersCombo;

	@FXML
	private ComboBox<Item> productsCombo;

	@FXML
	private TextField amountText;

	@FXML
	private Button addButton;

	@FXML
	private TableView<Item> table;

	@FXML
	private TableColumn<Item, Integer> itemID;

	@FXML
	private TableColumn<Item, String> sellerAD;

	@FXML
	private TableColumn<Item, String> sellerSig;

	@FXML
	private TableColumn<Item, Integer> quantity;

	@FXML
	private Label lable;

	@FXML
	private Label price;

	@FXML
	private Label btc;

	@FXML
	private Button createButton;

	@FXML
	private Button delettButton;

	@FXML
	private Label errorMassage;

	@FXML
	private Button recButton;

	@FXML
	private TextField feeText;

	@FXML
	private TextField feeText1;

	@FXML
	private ComboBox<Wallet> walletCombo;

	@FXML
	private ScrollPane scroll;

	@FXML
	private TableView<TransactionPay> waitingTable;

	@FXML
	private TableColumn<TransactionPay, Date> creationDate;

	@FXML
	private TableColumn<TransactionPay, Date> executionDate;

	@FXML
	private TableColumn<TransactionPay, String> status;

	@FXML
	private TableColumn<TransactionPay, String> adress;

	@FXML
	private TableColumn<TransactionPay, String> signature;

	@FXML
	private TableView<TransactionPay> confirmTable;

	@FXML
	private TableColumn<TransactionPay, Integer> IDconfirm;

	@FXML
	private TableColumn<TransactionPay, Integer> sizeConfirm;

	@FXML
	private TableColumn<TransactionPay, Date> creationDateConfirm;

	@FXML
	private TableColumn<TransactionPay, String> creating1confirm;

	@FXML
	private TableColumn<TransactionPay, String> creating2confirm;

	@FXML
	private Button confirmButton;

	@FXML
	private Button unButton;

	@FXML
	private ComboBox<Wallet> walletsCombo;

	@FXML
	private Label alertConfrim;

	@FXML
	private Label moneyAlert;

	@FXML
	private DatePicker shippingDate;

	protected User user;

	protected static TransactionPay tranConfirm;

	protected static Item chosenItem;

	private ArrayList<Item> chosenItems = new ArrayList<>();

	//ObservableList<Item> i = FXCollections.observableArrayList();

	public void initialize() {
		btc.setVisible(false);
		price.setText("0");
		//unButton.setVisible(false);

		//Fill the User Combo Box
		ArrayList<User> users = new ArrayList<User>();
		users= control.UserLogic.getInstance().getUsers();

		usersCombo.getItems().addAll(users);

		ObservableList<User> us= FXCollections.observableArrayList(users);
		us.remove(LoginController.curretUser);
		usersCombo.setItems(us);


		//Fill the pay transaction table
		creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		executionDate.setCellValueFactory(new PropertyValueFactory<>("executionDate"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		adress.setCellValueFactory(new PropertyValueFactory<>("destinationAdress"));
		signature.setCellValueFactory(new PropertyValueFactory<>("destinationSignature"));

		//i.setAll(chosenItems);

		//	table.setItems(i);
		//Fill the Pay transactions of the current user
		getPayTransactions();

		//Fill the wallets comboBox of the current user
		ObservableList<Wallet> w=getWallets();
		walletCombo.setItems(w);
		walletsCombo.setItems(w);

		//Chosen Products
		itemID.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		sellerAD.setCellValueFactory(new PropertyValueFactory<>("sellerAddress"));
		sellerSig.setCellValueFactory(new PropertyValueFactory<>("sellerSignature"));

		//		ArrayList<Item> i = new ArrayList<Item>();
		//		i = control.ItemLogic.getInstance().getItems();
		//		ObservableList<Item> pro = FXCollections.observableArrayList();
		//		pro.addAll(i);
		//		table.setItems(pro);


		//Fill Confirm Table
		IDconfirm.setCellValueFactory(new PropertyValueFactory<>("transID"));
		sizeConfirm.setCellValueFactory(new PropertyValueFactory<>("size"));
		creationDateConfirm.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
		creating1confirm.setCellValueFactory(new PropertyValueFactory<>("creatingAddress"));
		creating2confirm.setCellValueFactory(new PropertyValueFactory<>("creatingSignature"));

		//Fill the confirm transactions of the current user
		getConfrimTransactions();
	} 


	//Fill the wallet comboBox
	@FXML
	public ObservableList<Wallet> getWallets() {

		ObservableList<Wallet> w = FXCollections.observableArrayList();
		w.setAll(WalletLogic.getInstance().getWalletsOfUser(LoginController.curretUser));
		return w;
		//ArrayList<Wallet> wallets = new ArrayList<Wallet>();
		//wallets= control.WalletLogic.getInstance().getWallets();
		//		for(Wallet wt : wallets)
		//		{
		//			if(wt.getUserAddress().equalsIgnoreCase(LoginController.curretUser.getPublicAddress())
		//					&& wt.getUserSignature().equalsIgnoreCase
		//					(LoginController.curretUser.getSignature()))
		//				w.add(wt);
		//		}			

		//	 	    walletsCombo.setItems(w);
	}

	private void setProductsTable(){
		ObservableList<Item> it = FXCollections.observableArrayList(chosenItems);
		table.setItems(it);
		table.refresh();

	}
	@FXML
	void deleteProduct(ActionEvent event) {
		chosenItem = table.getSelectionModel().getSelectedItem();
		if (chosenItem != null) {
			chosenItems.remove(chosenItem);
			setProductsTable();
			price.setText(String.valueOf(calcTotalProdPrice()) + "BTC");
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Please Select a Product to remove");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
	}
	private double calcTotalProdPrice() {
		double price = 0;
		for (Item i : chosenItems) {
			price += (i.getPrice()*i.getQuantity());
		}
		return price;
		//this.price.setText(String.valueOf(price) + "BTC");
	}

	//Fill the product combo according to the chosen user

	@FXML
	void productsOfUser(ActionEvent event) {

		//		usersCombo.setDisable(true);
		ObservableList<Item> I= FXCollections.observableArrayList();
		ArrayList<Item> Items = control.ItemLogic.getInstance().getItems();
		if (usersCombo.getSelectionModel()!=null) {
			for(Item itms : Items)
			{
				if(itms.getSellerAddress().equalsIgnoreCase(usersCombo.getSelectionModel().getSelectedItem().getPublicAddress())
						&& itms.getSellerSignature().equalsIgnoreCase
						(usersCombo.getSelectionModel().getSelectedItem().getSignature()))
					I.add(itms);
			}			

			productsCombo.setItems(I);
		}
	}


	public void getPayTransactions(){

		ObservableList<TransactionPay> t= FXCollections.observableArrayList();
		ArrayList<TransactionPay> pay = control.TransLogic.getInstance().getPayTransOfUserCreated(LoginController.curretUser);
		for(TransactionPay tp : pay)
			if (tp.getStatus().equals(E_Status.Pending) || tp.getStatus().equals(E_Status.Waiting))
				t.add(tp);
		waitingTable.setItems(t);	   
		waitingTable.refresh();
	}



	public void getConfrimTransactions(){

		ObservableList<TransactionPay> t= FXCollections.observableArrayList();
		ArrayList<TransactionPay> confirm = TransLogic.getInstance().getPayTransOfUserDestination(LoginController.curretUser);

		for(TransactionPay tp : confirm)
			if (tp.getStatus().equals(E_Status.Pending))
				t.add(tp);

		confirmTable.setItems(t);	   
		confirmTable.refresh();
	}

	@FXML
	private boolean chosenConfrimTrans() {
		if (confirmTable.getSelectionModel().getSelectedItem() != null) {
			tranConfirm = confirmTable.getSelectionModel().getSelectedItem();
			return true;
		}
		return false;
	}

	@FXML
	void NewConfirmTransaction(ActionEvent event) {
		double fee = 0 ;
		if (chosenConfrimTrans()) {
			if (walletsCombo.getSelectionModel().getSelectedItem() != null && WalletLogic.getInstance().getWalletsSpaceOfUser(LoginController.curretUser).contains(walletsCombo.getSelectionModel().getSelectedItem())) {
				WalletBitcoinSpace w = WalletLogic.getInstance().getWalletsSpaceOfUser(LoginController.curretUser).
						get(WalletLogic.getInstance().getWalletsSpaceOfUser(LoginController.curretUser).
								indexOf(walletsCombo.getSelectionModel().getSelectedItem()));
				if (w.getTransSize() < tranConfirm.getSize()) {
					alertConfrim.setVisible(true);
					alertConfrim.setText("Trans Size is too big. Choose a different wallet.");
				}
			}
			else if (walletsCombo.getSelectionModel() != null && SysData.getInstance().getLastVersionParams().getTransSizeFree() > tranConfirm.getSize()) {
				alertConfrim.setVisible(false);
				if (walletsCombo.getSelectionModel().getSelectedItem() != null) {
					alertConfrim.setVisible(false);

					if (shippingDate.getValue() != null) {
						alertConfrim.setVisible(false);
						if (shippingDate.getValue().isAfter(LocalDate.now())) {
							alertConfrim.setVisible(false);
							try {
								alertConfrim.setVisible(false);
								fee = Double.parseDouble(feeText.getText());
								if (fee > 0) {
									alertConfrim.setVisible(false);
									if (WalletLogic.getInstance().calcPendingAmount(walletsCombo.getSelectionModel().getSelectedItem().getUniqueAddress(), tranConfirm.getPayValue()-fee)) {
										alertConfrim.setVisible(false);
										TransactionConfirm tc = new TransactionConfirm(
												TransLogic.getInstance().getTransID(), 
												null,
												tranConfirm.getSize(),
												Date.valueOf(LocalDate.now()),
												null,
												fee,
												E_Status.Pending,
												LoginController.curretUser.getPublicAddress(),
												LoginController.curretUser.getSignature(),
												tranConfirm.getCreatingAddress(),
												tranConfirm.getCreatingSignature(),
												walletsCombo.getSelectionModel().getSelectedItem().getUniqueAddress(),
												true,
												Date.valueOf(shippingDate.getValue()),
												tranConfirm.getTransID());
										control.TransLogic.getInstance().insertTransConfirm(tc);

										getConfrimTransactions();
										getPayTransactions();
										Alert alert = new Alert(AlertType.CONFIRMATION);
										alert.setTitle("Transaction Created Successfully");
										alert.setContentText(tc + " was created successfully");
										alert.initModality(Modality.APPLICATION_MODAL);
										alert.showAndWait();

									}else {
										alertConfrim.setVisible(true);
										alertConfrim.setText("There's not enough money in the wallet");
									}
								}
								else {
									alertConfrim.setVisible(true);
									alertConfrim.setText("Fee must be a Positive number.");
								}
							}catch(NumberFormatException e) {
								alertConfrim.setVisible(true);
								alertConfrim.setText("Fee must be a number.");
							}
						}else {
							alertConfrim.setVisible(true);
							alertConfrim.setText("Shipping date must be after today.");
						}
					}else {
						alertConfrim.setVisible(true);
						alertConfrim.setText("Please enter a shipping date");
					}
				}
				else {
					alertConfrim.setVisible(true);
					alertConfrim.setText("Please choose a wallet");
				}
			}else {
				alertConfrim.setVisible(true);
				alertConfrim.setText("Trans Size is too big. Choose a different wallet.");
			}
		}else {
			alertConfrim.setVisible(true);
			alertConfrim.setText("Please choose a transaction to confirm");
		}
	}

	private int calcPaySize() {
		int sizeA = 0;
		for(Item i : chosenItems) {
			sizeA += i.getQuantity();
		}

		if (sizeA/chosenItems.size() == 0)
			return 1;

		return sizeA/chosenItems.size();
	}

	@FXML
	void NewPayTransaction(ActionEvent event) {
		double fee = 0;
		double productsPrice = calcTotalProdPrice();
		if (!chosenItems.isEmpty()) {
			if (!feeText1.getText().isEmpty()) {
				try {
					fee = Double.parseDouble(feeText1.getText());
					if (fee <= 0) {
						throw new NumberFormatException();
					}
					else {
						if (walletCombo.getSelectionModel().getSelectedItem() != null) {
							if (WalletLogic.getInstance().calcPendingAmount(walletCombo.getSelectionModel().getSelectedItem().getUniqueAddress(), -(productsPrice+fee))) {

								TransactionPay tp = new TransactionPay(TransLogic.getInstance().getTransID(),
										null,
										calcPaySize(), 
										Date.valueOf(LocalDate.now()),
										null,
										fee, 
										E_Status.Pending,
										LoginController.curretUser.getPublicAddress(),
										LoginController.curretUser.getSignature(),
										chosenItems.get(0).getSellerAddress(),
										chosenItems.get(0).getSellerSignature(),
										walletCombo.getSelectionModel().getSelectedItem().getUniqueAddress(),
										productsPrice);

								control.TransLogic.getInstance().insertTransPay(tp);

								for (Item it : chosenItems) {
									control.ItemLogic.getInstance().insertItemIntoTrans(new ItemInTransaction(it.getCatalogNumber(), tp.getTransID(), it.getQuantity()));
								}

								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setTitle("Transaction Created Successfully");
								alert.setContentText(tp + " was created successfully");
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.showAndWait();


							}else {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Money Error");
								alert.setContentText("You don't have enough money. Please load money");
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.showAndWait();
							}
						}else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Wallet Error");
							alert.setContentText("Please select a wallet to pay");
							alert.initModality(Modality.APPLICATION_MODAL);
							alert.showAndWait();
						}
					}
				}catch(NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Fee Error");
					alert.setContentText("Fee must be a Positive number");
					alert.initModality(Modality.APPLICATION_MODAL);
					alert.showAndWait();
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fee Error");
				alert.setContentText("Please enter a fee to pay");
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Items Error");
			alert.setContentText("Please choose items to buy");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}

		networkStatus.setText(control.SysData.getInstance().getMode().toString());

	}

	@FXML
	void addToTable(ActionEvent event) {
		int q = 0;
		if (usersCombo.getSelectionModel().getSelectedItem() != null) {
			if (productsCombo.getSelectionModel().getSelectedItem() != null) {
				if (!amountText.getText().isEmpty()) {
					try {
						q = Integer.parseInt(amountText.getText());
						if (q <= 0) {
							throw new NumberFormatException();
						}
						else if (q <= productsCombo.getSelectionModel().getSelectedItem().getQuantity()) {

							Item it = new Item(productsCombo.getSelectionModel().getSelectedItem().getCatalogNumber(),
									productsCombo.getSelectionModel().getSelectedItem().getItemName(),
									productsCombo.getSelectionModel().getSelectedItem().getImage(),
									productsCombo.getSelectionModel().getSelectedItem().getDescription(),
									productsCombo.getSelectionModel().getSelectedItem().getPrice(),
									q,
									productsCombo.getSelectionModel().getSelectedItem().getCatalogNumber(),
									productsCombo.getSelectionModel().getSelectedItem().getSellerAddress(),
									productsCombo.getSelectionModel().getSelectedItem().getSellerSignature());

							boolean isSameSeller = true;

							System.out.println(it);
							if (!chosenItems.isEmpty()) {
								for (int i=0 ; i < chosenItems.size() ; i++) {
									if (!it.getSellerAddress().equalsIgnoreCase(chosenItems.get(i).getSellerAddress())
											&& !it.getSellerSignature().equalsIgnoreCase(chosenItems.get(i).getSellerSignature())) {
										isSameSeller = false;
									}
								}
							}
							if (isSameSeller) {
								if (chosenItems.contains(it)) {
									chosenItems.get(chosenItems.indexOf(it)).setQuantity(q);
								}else {
									chosenItems.add(it);
								}
								setProductsTable();
								price.setText(String.valueOf(calcTotalProdPrice()) + "BTC");
							}
							else {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Seller Error");
								alert.setContentText("Items must be by the same seller");
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.showAndWait();
							}
						}else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Quantity Error");
							alert.setContentText("Quantity must be smaller or equal to Product quantity");
							alert.initModality(Modality.APPLICATION_MODAL);
							alert.showAndWait();
						}
					}catch(NumberFormatException e) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Quantity Error");
						alert.setContentText("Quantity must be a Positive number");
						alert.initModality(Modality.APPLICATION_MODAL);
						alert.showAndWait();
					}	
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Quantity Error");
					alert.setContentText("Please enter a quantity");
					alert.initModality(Modality.APPLICATION_MODAL);
					alert.showAndWait();
				}
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Product Error");
				alert.setContentText("Please select a product");
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Seller Error");
			alert.setContentText("Please select a seller");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}
	}

	@FXML
	void switch1(MouseEvent event) {

	}

	@FXML
	void switch2(MouseEvent event) {

	}

	@FXML
	void switch3(MouseEvent event) {

	}


	@FXML
	void unconfirmed(ActionEvent event) {

	}

	@FXML
	void viewRecommendations(ActionEvent event) {
		//ViewLogic.newViewRecommendationWindow();
		if (LoginController.curretUser == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("User is null");
			alert.setContentText("Please select user");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
		}else {
			JFrame reportFrame = RecLogic.getInstance().produceViewRecommendationsReport(LoginController.curretUser);
			reportFrame.setVisible(true);
		}
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
	void transactionsScreen(MouseEvent event) {
		closeWindow();
		ViewLogic.newTransactionsWindow();
	}

	@FXML
	void backHome(MouseEvent event) {
		closeWindow();
		ViewLogic.newUserWindow();
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

