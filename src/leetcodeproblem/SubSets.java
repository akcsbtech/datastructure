package leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3 };
		System.out.println(subsets(nums));
	}

	List<List<Integer>> output = new ArrayList();
	int n, k;

	public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		// if the combination is done
		if (curr.size() == k)
			output.add(new ArrayList(curr));

		for (int i = first; i < n; ++i) {
			// add i into the current combination
			curr.add(nums[i]);
			// use next integers to complete the combination
			backtrack(i + 1, curr, nums);
			// backtrack
			curr.remove(curr.size() - 1);
		}
	}
	//approach 2
	public List<List<Integer>> subsets1(int[] nums) {
		n = nums.length;
		for (k = 0; k < n + 1; ++k) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		return output;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		int n = nums.length;

		for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
			// generate bitmask, from 0..00 to 1..11
			// System.out.println(Integer.toBinaryString(i));
			String bitmask = Integer.toBinaryString(i).substring(1);
			System.out.println(bitmask);
			// append subset corresponding to that bitmask
			List<Integer> curr = new ArrayList();
			for (int j = 0; j < n; ++j) {
				if (bitmask.charAt(j) == '1')
					curr.add(nums[j]);
			}
			output.add(curr);
		}
		return output;
	}

}
