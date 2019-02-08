package control;
/**
 * This class represents the Lottery & Bonus Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class LotteryLogic {
	private static LotteryLogic instance;

	public static LotteryLogic getInstance() {
		if (instance == null)
			instance = new LotteryLogic();
		return instance;
	}
}
