/**
 * 
 */
package arraystatement;

/**
 * @author akashgoyal
 *
 */
public class FindMinCoinUnlimimtedSupply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] S = { 1, 3, 5, 7 };

		// Total Change required
		int N = 18;

		System.out.println("Minimum number of coins required to get " + "desired change is " + findMinCoins(S, N));
		System.out.println(
				"Minimum number of coins required to get " + "desired change is " + findMinCoinsWithMemorization(S, N));

		System.out.println(globalCount);
	}

	static int globalCount;

	public static int findMinCoins(int[] coins, int amount) {
		++globalCount;
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return Integer.MAX_VALUE;
		}

		int coin = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			int res = findMinCoins(coins, amount - coins[i]);
			if (res != Integer.MAX_VALUE) {
				coin = Math.min(res + 1, coin);
			}
		}
		return coin;
	}

	public static int findMinCoinsWithMemorization(int a[], int amount) {

		int T[] = new int[amount + 1];
		T[0] = 0;
		for (int i = 1; i < amount; i++) {
			T[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= amount; i++) {
			T[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;

			for (int j = 0; j < a.length; j++) {

				if (i - a[j] >= 0) {
					res = T[i - a[j]];
				}

				if (res != Integer.MAX_VALUE) {
					T[i] = Math.min(T[i], res + 1);
				}
			}
		}
		return T[amount];
	}
}
