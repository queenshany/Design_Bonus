package control;

import boundary.ViewLogic;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This MainClass object - represents the program runner
 **/
public class MainClass extends Application{

	private static Thread backup = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 * 60 * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Communication.getInstance().exportTransactionsToJSON();
			}
		}
	});

	public static void main(String[] args) {
<<<<<<< HEAD
//		TransLogic.getInstance().setIrrelevantTransactions();
//		backup.start();
=======
		// TransLogic.getInstance().setIrrelevantTransactions();
		backup.start();
>>>>>>> 1946080e29316a995bcd61e945d5c7b98b23d484
		launch(args);
//		backup.stop();

	}

	public void start(Stage primaryStage) {
		ViewLogic.initUI();
	}

}
