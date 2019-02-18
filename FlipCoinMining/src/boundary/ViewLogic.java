
package boundary;

import java.io.IOException;

import java.net.URL;
import java.util.Optional;


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

	protected static String currentUserID;

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

		newWindow(ViewLogic.class.getResource("LoginScreen.fxml"),
				stage,
				null, null, null, null, null, null,
				false,
				"Welcome to FlipCoin Mining",
				false);
	}

	// ------------------------------ Admin ------------------------------
	/**
	 * Open Admin Main Window
	 */
	protected static void newAdminWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("MainAdminScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Admin",
				false);
	}



	// ------------------------------ User ------------------------------
	/**
	 * Open User Main Window
	 */
	protected static void newUserWindow() {
		Stage stage = new Stage();
//		setStage(stage);


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
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("RegistrationScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Registration",
				false);
	}


	// ------------------------------ Add Riddles ------------------------------
	/**
	 * Open Add Riddles Window
	 */
	protected static void newAddRiddlesWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("AddRiddlesScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Add Riddles",
				false);
	}
	
	// ------------------------------ Edit Riddles ------------------------------
		/**
		 * Open Edit Riddles Window
		 */
		protected static void newEditRiddlesWindow() {
			Stage stage = new Stage();
//			setStage(stage);


			newWindow(ViewLogic.class.getResource("EditRiddleScreen.fxml"),
					stage,
					null, null,	null, null,	null, null,
					false,
					"Edit Riddles",
					false);
		}
		
		
		// ------------------------------ Edit Lottery ------------------------------
		/**
		 * Open Edit Lottery Window
		 */
		protected static void newEditLotteriesWindow() {
			Stage stage = new Stage();
//			setStage(stage);


			newWindow(ViewLogic.class.getResource("EditLotteryScreen.fxml"),
					stage,
					null, null,	null, null,	null, null,
					false,
					"Edit Lottery",
					false);
		}


	// ------------------------------ Dominant Miner Report ------------------------------
	/**
	 * Open Dominant Miner Report Window
	 */
	protected static void newDominantUserWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("DominantMinerReport.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Generate Report",
				false);
	}


	// ------------------------------ First Solver ------------------------------
	/**
	 * Open First Solver Window
	 */
	protected static void newFirstSolverWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("FirstSolverScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Congratulations",
				false);
	}

	// ------------------------------ Mail Screen ------------------------------
	/**
	 * Open Email Window
	 */
	protected static void newEmailWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("EmailScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Emails",
				false);
	}


	// ------------------------------ Lotteries ------------------------------
	/**
	 * Open Lotteries Window
	 */
	protected static void newLotteriesWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("LotteriesScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Lotteries",
				false);
	}


	// ------------------------------ Management ------------------------------
	/**
	 * Open Management Window
	 */
	protected static void newManagementWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("ManagementScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"All Details",
				false);
	}




	// ------------------------------ Manage Transactions ------------------------------
	/**
	 * Open Manage Transactions Window
	 */
	protected static void newBlocksWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("ManageTransactionsScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Manage Blocks",
				false);
	}



	// ------------------------------ All Miners ------------------------------
	/**
	 * Open Miners Window
	 */
	protected static void newAllMinersWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("MinersTableScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Miners Table",
				false);
	}



	// ------------------------------ Riddles ------------------------------
	/**
	 * Open Riddles Window
	 */
	protected static void newRiddlesWindow() {
		Stage stage = new Stage();
//		setStage(stage);


		newWindow(ViewLogic.class.getResource("RiddlesScreen.fxml"),
				stage,
				null, null,	null, null,	null, null,
				false,
				"Solve Riddles",
				false);
	}



	private static void setStage(Stage stage) {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				event.consume();
				//			if (saveOnExit())
				//				stage.close();

			}
		});
	}

}
