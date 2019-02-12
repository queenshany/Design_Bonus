package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.RandomStringUtils;

import entity.Consts;
import entity.Message;
import entity.Transaction;

/**
 * This class represents the Sys Management: Parameters, Sign In
 * @author Shany Klein & Ofri Kokush
 *
 */
public class SysData {

	private static SysData instance;

	public static SysData getInstance() {
		if (instance == null)
			instance = new SysData();
		return instance;
	}

	// ***************************** GENERAL METHODS *****************************
	/**
	 * This method generates Random Strings for addresses and stuff
	 * @param length
	 * @return the string
	 */
	public String generateRandomStrings(int length) {
		return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
	}

	
}
