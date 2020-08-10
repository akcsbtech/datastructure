package leetcodeproblem;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestValidParentheses(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	public int longestValidParentheses1(String s) {
		int count = 0;
		if (s == null || s.length() <= 1) {
			return count;
		}
		Stack<Character> openBracket = new Stack();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				openBracket.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (!openBracket.isEmpty()) {
					char c = openBracket.pop();
					count = count + 2;
				}
			}
		}
		return count;
	}
}
