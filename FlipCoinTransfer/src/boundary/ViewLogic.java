
package boundary;

import java.io.IOException;

import java.net.URL;
import java.util.Optional;

import control.SysData;
import entity.User;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Class ViewLogic ~ manages the windows in the system
 * 
 * @author ID: 205791056
 * @author ID: 205806128
 */
public class ViewLogic {
	// ------------------------------ Variables ------------------------------
	protected static final Rectangle2D FULL_SCREEN = Screen.getPrimary().getBounds();
	protected static final Rectangle2D VISIBLE_SCREEN = Screen.getPrimary().getVisualBounds();
//	protected static ProductsController productScreen;

	protected static User currentUser;
	protected static SysData sysData = control.SysData.getInstance();

	// ------------------------------ Methods ------------------------------
	/**
	 * this method starts the windows in the system
	 */
	public static void initUI() {
		newLoginWindow();
	}

	/**
	 * this method manages the window properties
	 * @param fxmlLocation
	 * @param stage
	 * @param prefWidth
	 * @param prefHeight
	 * @param minWidth
	 * @param minHeight
	 * @param maxWidth
	 * @param maxHeight
	 * @param resizable
	 * @param title
	 * @param waitFor
	 */
	protected static void newWindow(URL fxmlLocation, Stage stage, Double prefWidth,
			Double prefHeight, Double minWidth, Double minHeight, Double maxWidth,
			Double maxHeight, boolean resizable, String title, boolean waitFor) {
		//
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(fxmlLocation);
					Parent root = loader.load();
					Scene scene;

					if (prefWidth == null || prefHeight == null)
						scene = new Scene(root);
					else
						scene = new Scene(root, prefWidth, prefHeight);

					Image image = new Image("rsc/flipcoinLogo.png");
					stage.getIcons().setAll(image);

					stage.setScene(scene);

					if (minWidth != null)
						stage.setMinWidth(minWidth);
					if (minHeight != null)
						stage.setMinHeight(minHeight);
					if (maxWidth != null)
						stage.setMaxWidth(maxWidth);
					if (maxHeight != null)
						stage.setMaxHeight(maxHeight);

					stage.setResizable(resizable);

					if (title != null && !title.isEmpty() && !title.trim().isEmpty())
						stage.setTitle(title);

					if (waitFor)
						stage.initModality(Modality.APPLICATION_MODAL);

					stage.showAndWait();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ------------------------------ Login ------------------------------
	/**
	 * Open Login Window
	 */
	protected static void newLoginWindow() {
		Stage stage = new Stage();

		newWindow(ViewLogic.class.getResource("Login.fxml"),
				stage,
				null, null, null, null, null, null,
				false,
				"Welcome to FlipCoin Transfer",
				false);
	}

	// ------------------------------ Admin ------------------------------
	/**
	 * Open Admin Main Window
	 */
	protected static void newAdminWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("MainAdminScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Admin",
				false);
	}

	// ------------------------------ Employee ------------------------------
	/**
	 * Open Employee Main Window
	 */
	protected static void newEmployeeWindow() {
		Stage stage = new Stage();
//		stage.setMaximized(true);
		setStage(stage);


		newWindow(ViewLogic.class.getResource("MainEmployeeScreen.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Employee",
				false);
	}


	// ------------------------------ User ------------------------------
	/**
	 * Open User Main Window
	 */
	protected static void newUserWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("MainUserScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"User",
				false);
	}


	// ------------------------------ Registration ------------------------------
	/**
	 * Open Registration Window
	 */
	protected static void newRegistrationWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("Registration.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Registration",
				false);
	}


	// ------------------------------ Search Page ------------------------------
	/**
	 * Open Search Page Window
	 */
	protected static void newSearchPageWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("SearchPage.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Search Page",
				false);
	}


	// ------------------------------ Settings ------------------------------
	/**
	 * Open Settings Window
	 */
	protected static void newSettingsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("SettingsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Settings",
				false);
	}
	
	// ------------------------------ Approve Recommendations ------------------------------
	/**
	 * Open Approve Window
	 */
	protected static void newApproveRecWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ApproveRecScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Recommendations",
				false);
	}


	// ------------------------------ Parameters ------------------------------
	/**
	 * Open Parameters Window
	 */
	protected static void newParametersWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ParametersScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Parameters",
				false);
	}
	
	
	// ------------------------------ Parameters (Admin) ------------------------------
	/**
	 * Open Parameters Window
	 */
	protected static void newAdminParametersWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ParametersAdmin.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Parameters",
				false);
	}



	// ------------------------------ Transactions ------------------------------
	/**
	 * Open Transactions Window
	 */
	protected static void newTransactionsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("TransactionsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Transactions",
				false);
	}
	
	// ------------------------------ Charger ------------------------------
	/**
	 * Open Charge Window
	 */
	protected static void newChargerWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ChargerScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Charge Money",
				false);
	}


	// ------------------------------ Categories ------------------------------
	/**
	 * Open Categories Window
	 */
	protected static void newCategoriesWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("CategoriesScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Categories",
				false);
	}
	
	// ------------------------------ Categories (Admin) ------------------------------
	/**
	 * Open Categories Window
	 */
	protected static void newAdminCategoriesWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("CategoriesAdmin.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Categories",
				false);
	}




	// ------------------------------ All Details ------------------------------
	/**
	 * Open All Details Window
	 */
	protected static void newDetailsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("AllDetailsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Details",
				false);
	}



	// ------------------------------ Bitcoin Knots ------------------------------
	/**
	 * Open Bitcoin Knots Window
	 */
	protected static void newBitcoinKnotsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("BitcoinKnots.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Bitcoin Knots",
				false);
	}



	// ------------------------------ Bitcoin Space ------------------------------
	/**
	 * Open Bitcoin Space Window
	 */
	protected static void newBitcoinSpaceWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("BitcoinSpace.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Bitcoin Space",
				false);
	}




	// ------------------------------ Email ------------------------------
	/**
	 * Open Email Window
	 */
	protected static void newEmailWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("EmailScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Email",
				false);
	}




	// ------------------------------ Create Recommendation ------------------------------
	/**
	 * Open Create Recommendation Window
	 */
	protected static void newCreateRecommendationWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("CreateRecommendationScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Create Recommendation",
				false);
	}


	// ------------------------------ View Recommendation ------------------------------
	/**
	 * Open View Recommendation Window
	 */
	protected static void newViewRecommendationWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ViewRecommendationScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"View Recommendation",
				false);
	}

	
	// ------------------------------ Edit Recommendation ------------------------------
		/**
		 * Open Edit Recommendation Window
		 */
		protected static void newEditRecommendationWindow() {
			Stage stage = new Stage();
			setStage(stage);


			newWindow(ViewLogic.class.getResource("EditRecScreen.fxml"),
					stage,
					null, null,	null, null,	null, null,
					false,
					"Edit Recommendation",
					false);
		}


	// ------------------------------ Employee Or User  ------------------------------
		/**
		 * Open Window
		 */
		protected static void newEmployeeOrUserWindow() {
			Stage stage = new Stage();
			setStage(stage);


			newWindow(ViewLogic.class.getResource("EmployeeOrUserScreen.fxml"),
					stage,
					null, null,	null, null,	null, null,
					false,
					"",
					false);
		}


	// ------------------------------ Products ------------------------------
	/**
	 * Open Products Window
	 */
	protected static void newProductsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ProductsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Products",
				false);
	}



	// ------------------------------ Wallets ------------------------------
	/**
	 * Open Wallets Window
	 */
	protected static void newWalletsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("UserWalletScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Categories",
				false);
	}


	// ------------------------------ Add New Product ------------------------------
	/**
	 * Open Add New Product Window
	 */
	protected static void newAddProductWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("AddNewProductScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Add New Product",
				false);
	}

	// ------------------------------ Edit Product ------------------------------
	/**
	 * Open Add New Product Window
	 */
	protected static void newEditProductWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("EditProductScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Edit Product",
				false);
	}

	
	// ------------------------------ Expand Space ------------------------------
	/**
	 * Open Expand Space Window
	 */
	protected static void newExpandSpaceWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ExpandSpaceScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Edit Bitcoin Space",
				false);
	}
	
	
	// ------------------------------ Expand Knots ------------------------------
	/**
	 * Open Expand Knots Window
	 */
	protected static void newExpandKnotsWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ExpandKnotsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Edit Bitcoin Knots",
				false);
	}
	
	// ------------------------------ Manage Employee ------------------------------
	/**
	 * Open Manage Employees Window
	 */
	protected static void newManageEmployeesWindow() {
		Stage stage = new Stage();
		setStage(stage);


		newWindow(ViewLogic.class.getResource("ManageEmployeeScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Employees Management",
				false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	





	/**
	 * Open Admin Match Creation Window
	 */
	protected static void newAdminMatchCreationWindow() {
		Stage stage = new Stage();


		newWindow(ViewLogic.class.getResource("AdminMatchCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Match Form",
				true);
	}

	/**
	 * Open Admin Match Update Window
	 */
	protected static void newAdminMatchUpdateWindow() {
		Stage stage = new Stage();


		newWindow(ViewLogic.class.getResource("AdminMatchUpdate.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Update Match",
				true);
	}

	//============================================================================
	//================================ Admin Stadium =============================
	/**
	 * Open Admin Stadium Window
	 */
	protected static void newAdminStadiumWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("AdminStadium.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Stadium Settings",
				false);
	}

	/**
	 * Open Admin Staium Creation Window
	 */
	protected static void newStadiumCreationWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//ViewLogic.newAdminStadiumWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminStadiumCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Stadium Form",
				true);
	}

	/**
	 * Open Admin Staium Update Window
	 */
	protected static void newStadiumUpdateWindow() {

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminStadiumUpdate.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Update Stadium Form",
				true);
	}
	//==================================================================================
	//================================== Admin Player ==================================

	/**
	 * Open Admin Player Window
	 */
	protected static void newAdminPlayerWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("AdminPlayer.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Player Settings",
				false);
	}

	/**
	 * Open Admin Player Creation Window
	 */
	protected static void newPlayerCreationWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//newAdminPlayerWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminPlayerCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Player Form",
				true);
	}
	/**
	 * Open Admin Player Update Window
	 */
	protected static void newPlayerUpdateWindow() {

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//newAdminPlayerWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminPlayerUpdate.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Update Player Form",
				true);
	}

	//==================================================================================
	// ================================== Admin Coach ==================================
	/**
	 * Open Admin Coach Window
	 */
	protected static void newAdminCoachWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("AdminCoach.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Coach Settings",
				false);
	}
	/**
	 * Open Admin Coach Creation Window
	 */
	protected static void newAdminCoachCreationWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminCoachCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Coach Form",
				true);
	}
	/**
	 * Open Admin Coach Update Window
	 */
	protected static void newCoachUpdateWindow() {

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminCoachUpdate.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Update Coach Form",
				true);
	}

	//==================================================================================
	// ================================== Admin Trophy ==================================
	/**
	 * Open Admin Trophy Window
	 */
	protected static void newAdminTrophyWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);


		newWindow(ViewLogic.class.getResource("AdminTrophy.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Trophy Settings",
				false);
	}
	/**
	 * Open Admin Trophy Creation Window
	 */
	protected static void newTrophyCreationWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//newAdminTrophyWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminTrophyCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Trophy Form",
				true);
	}


	//==================================================================================
	// ================================== Admin Recep ==================================

	/**
	 * Open Admin Receptionist Window
	 */
	protected static void newAdminRecWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);


		newWindow(ViewLogic.class.getResource("AdminReceptionist.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Receptionist Settings",
				false);
	}

	/**
	 * Open Admin Receptionist Creation Window
	 */
	protected static void newRecCreationWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//newAdminRecWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminReceptionistCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Receptionist Form",
				true);
	}

	/**
	 * Open Admin Receptionist Update Window
	 */
	protected static void newRecUpdateWindow() {		
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminReceptionistUpdate.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Update Receptionist Form",
				true);
	}
	//==================================================================================
	// ================================== Admin Customer ==================================
	/**
	 * Open Admin Customer Window
	 */
	protected static void newAdminCusWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("AdminCustomer.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Customer Settings",
				false);
	}
	/**
	 * Open Admin Sub Creation Window
	 */
	protected static void newAdminCusSubWindow() {
		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//	newAdminCusWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("AdminCusSubscriptionCreation.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Subscription Form",
				true);
	}
	//==================================================================================
	// ================================== Admin Team ==================================
	/**
	 * Open Admin Team Window
	 */
	protected static void newAdminTeamWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("AdminTeam.fxml"),
				stage,
				null,null, null, null, null, null,
				true,
				"Team Settings",
				false);
	}

	/**
	 * Open Admin Team Creation Window
	 */
	protected static void newAdminTeamCreatinWindow() {

		Stage stage = new Stage();

		newWindow(ViewLogic.class.getResource("AdminCreationTeam.fxml"),
				stage,
				null,null, null, null, null, null,
				false,
				"Add New Team Form",
				true);

	}

	/**
	 * Open Admin Team Details Window
	 */
	//	protected static void newAdminTeamDetailsWindow() {
	//
	//		Stage stage = new Stage();
	//		
	//		stage.setMaximized(true);
	//		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

	//			@Override
	//			public void handle(WindowEvent event) {
	//				adminTeamController.setPlayersTable();
	//				adminTeamController.setTeamTable();
	//				adminTeamController.setSuperPlayersTable();
	//				stage.close();
	//				
	//			}
	//		});


	//==================================================================================
	// ------------------------------ Coach ------------------------------
	/**
	 * Open Coach Main Window
	 */
	protected static void newCoachWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("CoachMain.fxml"),
				stage,
				null, null, null, null, null, null,
				true,
				"Coach",
				false);
	}
	// ------------------------------ Receptionist ------------------------------
	/**
	 * Open Receptionist Main Window
	 */
	protected static void newRecepWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("ReceptionistMain.fxml"),
				stage,
				null, null, null, null, null, null,
				true,
				"Receptionist",
				false);
	}
	/**
	 * Open Customer Creation Window
	 */
	protected static void newNewCustomerCreation() {

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//ViewLogic.newRecepWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("NewCustomerCreation.fxml"),
				stage,
				null, null, null, null, null, null,
				false,
				"Add New Customer Form",
				true);
	}

	/**
	 * Open Sub Creation Window
	 */
	protected static void newNewSubCreation() {

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//	ViewLogic.newRecepWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("NewSubscriptionCreation.fxml"),
				stage,
				null, null, null, null, null, null,
				false,
				"Add New Subscription Form",
				true);
	}

	/**
	 * Open Customer Update Window
	 */
	protected static void newUpdateCustomerData(){

		Stage stage = new Stage();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				stage.close();
				//ViewLogic.newRecepWindow();
			}
		});

		newWindow(ViewLogic.class.getResource("UpdateCustomerData.fxml"),
				stage,
				null, null, null, null, null, null,
				false,
				"Update Customer Data Form",
				true);
	}

	// ------------------------------ Customer ------------------------------
	/**
	 * Open Customer Main Window
	 */
	protected static void newCusWindow() {
		Stage stage = new Stage();
		stage.setMaximized(true);
		setStage(stage);

		newWindow(ViewLogic.class.getResource("CustomerMain.fxml"),
				stage,
				null, null, null, null, null, null,
				true,
				"Customer",
				false);
	}


	private static void setStage(Stage stage) {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				event.consume();
				//if (saveOnExit())
					stage.close();

			}
		});
	}
	// ----------------------------------------------------------------------
	/**
	 * this method is responsible for exiting the system clicking X
	 * @return true if system is serialized
	 */
	private static boolean saveOnExit() {
		//		Sound.playLogoutSound();
		Alert alert = new Alert(AlertType.WARNING);

		ButtonType buttonTypeYes;
		ButtonType buttonTypeNo;
		ButtonType buttonTypeCancel;

		buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
		buttonTypeNo = new ButtonType("No", ButtonData.NO);
		buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.setHeaderText("Would you like to Save Changes and Exit?");

		alert.setContentText("");

		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

		alert.setTitle("Save Changes");

		Optional<ButtonType> answer = alert.showAndWait();
		//
		//		//ButtonType answer = alert.getResult();
		//		if (answer.get().getButtonData() == ButtonData.CANCEL_CLOSE) {
		//			return false;
		//		}
		//		else if (answer.get().getButtonData() == ButtonData.YES) {
		//			//Serialize
		//			try {
		//				if (ViewLogic.sysData.serialize()) {
		//				
		//					Validation.info("Data Serialized Successfully!", "DataBase.ser is saved in the project's folder.");
		//					
		//					System.out.println("Serialized ViewLogic");
		//				}
		//				else {
		//				
		//					Validation.alert("Data Was Not Serialized!");
		//					System.out.println("Not Serialized");
		//				}
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//			//System.out.println("Serialized ViewLogic");
		//		}
		//		else {
		//			
		//			Validation.alert("Data Was Not Serialized!");
		//			
		//			System.out.println("Not Serialized");
		//		}
		return true;
		//	}
	}
}
