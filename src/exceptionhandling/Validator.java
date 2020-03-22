/**
 * 
 */
package exceptionhandling;

/**
 * @author akashgoyal
 *
 */
public class Validator {

	public boolean isValid(String s) throws Exception {

		int len = s.length();
		int count = 0;

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				++count;
			}
		}
		if (count == len) {
			return true;
		} else if (count == 0) {
			throw new StringException("String Exception");
		} else {
			throw new AlphaNumericException("AlphaNumeric Exception");
		}
	}

}
