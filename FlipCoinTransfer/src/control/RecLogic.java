package control;
/**
 * This class represents the Recommendation Management in the system: Recommendation, RecommendationFor
 * @author Shany Klein & Ofri Kokush
 *
 */
public class RecLogic {
	private static RecLogic instance;

	public static RecLogic getInstance() {
		if (instance == null)
			instance = new RecLogic();
		return instance;
	}
}
