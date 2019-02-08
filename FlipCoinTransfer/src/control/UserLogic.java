package control;
/**
 * This class represents the Users & Messages Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class UserLogic {
	private static UserLogic instance;

	public static UserLogic getInstance() {
		if (instance == null)
			instance = new UserLogic();
		return instance;
	}
}
