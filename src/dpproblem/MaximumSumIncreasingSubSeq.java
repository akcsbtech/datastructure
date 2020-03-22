package dpproblem;

public class MaximumSumIncreasingSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSumIncreasingSubSeq lis = new MaximumSumIncreasingSubSeq();
		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(lis.findLISsum(nums));
		int[] nums1 = new int[] { -4, 10, 3, 7, 15 };
		System.out.println(lis.findLISsum(nums1));

		System.out.println(lis.findLISsumWithMemo(nums));
		System.out.println(lis.findLISsumWithMemo(nums1));

		System.out.println(lis.findLISwithBottomDown(nums));
		System.out.println(lis.findLISwithBottomDown(nums1));

	}

	public int findLISsum(int[] a) {
		return findLISsumRecursive(a, 0, -1);
	}

	public int findLISsumWithMemo(int[] nums) {
		Integer[][] dp = new Integer[nums.length][nums.length + 1];
		return findLISsumRecursiveWithDp(dp, nums, 0, -1);
	}

	public int findLISsumRecursiveWithDp(Integer[][] dp, int[] num, int ci, int pi) {

		if (num.length == ci) {
			return 0;
		}
		if (dp[ci][pi + 1] == null) {
			int c1 = 0;
			if (pi == -1 || num[ci] > num[pi]) {
				c1 = num[ci] + findLISsumRecursiveWithDp(dp, num, ci + 1, ci);
			}
			int c2 = findLISsumRecursiveWithDp(dp, num, ci + 1, pi);
			dp[ci][pi + 1] = Math.max(c1, c2);
		}
		return dp[ci][pi + 1];
	}

	public int findLISsumRecursive(int[] nums, int currentIndex, int previousIndex) {

		if (currentIndex == nums.length) {
			return 0;
		}

		int c1 = 0;
		if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
			c1 = nums[currentIndex] + findLISsumRecursive(nums, currentIndex + 1, currentIndex);

		// excluding the number at currentIndex
		int c2 = findLISsumRecursive(nums, currentIndex + 1, previousIndex);

		return Math.max(c1, c2);
	}

	public int findLISwithBottomDown(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
//4, 2, 3, 6, 10, 1, 12
		String ele = "";
		int maxsum = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			ele = "";
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
					dp[i] = dp[j] + nums[i];
				}
				/*
				 * if (dp[i] > maxsum) { ele = ele + " " + nums[i]; }
				 */
				maxsum = Math.max(dp[i], maxsum);

			}
		}
		System.out.println();
		for (int i = 0; i < nums.length; ++i) {
			System.out.print("  " + dp[i]);
		}
		//System.out.println(ele);
		return maxsum;
	}
}
