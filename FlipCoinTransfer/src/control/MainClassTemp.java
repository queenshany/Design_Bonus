package control;

import entity.Item;

/**
 * This MainClass object - represents the program runner
 **/
public class MainClassTemp{

	private static ItemLogic il = new ItemLogic();
	private static RecLogic rl = new RecLogic();
	private static TransLogic tl = new TransLogic();
	private static UserLogic ul = new UserLogic();
	private static WalletLogic wl = new WalletLogic();
	
	public static void main(String[] args) {
		
		il.insertItem(new Item(8, "j", "h", "h", 8, 7, 1, "A1A1A1", "A11"));
	}

}
