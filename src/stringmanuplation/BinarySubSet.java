/**
 * 
 */
package stringmanuplation;

/**
 * @author akashgoyal
 *
 */
public class BinarySubSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSubSet("100011010110001"));

	}

	public static boolean threeSubSet(String data) {
		if (data == null || data.equals("")) {
			return false;
		}
		int count = noOfOnes(data);

		if (count % 3 == 0) {
			String one = "", two = "", three = "";

			int ones = count / 3;
			boolean status1 = true;
			boolean status2 = false;
			boolean status3 = false;

			int currentCount = 0;
			for (int i = 0; i < data.length(); i++) {
				if (status1) {
					if (data.charAt(i) - 48 == 1) {
						++currentCount;
						one = one + "1";
					} else {
						one = one + "0";
					}
					if (currentCount == ones) {
						status1 = false;
						status2 = true;
						currentCount = 0;
					}
				} else if (status2) {
					if (data.charAt(i) - 48 == 1) {
						++currentCount;
						two = two + "1";
					} else {
						two = two + "0";
					}
					if (currentCount == ones) {
						status2 = false;
						status3 = true;
						currentCount = 0;
					}

				} else if (status3) {
					if (data.charAt(i) - 48 == 1) {
						++currentCount;
						three = three + "1";
					} else {
						three = three + "0";
					}

				}
			}
			System.out.println("one |" + one + " | two|" + two + "|three|" + three);
			int oned = binaryToDecimal(one);
			int twod = binaryToDecimal(two);
			int threed = binaryToDecimal(three);

			if (oned == twod && oned == threed) {
				return true;
			}
		}

		return false;
	}

	public static int noOfOnes(String s) {

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 48 == 1) {
				++count;
			}
		}
		return count;
	}

	public static int binaryToDecimal(String s) {
		int decimal = 0;
		for (int i = 0; i < s.length(); i++) {
			decimal = decimal * 2 + (s.charAt(i) - 48);
		}
		return decimal;
	}
}
