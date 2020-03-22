/**
 * 
 */
package dpproblem;

import java.util.Arrays;

/**
 * @author akashgoyal
 *
 */
public class CoinChangeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 5, 5 };

		System.out.println(coinChange(coins, 15));

		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(numberOfWaysCountChange(arr, m, 4));

		// System.out.println(count(coins, coins.length, 15));

	}

	public static int numberOfWaysCountChange(int S[], int m, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (m <= 0 && n >= 1) {
			return 0;
		}
		return numberOfWaysCountChange(S, m - 1, n) + numberOfWaysCountChange(S, m, n - S[m - 1]);
	}

	public static int countWaysUsingLookUpTable(int S[],int m,int n) {
		int [] table=new int [n+1];
		Arrays.fill(table, 0);

		table[0]=1;
		
		for(int i=0;i<m;i++) {
			for(int j=S[i];j<=n;j++) {
                table[j] =table[j]+ table[j-S[i]]; 
			}
		}
		return table[n];
		
	}
	public static int coinChange(int[] coins, int amount) {
		// Arrays.sort(coins);

		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < amount + 1; i++) {
			System.out.print("  " + dp[i]);
		}
		System.out.println();
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
