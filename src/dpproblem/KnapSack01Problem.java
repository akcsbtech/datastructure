package dpproblem;

public class KnapSack01Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KnapSack01Problem ks = new KnapSack01Problem();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = ks.solveKnapSackByDPArray(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);
		maxProfit = ks.solveKnapSackByDPArray(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);
	}

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		return this.knapsackRecursive(profits, weights, capacity, 0);
	}

	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		// recursive call after choosing the element at the currentIndex
		// if the weight of the element at currentIndex exceeds the capacity, we
		// shouldn't process this
		int profit1 = 0;
		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
		// recursive call after excluding the element at the currentIndex
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
		return Math.max(profit1, profit2);
	}

	public int solveKnapSackWithMemo(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		return knapsackRecursiveWithMemo(dp, profits, weights, capacity, 0);
	}

	private int knapsackRecursiveWithMemo(Integer[][] dp, int[] profits, int[] weights, int capacity,
			int currentIndex) {
		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		// recursive call after choosing the element at the currentIndex
		// if the weight of the element at currentIndex exceeds the capacity, we
		// shouldn't process this
		if (dp[currentIndex][capacity] != null) {
			return dp[currentIndex][capacity];
		}
		int profit1 = 0;
		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
		// recursive call after excluding the element at the currentIndex
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
		dp[currentIndex][capacity] = Math.max(profit1, profit2);

		return dp[currentIndex][capacity];
	}

	private int solveKnapSackByDPArray(int[] profits, int[] weight, int capacity) {
		if (profits.length != weight.length || profits.length <= 0 || capacity <= 0) {
			return 0;
		}

		int[][] dp = new int[profits.length][capacity + 1];

		for (int i = 0; i < profits.length; i++) {
			dp[i][0] = 0;
		}

		for (int c = 0; c <= capacity; c++) {
			if (weight[0] <= c) {
				dp[0][c] = profits[0];
			}
		}

		for (int i = 1; i < profits.length; i++) {
			for (int c = 1; c <= capacity; c++) {
				int profit1 = 0, profit2 = 0;
				if (weight[i] <= c) {
					profit1 = profits[i] + dp[i - 1][c - weight[i]];
				}
				profit2 = dp[i - 1][c];
				dp[i][c] = Math.max(profit1, profit2);
			}
		}
		selectedElement(dp, weight, profits, capacity);
		return dp[profits.length - 1][capacity];
	}

	private void selectedElement(int dp[][], int[] weight, int[] profits, int capacity) {
		System.out.println("Selected weight :");
		int totalProfit = dp[profits.length - 1][capacity];
		for (int i = profits.length - 1; i > 0; i--) {
			if (totalProfit != dp[i - 1][capacity]) {
				System.out.print("  " + weight[i]);
				totalProfit = totalProfit - profits[i];
				capacity -= weight[i];
			}
		}
		if (totalProfit != 0)
			System.out.print(" " + weight[0]);
		System.out.println("");
	}

}
