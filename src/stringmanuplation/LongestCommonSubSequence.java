/**
 * 
 */
package stringmanuplation;

/**
 * @author akashgoyal
 *
 */
public class LongestCommonSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		String s1 = "AGGTAB";
		String s2 = "AGXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
		System.out.println("Length of LCS is" + " " + lcs.longestCommonSubSequence(s1, s2));
		System.out.println("Length of LCS is" + " " + lcs.findLCS(s1, s2));
	}

	public int longestCommonSubSequence(String s1, String s2) {
		return longestCommonSubSequence(s1, s2, 0, 0);
	}

	public int longestCommonSubSequence(String s1, String s2, int i1, int i2) {
		if (s1.length() == i1 || s2.length() == i2) {
			return 0;
		}
		if (s1.charAt(i1) == s2.charAt(i2)) {
			return 1 + longestCommonSubSequence(s1, s2, i1 + 1, i2 + 1);
		}

		int c1 = longestCommonSubSequence(s1, s2, i1 + 1, i2);
		int c2 = longestCommonSubSequence(s1, s2, i1, i2 + 1);

		return Math.max(c1, c2);

	}

	public int lcs(char[] X, char[] Y, int x, int y) {
		if (x == 0 || y == 0) {
			return 0;
		}

		if (X[x - 1] == Y[y - 1]) {
			return 1 + lcs(X, Y, x - 1, y - 1);
		} else {
			return max(lcs(X, Y, x - 1, y), lcs(X, Y, x, y - 1));
		}

	}

	public int lcsTabulation(char[] X, char[] Y, int x, int y) {
		int L[][] = new int[x + 1][y + 1];

		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else {
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		return L[x][y];
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int findLCS(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}
		return maxLength;
	}
}
