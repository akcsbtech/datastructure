package leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class SubSetProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		System.out.println(subSet(nums));
	}

	public static List<ArrayList<Integer>> subSet(int[] nums) {
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		possibleSubSet(0, nums, curr, result);
		return result;
	}

	public static void possibleSubSet(int index, int nums[], ArrayList<Integer> curr, List<ArrayList<Integer>> result) {
		result.add(new ArrayList<Integer>(curr));

		for (int i = index; i < nums.length; i++) {
			curr.add(nums[i]);
			possibleSubSet(i + 1, nums, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

}
