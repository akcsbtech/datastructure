package stringmanuplation;

public class PlaindromicPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlaindromicPartition mpp = new PlaindromicPartition();
		System.out.println(mpp.findMPPCutRecursive("abdbca"));
		System.out.println(mpp.findMPPCutRecursive("cdpdd"));
		System.out.println(mpp.findMPPCutRecursive("pqr"));
		System.out.println(mpp.findMPPCutRecursive("pp"));

	}

	private boolean isPalindrome(String st, int x, int y) {
		while (x < y) {
			if (st.charAt(x++) != st.charAt(y--))
				return false;
		}
		return true;
	}

	private int findMPPCutRecursive(String st) {
		return findMPPCutRecursive(st, 0, st.length() - 1);
	}

	// time complexity 2^n
	private int findMPPCutRecursive(String st, int sIndex, int eIndex) {

		if (sIndex >= eIndex || isPalindrome(st, sIndex, eIndex)) {
			return 0;
		}
		int minimumCuts = eIndex - sIndex;

		for (int i = sIndex; i <= eIndex; i++) {
			if (isPalindrome(st, sIndex, i)) {
				minimumCuts = Math.min(minimumCuts, 1 + findMPPCutRecursive(st, i + 1, eIndex));
			}
		}
		return minimumCuts;
	}

	private int findMPPCutRecursive(Integer[][] dp, Boolean[][] pd, String st, int sIndex, int eIndex) {

		if (sIndex >= eIndex || isPalindrome(pd, st, sIndex, eIndex)) {
			return 0;
		}
		if (dp[sIndex][eIndex] == null) {
			int minimumCuts = eIndex - sIndex;

			for (int i = sIndex; i <= eIndex; i++) {
				if (isPalindrome(pd, st, sIndex, i)) {
					minimumCuts = Math.min(minimumCuts, 1 + findMPPCutRecursive(dp, pd, st, i + 1, eIndex));
				}
			}
			dp[sIndex][eIndex] = minimumCuts;
		}
		return dp[sIndex][eIndex];
	}

	private boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
		if (dpIsPalindrome[x][y] == null) {
			dpIsPalindrome[x][y] = true;
			int i = x, j = y;
			while (i < j) {
				if (st.charAt(i++) != st.charAt(j--)) {
					dpIsPalindrome[x][y] = false;
					break;
				}
				// use memoization to find if the remaining string is a palindrome
				if (i < j && dpIsPalindrome[i][j] != null) {
					dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
					break;
				}
			}
		}
		return dpIsPalindrome[x][y];
	}

	// find optimize way
	private int findMPPCutRecursiveUsingSpace(String st) {
		Integer[][] dp = new Integer[st.length()][st.length()];
		Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];
		return findMPPCutRecursive(dp, dpIsPalindrome, st, 0, st.length() - 1);
	}
}
