package dpproblem;

public class EqualSubSetSumPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int isEqualPartitionPossible(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		if (sum % 2 == 0) {
			return isEqualPartitionPossible(nums, sum / 2, 0);
		}
		return 0;
	}

	private int isEqualPartitionPossible(int[] nums, int sum, int currIndex) {
		if (sum == 0) {
			return 1;
		}
		if (nums.length == 0 || currIndex >= nums.length) {
			return 0;
		}
		if (nums[currIndex] <= sum) {
			if (isEqualPartitionPossible(nums, sum - nums[currIndex], currIndex + 1) == 1) {
				return 1;
			}
		}
		return (isEqualPartitionPossible(nums, sum, currIndex + 1));
	}

	public boolean canPartition(int[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with equal sum
		if (sum % 2 != 0)
			return false;

		Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
		return this.canPartitionRecursive(dp, num, sum / 2, 0);
	}

	private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
		// base check
		if (sum == 0)
			return true;

		if (num.length == 0 || currentIndex >= num.length)
			return false;

		if (dp[currentIndex][sum] == null) {
			// recursive call after choosing the number at the currentIndex
			// if the number at currentIndex exceeds the sum, we shouldn't process this
			if (num[currentIndex] <= sum) {
				if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
					dp[currentIndex][sum] = true;
					return true;
				}
			}

			// recursive call after excluding the number at the currentIndex
			dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
		}

		return dp[currentIndex][sum];
	}

	private boolean canPartitionByDp(int[] nums) {
		if (nums.length <= 1) {
			return false;
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];

		if (sum % 2 != 0) {
			return false;
		}
		sum /= 2;
		boolean[][] dp = new boolean[nums.length][sum + 1];

		for (int i = 0; i < nums.length; i++) {
			dp[i][0] = true;
		}

		for (int s = 1; s <= sum; s++) {
			if (s == nums[0]) {
				dp[0][s] = true;
			} else {
				dp[0][s] = false;
			}
		}
		for (int i = 1; i < nums.length; i++) {
			for (int s = 1; s <= sum; s++) {
				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= nums[i]) {
					dp[i][s] = dp[i - 1][s - nums[i]];
				}
			}
		}
		return dp[nums.length - 1][sum];
	}

}
