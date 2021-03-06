package leetcodeproblem;

import java.util.Arrays;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 1, 2, 5 };
		System.out.println(minimumNumberOfCoinRequire(coins, 11));
		System.out.println(minimumNumberOfCoinRequire(coins, 5));
		System.out.println(minimumNumberOfCoinRequire(coins, 0));

	}

	public static int minimumNumberOfCoinRequire(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
