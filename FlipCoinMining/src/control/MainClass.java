package control;

import boundary.ViewLogic;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This MainClass object - represents the program runner
 **/
public class MainClass extends Application{

	public static void main(String[] args) {
		BlockTransLogic.getInstance().setIrrelevantTransactions();
		LotteryLogic.getInstance().performLottery();
		launch(args);
		
	}
	public void start(Stage primaryStage) {
		ViewLogic.initUI();
	}

}
