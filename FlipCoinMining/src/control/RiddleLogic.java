package control;
/**
 * This class represents the Riddle & Solution & Level Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class RiddleLogic {
	private static RiddleLogic instance;

	public static RiddleLogic getInstance() {
		if (instance == null)
			instance = new RiddleLogic();
		return instance;
	}
}
