/**
 * 
 */
package arraystatement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akashgoyal
 *
 */
public class MaximumSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[] { -5, -8, -9, 1, -12, 13, 1, -15, 8 };
		System.out.println(maxSumSubArray(A));
	}

	public static int maxSumSubArray(int[] A) {
		if (A.length == 0) {
			return 0;
		} else if (A.length == 1) {
			return A[0] > 0 ? A[0] : 0;
		}
		int max = 0;
		int previousMax = 0;
		ArrayList<Integer> real_list = new ArrayList<Integer>();
		ArrayList<Integer> temp_list = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			previousMax = previousMax + A[i];
			temp_list.add(A[i]);
			if (previousMax > max) {
				max = previousMax;
				real_list = (ArrayList<Integer>) temp_list.clone();
			} else if (previousMax < 0) {
				previousMax = 0;
				temp_list.clear();
			}
		}
		System.out.println("Element Included in sum :" + real_list);
		return max;
	}

	public int countSubsets(int[] num, int sum) {
		int n = num.length;
		int[][] dp = new int[n][sum + 1];

		// populate the sum=0 columns, as we will always have an empty set for zero sum
		for (int i = 0; i < n; i++)
			dp[i][0] = 1;

		// with only one number, we can form a subset only when the required sum is
		// equal to its value
		for (int s = 1; s <= sum; s++) {
			dp[0][s] = (num[0] == s ? 1 : 0);
		}

		// process all subsets for all sums
		for (int i = 1; i < num.length; i++) {
			for (int s = 1; s <= sum; s++) {
				// exclude the number
				dp[i][s] = dp[i - 1][s];
				// include the number, if it does not exceed the sum
				if (s >= num[i])
					dp[i][s] += dp[i - 1][s - num[i]];
			}
		}

		// the bottom-right corner will have our answer.
		return dp[num.length - 1][sum];
	}

}
