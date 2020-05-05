package leetcodeproblem;

import java.util.HashMap;

class MajorityElement {

	/*
	 * Given an array of size n, find the majority element. The majority element is
	 * the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element always
	 * exist in the array.
	 */

	public int majorityElement1(int[] nums) {
		int maxCount = 0;
		int majEle = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

			if (map.get(nums[i]) > maxCount) {
				maxCount = map.get(nums[i]);
				majEle = nums[i];
			}
		}

		return majEle;
	}

	public int majorityElement(int[] nums) {
		int maxCount = 1;
		int majEle = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (majEle == nums[i]) {
				++maxCount;
			} else if (maxCount == 1) {
				majEle = nums[i];
			} else {
				--maxCount;
			}
		}

		return majEle;
	}
}