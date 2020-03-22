/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class SteppingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countSteppingNumber(3));
	}

	public static int countSteppingNumber(int digit) {
		int count = 0;
		int minNumber = minNumber(digit);
		int maxNumber = maxNumber(digit);

		while (minNumber <= maxNumber) {
			if (checkDigitDifference(minNumber)) {
				++count;
			}
			++minNumber;
		}
		System.out.println();
		return count;
	}

	public static boolean checkDigitDifference(int x) {
		String num = x + "";
		for (int i = 0; i < num.length() - 1; i++) {
			if (Math.abs(num.charAt(i) - num.charAt(i + 1)) != 1) {
				return false;
			}
		}
		System.out.print("  " + x);
		return true;
	}

	public static int minNumber(int i) {
		String x = "1";

		for (int j = 1; j < i; ++j) {
			x = x + "0";
		}
		return Integer.parseInt(x);
	}

	public static int maxNumber(int i) {
		String x = "9";

		for (int j = 1; j < i; ++j) {
			x = x + "9";
		}
		return Integer.parseInt(x);
	}

}
