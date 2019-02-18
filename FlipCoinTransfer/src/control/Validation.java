package control;

import java.net.MalformedURLException;
import java.net.URL;

import entity.Consts;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Class that contains  methods for validating user input
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Validation {
	/**
	 * This method checks if a name is valid
	 * @param str
	 * @return true if valid, false otherwise
	 */
		public static boolean validName (String str) {
			// checks if the string is valid for name;
			if (!str.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$")) 
				return false;
			return true;
		}

		/**
		 * This method checks if a phone number is valid
		 * @param str
		 * @return true if valid, false otherwise
		 */
		public static boolean validPhone(String phone) {

			String regexStr = "^[0-9]*$";

			if (phone.matches(regexStr) && phone.length() == Consts.PHONE_LENGTH )
				return true;
			return false;
		}

		/**
		 * This method checks if an email address is valid
		 * @param str
		 * @return true if valid, false otherwise
		 */
		public static boolean validEmailAddress(String email) {
			String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
			java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
			java.util.regex.Matcher m = p.matcher(email);
			return m.matches();
		}
		
		/**
		 * This method checks if an int is positive
		 * @param num
		 * @return true if valid, false otherwise
		 */
		public static boolean isPositiveInt(int num) {
			if (num > 0)
				return true;
			return false;
		}
		
		/**
		 * This method checks if a double is positive
		 * @param num
		 * @return true if valid, false otherwise
		 */
		public static boolean isPositiveDouble(double num) {
			if (num > 0.0)
				return true;
			return false;
		}
		
		/**
		 * This method checks if a URL is valid
		 * @param num
		 * @return true if valid, false otherwise
		 */
		public static boolean isValidURL(String urlStr) {
		    try {
		      URL url = new URL(urlStr);
		      return true;
		    }
		    catch (MalformedURLException e) {
		        return false;
		    }
		}
}
