package control;
/**
 * This class represents the Wallet Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class WalletLogic {
	private static WalletLogic instance;

	public static WalletLogic getInstance() {
		if (instance == null)
			instance = new WalletLogic();
		return instance;
	}
}
