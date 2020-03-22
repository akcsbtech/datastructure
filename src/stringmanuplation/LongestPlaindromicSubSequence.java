package stringmanuplation;

public class LongestPlaindromicSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPlaindromicSubSequence lps = new LongestPlaindromicSubSequence();
		System.out.println(lps.LPS("abc"));
		System.out.println(lps.LPS("abccba"));
		System.out.println(lps.LPS("abcddca"));

		System.out.println(lps.findLengthLPS("abc"));
		System.out.println(lps.findLengthLPS("abccba"));
		System.out.println(lps.findLengthLPS("abcddca"));

	}

	public int LPS(String str) {
		return LPS(str, 0, str.length() - 1);
	}

	public int LPS(String st, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		}
		if (startIndex == endIndex) {
			return 1;
		}
		if (st.charAt(startIndex) == st.charAt(endIndex)) {
			return 2 + LPS(st, startIndex + 1, endIndex - 1);
		}

		int c1 = LPS(st, startIndex + 1, endIndex);
		int c2 = LPS(st, startIndex, endIndex - 1);

		return Math.max(c1, c2);
	}

	public int findLengthLPS(String str) {
		Integer[][] dp = new Integer[str.length()][str.length()];
		return findLenghtRecursive(dp, str, 0, str.length() - 1);
	}

	public int findLenghtRecursive(Integer[][] dp, String str, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		}
		if (startIndex == endIndex) {
			return 1;
		}
		if (dp[startIndex][endIndex] == null) {
			if (str.charAt(startIndex) == str.charAt(endIndex)) {
				dp[startIndex][endIndex] = 2 + findLenghtRecursive(dp, str, startIndex + 1, endIndex - 1);
			} else {
				int c1 = findLenghtRecursive(dp, str, startIndex + 1, endIndex);
				int c2 = findLenghtRecursive(dp, str, startIndex, endIndex - 1);
				dp[startIndex][endIndex] = Math.max(c1, c2);

			}
		}
		return dp[startIndex][endIndex];
	}

	public int findLPSLength(String str) {
		int[][] dp = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}

		for (int start = str.length() - 1; start >= 0; --start) {
			for (int end = start + 1; end < str.length(); end++) {
				if (str.charAt(start) == str.charAt(end)) {
					dp[start][end] = 2 + dp[start + 1][end - 1];
				} else {
					dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
				}
			}
		}
		return dp[0][str.length() - 1];
	}
}
