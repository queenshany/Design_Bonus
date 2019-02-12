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
//		TransLogic.getInstance().setIrrelevantTransactions();
//		backup.start();
<<<<<<< HEAD
//
		// TransLogic.getInstance().setIrrelevantTransactions();
//		backup.start();
=======
		// TransLogic.getInstance().setIrrelevantTransactions();
	//	backup.start();
>>>>>>> d25ba2fb8f803dbe8ba0b7e48e0bc402f5a10503
		launch(args);
//		backup.stop();

	}

	public void start(Stage primaryStage) {
		ViewLogic.initUI();
	}

}
