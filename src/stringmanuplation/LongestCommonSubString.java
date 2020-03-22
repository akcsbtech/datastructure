package stringmanuplation;

public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestCommonSubString lcs = new LongestCommonSubString();
		System.out.println(lcs.findLCSLength("abdca", "cbda"));
		System.out.println(lcs.findLCSLength("passport", "ppsspt"));

		System.out.println(lcs.findLCSLengthwithMemo("abdca", "cbda"));
		System.out.println(lcs.findLCSLengthwithMemo("passport", "ppsspt"));

		System.out.println(lcs.findLCSLengthOPtimize("abdca", "cbda"));
		System.out.println(lcs.findLCSLengthOPtimize("passport", "ppsspt"));

	}

	public int findLCSLength(String s1, String s2) {
		return longestCommonSubString(s1, s2, 0, 0, 0);
	}

	public int findLCSLengthwithMemo(String s1, String s2) {
		/*
		 * int i = 10; Integer ii = i; int i2 = ii;
		 */
		int maxLength = Math.min(s1.length(), s2.length());
		Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
		return longestCommonSubString(dp, s1, s2, 0, 0, 0);
	}

	public int longestCommonSubString(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
		if (s1.length() == i1 || s2.length() == i2) {
			return count;
		}
		if (dp[i1][i2][count] == null) {
			if (s1.charAt(i1) == s2.charAt(i2)) {
				count = longestCommonSubString(s1, s2, i1 + 1, i2 + 1, count + 1);
			}
			int c1 = longestCommonSubString(s1, s2, i1 + 1, i2, 0);
			int c2 = longestCommonSubString(s1, s2, i1, i2 + 1, 0);
			dp[i1][i2][count] = Math.max(count, Math.max(c1, c2));
		}
		/*
		 * for (int i = 0; i < i1; i++) { for (int j = 0; j < i2; j++) { for (int k = 0;
		 * k < count; k++) { System.out.print("  " + dp[i][j][k]); }
		 * System.out.println(); } }
		 */
		// System.out.println("i1 |" + i1 + "|i2 |" + i2 + " |cont |" + count);
		return dp[i1][i2][count];
	}

	public int longestCommonSubString(String s1, String s2, int i1, int i2, int count) {
		if (s1.length() == i1 || s2.length() == i2) {
			return count;
		}
		if (s1.charAt(i1) == s2.charAt(i2)) {
			count = longestCommonSubString(s1, s2, i1 + 1, i2 + 1, count + 1);
		}
		int c1 = longestCommonSubString(s1, s2, i1 + 1, i2, 0);
		int c2 = longestCommonSubString(s1, s2, i1, i2 + 1, 0);

		return Math.max(count, Math.max(c1, c2));

	}

	public int findLCSLengthOPtimize(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				System.out.print(" " + dp[i][j]);
			}
			System.out.println();
		}
		return maxLength;
	}

	static int findLCSLengthOptimal(String s1, String s2) {
		int[][] dp = new int[2][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i % 2][j] = 0;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
					maxLength = Math.max(maxLength, dp[i % 2][j]);
				}
			}
		}
		return maxLength;
	}
}
