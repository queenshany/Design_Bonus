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
				Communication.exportTransactionsToJSON();
			}
		}
	});

	public static void main(String[] args) {
		TransLogic.getInstance().setIrrelevantTransactions();
		backup.start();
		launch(args);
		backup.stop();

	}

	public void start(Stage primaryStage) {
		ViewLogic.initUI();
	}

}
