package control;
/**
 * This class represents the Miners & Companies & Messages Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class MinerLogic {
	private static MinerLogic instance;

	public static MinerLogic getInstance() {
		if (instance == null)
			instance = new MinerLogic();
		return instance;
	}
}
