/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class KnapSackAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[] { 6, 10, 12 };
		int weight[] = new int[] { 1, 2, 3 };

		int W = 5;
		System.out.println(knapsack(W, weight, val, val.length));
		System.out.println(knapsackWithMemoization(W, weight, val, val.length));
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int knapsack(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0) {
			return 0;
		}

		if (wt[n - 1] > W) {
			return knapsack(W, wt, val, n - 1);
		} else {
			return max(val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1), knapsack(W, wt, val, n - 1));
		}

	}

	static int knapsackWithMemoization(int W, int wt[], int val[], int n) {

		int i, w;
		int k[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					k[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					k[i][w] = max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
				} else {
					k[i][w] = k[i - 1][w];
				}
			}
		}
		for (i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				System.out.print(k[i][j] + " ");
			}
			System.out.println();
		}
		return k[n][W];
	}

}
