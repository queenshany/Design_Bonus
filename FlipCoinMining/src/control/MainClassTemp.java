package control;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import entity.Block;
import entity.Bonus;
import entity.GetBonus;
import entity.Lottery;
import entity.Message;
import entity.Miner;
import entity.MinerCompany;
import entity.Participant;
import entity.Riddle;
import entity.RiddleLevel;
import entity.Solution;
import entity.SolvedRiddle;
import entity.SystemParams;
import entity.Transaction;
import utils.E_Level;
import utils.E_Status;
import utils.E_Type;

/**
 * This MainClass object - represents the program runner
 **/
public class MainClassTemp{

	private static LotteryLogic ll = new LotteryLogic();
	private static RiddleLogic rl = new RiddleLogic();
	private static BlockTransLogic btl = new BlockTransLogic();
	private static MinerLogic ml = new MinerLogic();
	private static SysData sd = new SysData();

	public static void main(String[] args) {
		//btl.insertBlock(new Block("d", new Date(2019,2,6), new Time(0, 0, 0), 3, "DDD4", "kk"));
		//ll.insertBonus(new Bonus(9,"im a bonus"));
		//ll.insertGetBonus(new GetBonus(1,"kk",9));
		//ll.insertLottery(new Lottery(9, new Date(2019,2,6), 5, 4, 4));
		//ml.insertMessage(new Message(1,"kk","ti","f",new Date(2019,2,6), new Time(0, 0,0)));
		//ml.insertMiner(new Miner("pp", "minerName", "password", "email", 5));
		//ml.insertMinerCompany(new MinerCompany("pp", "minerName", "password", "email", 5, "minerName", "password", "email", "digitalProfit"));
		//ll.insertParticipant(new Participant(1, "kk", true));
		//rl.insertRiddleLevel(new RiddleLevel(80, E_Level.Easy, 6, 8));
		//rl.insertRiddle(new Riddle(9, new Date(2019,2,6), new Time(0, 0, 0), "description", new Date(2019,2,6), new Time(0, 0, 0), E_Status.Irrelevant, 1));
		//rl.insertSolution(new Solution(9, 1, 4));
		//rl.insertSolvedRiddle(new SolvedRiddle("kk", 9, new Date(2019,2,6), new Time(0, 0, 0)));
		//btl.insertTrans(new Transaction(9, 8, E_Type.Confirm, 9, null, null, null));
		//ll.updateBonus(new Bonus(9,"im reeeeaaaaaaalllllllyyyyyyy a bonus"));
		//ll.deleteBonus(new Bonus(9));
		//btl.attachTransToBlock(new Transaction(9, 8, E_Type.Confirm, 9, null, null, null), new Block("d", new Date(2019,2,6), new Time(0, 0, 0), 3, "DDD4", "kk"));
		//ll.updateLottery(new Lottery(9, Date.valueOf(LocalDate.now()), 54, 43, 43));
		//ml.updateMiner(new Miner("pp", "hiii", "ggg", "gf", 5));
		//ml.updateMiner(new MinerCompany("pp", "hiii", "ggg", "gf", 5, "dd", "ssssss", "ssssss", "aaaa"));
		//ml.updateProfit(new Transaction(9, 8, E_Type.Confirm, 18, null, null, null), new Block("d", new Date(2019,2,6), new Time(0, 0, 0), 3, "DDD4", "kk"));
	}

}
