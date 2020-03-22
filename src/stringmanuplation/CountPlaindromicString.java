/**
 * 
 */
package stringmanuplation;

/**
 * @author akashgoyal
 *
 */
public class CountPlaindromicString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPlaindromicString("abdbca", 0, 5));
		System.out.println(countPlaindromicString("cddpd", 0, 4));
		System.out.println(countPlaindromicString("pqr", 0, 2));

	}

	public static int countPlaindromicString(String str, int sIndex, int eIndex) {
		if (sIndex > eIndex) {
			return 0;
		}
		if (sIndex == eIndex) {
			return 1;
		}
		if (str.charAt(sIndex) == str.charAt(eIndex)) {
			return countPlaindromicString(str, sIndex + 1, eIndex - 1);
		} else {
			return countPlaindromicString(str, sIndex + 1, eIndex) + countPlaindromicString(str, sIndex, eIndex - 1);
		}
	}

	public static int CPS(String str) {
		Boolean[][] dp = new Boolean[str.length()][str.length()];
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = true;
			++count;
		}
		for (int startIndex = str.length() - 1; startIndex >= 0; --startIndex) {
			for (int endIndex = startIndex + 1; endIndex < str.length(); endIndex++) {
				if (str.charAt(startIndex) == str.charAt(endIndex)) {
					if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
						++count;
					}
				}
			}
		}
		return count;
	}

}
