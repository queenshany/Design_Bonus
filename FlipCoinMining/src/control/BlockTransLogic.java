package control;
/**
 * This class represents the Block & Transaction Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class BlockTransLogic {
	private static BlockTransLogic instance;

	public static BlockTransLogic getInstance() {
		if (instance == null)
			instance = new BlockTransLogic();
		return instance;
	}
}
