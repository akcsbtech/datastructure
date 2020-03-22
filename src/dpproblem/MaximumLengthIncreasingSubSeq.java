package dpproblem;

public class MaximumLengthIncreasingSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumLengthIncreasingSubSeq lis = new MaximumLengthIncreasingSubSeq();
		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(lis.findLISLength(nums));
		nums = new int[] { -4, 10, 3, 7, 15 };
		System.out.println(lis.findLISLength(nums));
	}

	public int findLISLength(int[] a) {
		return findLISLengthRecursive(a, 0, -1);
	}

	public int findLISLengthWithMemo(int[] nums) {
		Integer[][] dp = new Integer[nums.length][nums.length + 1];
		return findLISLengthRecursiveWithDp(dp, nums, 0, -1);
	}

	public int findLISLengthRecursiveWithDp(Integer[][] dp, int[] num, int ci, int pi) {

		if (num.length == ci) {
			return 0;
		}
		if (dp[ci][pi + 1] == null) {
			int c1 = 0;
			if (pi == -1 || num[ci] > num[pi]) {
				c1 = 1 + findLISLengthRecursiveWithDp(dp, num, ci + 1, ci);
			}
			int c2 = findLISLengthRecursiveWithDp(dp, num, ci + 1, pi);
			dp[ci][pi + 1] = Math.max(c1, c2);
		}
		return dp[ci][pi + 1];
	}

	public int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex) {

		if (currentIndex == nums.length) {
			return 0;
		}

		int c1 = 0;
		if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
			c1 = 1 + findLISLengthRecursive(nums, currentIndex + 1, currentIndex);

		// excluding the number at currentIndex
		int c2 = findLISLengthRecursive(nums, currentIndex + 1, previousIndex);

		return Math.max(c1, c2);
	}

	public int findLISwithBottomDown(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = 1;

		int maxLength = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					maxLength = Math.max(dp[i], maxLength);
				}
			}
		}
		return maxLength;
	}
}
