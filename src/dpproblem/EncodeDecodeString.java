/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class EncodeDecodeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encodeDecode(0, "abcd", "123"));
		System.out.println(encodeDecode(1, "abbcccd", "123"));
	}

	public static String encodeDecode(int type, String input, String pattern) {
		if (type == 0) {
			return encode(input, pattern);
		} else if (type == 1) {
			return decode(input, pattern);
		}
		return "-1";
	}

	public static String encode(String input, String pattern) {
		try {
			char[] ii = input.toCharArray();
			char[] pp = pattern.toCharArray();
			String result = "";

			for (int i = 0; i < pattern.length(); i++) {
				for (int j = 0; j < (pp[i] - 48); j++) {
					result = result + input.charAt(i);
				}
			}

			String subString = input.substring(pattern.length(), input.length());
			return result + subString;
		} catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			return "-1";
		}
	}

	public static String decode(String input, String pattern) {

		try {
			char[] ii = input.toCharArray();
			char[] pp = pattern.toCharArray();
			String result = "";
			int i = 0;
			for (int count = 0; count < pattern.length(); count++) {
				String subString = input.substring(i, i + pp[count] - 48);
				i = i + pp[count] - 48;
				char c = subString.charAt(0);
				String emptyString = subString.replaceAll(c + "", "");
				if (emptyString == null || emptyString.equals("")) {
					result = result + c;
				} else {
					return "-1";
				}
			}

			String subString = input.substring(i, input.length());
			return result + subString;
		} catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
			return "-1";
		}
	}

}
