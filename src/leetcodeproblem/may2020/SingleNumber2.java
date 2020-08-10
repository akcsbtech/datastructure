package leetcodeproblem.may2020;

import java.util.HashMap;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 2, 2, 1 };
		System.out.println(singleNumber(a));
	}

	public int singleNumber1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

		for (Integer ii : map.keySet()) {
			if (map.get(ii) == 1) {
				return ii;
			}
		}
		return -1;
	}

	public static int singleNumber(int[] nums) {
		int one = 0, two = 0;
		for (int i = 0; i < nums.length; i++) {
			int one_ = (one ^ nums[i]) & ~two;
			int two_ = nums[i] & one | ~nums[i] & two;
			one = one_;
			two = two_;
			System.out.println(" one |" + one + " |  two |" + two);
		}
		return one;
	}
}
