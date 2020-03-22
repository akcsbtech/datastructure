package dpproblem;

import java.util.ArrayList;
import java.util.List;

public class CountSubSetProblemKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSubSetProblemKnapSack cs = new CountSubSetProblemKnapSack();
		int[] nums = { 1, 1, 2, 3 };
		int sum = 4;
		System.out.println(cs.countSubSetSum(nums, sum));
	}

	private List<List<Integer>> countSubSetSum(int[] nums, int sum) {
		List<List<Integer>> ls = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<>();
		countSubSetSum(nums, 0, sum, ls, li);
		return ls;
	}

	private void countSubSetSum(int[] nums, int currIndex, int sum, List<List<Integer>> ls, List<Integer> li) {
		if (sum == 0) {
			ls.add(new ArrayList<Integer>(li));
		}
		if (nums.length <= currIndex) {
			return;
		}
		int sum1 = 0;
		if (nums[currIndex] <= sum) {
			// sum1 = countSubSetSum(nums, currIndex + 1, sum - nums[currIndex]);
			li.add(nums[currIndex]);
			countSubSetSum(nums, currIndex + 1, sum - nums[currIndex], ls, li);

		}
		// int sum2 = countSubSetSum(nums, currIndex + 1, sum);
		countSubSetSum(nums, currIndex + 1, sum, ls, new ArrayList<>());
	}

	public int countSubsets(int[] num, int sum) {
		Integer[][] dp = new Integer[num.length][sum + 1];
		return this.countSubsetsRecursive(dp, num, sum, 0);
	}

	private int countSubsetsRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
		// base checks
		if (sum == 0)
			return 1;

		if (num.length == 0 || currentIndex >= num.length)
			return 0;

		// check if we have not already processed a similar problem
		if (dp[currentIndex][sum] == null) {
			// recursive call after choosing the number at the currentIndex
			// if the number at currentIndex exceeds the sum, we shouldn't process this
			int sum1 = 0;
			if (num[currentIndex] <= sum)
				sum1 = countSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);

			// recursive call after excluding the number at the currentIndex
			int sum2 = countSubsetsRecursive(dp, num, sum, currentIndex + 1);

			dp[currentIndex][sum] = sum1 + sum2;
		}

		return dp[currentIndex][sum];
	}

}
