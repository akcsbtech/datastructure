/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class LevenshteinDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String X = "kitten", Y = "sitting";

		System.out.print("The Levenshtein Distance is " + dist(X, X.length(), Y, Y.length()));
	}

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	public static int dist(String X, int m, String Y, int n) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0 : 1;

		return min(dist(X, m - 1, Y, n) + 1, dist(X, m, Y, n - 1) + 1, dist(X, m - 1, Y, n - 1) + cost);
	}

	public static int distWithMemorization(String X, int m, String Y, int n) {
		int[][] T = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			T[i][0] = i;
		}

		for (int j = 0; j < n; j++) {
			T[0][j] = j;
		}

		int cost;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				if (X.charAt(i - 1) == X.charAt(j - 1)) {
					cost = 0;
				} else {
					cost = 1;
				}

				T[i][j] = min(T[i - 1][j] + 1, T[i][j - 1] + 1, T[i - 1][j - 1] + cost);
			}
		}
		return T[m][n];
	}
}
