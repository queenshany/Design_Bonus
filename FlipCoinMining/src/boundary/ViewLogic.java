
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
		stage.setMaximized(true);
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
