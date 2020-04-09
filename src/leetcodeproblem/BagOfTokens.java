package leetcodeproblem;

import java.util.Arrays;

public class BagOfTokens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokens = new int[] { 100 };
		System.out.println(maxPoints(tokens, 50));
		tokens = new int[] { 100, 200, 300, 400 };
		System.out.println(maxPoints(tokens, 200));

	}

	public static int maxPoints(int[] tokens, int P) {
		Arrays.sort(tokens);

		int maxPoints = 0;
		int points = 0;
		int i = 0;
		int j = tokens.length - 1;

		while (i <= j) {
			if (P >= tokens[i]) {
				++points;
				P -= tokens[i++];
				maxPoints = Math.max(maxPoints, points);
			} else if (points > 0) {
				points--;
				P += tokens[j--];
			} else {
				return maxPoints;
			}
		}
		return maxPoints;
	}
}
