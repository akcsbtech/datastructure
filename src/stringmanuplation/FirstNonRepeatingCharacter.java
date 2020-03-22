/**
 * 
 */
package stringmanuplation;

/**
 * @author akashgoyal
 *
 */
public class FirstNonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstNonRepeatingChar("GeeksforGeeks"));
	}

	public static String firstNonRepeatingChar(String input) {

		if (input == null) {
			return "-1";
		}

		for (int i = 0; i < input.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					++count;
				}
			}
			if (count == 0) {
				return input.charAt(i) + "";
			}
		}
		return "-1";
	}

}
