package knapsack;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnboundedKnapsack ks = new UnboundedKnapsack();
		int[] profits = { 15, 50, 60, 90 };
		int[] weights = { 1, 3, 4, 5 };
		int maxProfit = ks.solveKnapsack(profits, weights, 8);
		System.out.println(maxProfit);

		maxProfit = ks.solveKnapsackUsingMemory(profits, weights, 8);
		System.out.println(maxProfit);

	}

	public int solveKnapsack(int[] profit, int[] weights, int capacity) {
		return knapsackRecursive(profit, weights, capacity, 0);
	}

	public int solveKnapsackUsingMemory(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		return this.knapsackRecursiveUsingMemory(dp, profits, weights, capacity, 0);
	}

	private int knapsackRecursive(int[] profit, int[] weights, int capacity, int current) {

		if (capacity <= 0 || profit.length == 0 || weights.length != profit.length || current >= profit.length) {
			return 0;
		}
		int profit1 = 0;
		if (weights[current] <= capacity)
			profit1 = profit[current] + knapsackRecursive(profit, weights, capacity - weights[current], current);
		int profit2 = knapsackRecursive(profit, weights, capacity, current + 1);

		return Math.max(profit1, profit2);

	}

	private int knapsackRecursiveUsingMemory(Integer[][] dp, int[] profit, int[] weights, int capacity, int current) {

		if (capacity <= 0 || profit.length == 0 || weights.length != profit.length || current >= profit.length) {
			return 0;
		}
		if (dp[current][capacity] == null) {
			int profit1 = 0;
			if (weights[current] <= capacity)
				profit1 = profit[current]
						+ knapsackRecursiveUsingMemory(dp, profit, weights, capacity - weights[current], current);
			int profit2 = knapsackRecursiveUsingMemory(dp, profit, weights, capacity, current + 1);
			dp[current][capacity] = Math.max(profit1, profit2);
		}
		return dp[current][capacity];
	}

	public int solveKnapsackUsingBottomUp(int[] profits, int[] weights, int capacity) {
		// base checks
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
			return 0;

		int n = profits.length;
		int[][] dp = new int[n][capacity + 1];

		// populate the capacity=0 columns
		for (int i = 0; i < n; i++)
			dp[i][0] = 0;

		// process all sub-arrays for all capacities
		for (int i = 0; i < n; i++) {
			for (int c = 1; c <= capacity; c++) {
				int profit1 = 0, profit2 = 0;
				if (weights[i] <= c)
					profit1 = profits[i] + dp[i][c - weights[i]];
				if (i > 0)
					profit2 = dp[i - 1][c];
				dp[i][c] = profit1 > profit2 ? profit1 : profit2;
			}
		}

		// maximum profit will be in the bottom-right corner.
		return dp[n - 1][capacity];
	}
}
