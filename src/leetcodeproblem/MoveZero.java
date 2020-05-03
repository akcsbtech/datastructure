package leetcodeproblem;

class MoveZero {
	public static void main(String[] arg) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
	}

	public static void moveZeroes(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int start = 0;
		int end = 0;

		while (start < nums.length && end < nums.length) {
			System.out.println(" end |" + end + "| start|" + start + "  " + nums[end] + "  " + nums[start]);
			while (start < nums.length && nums[start] > 0 && nums[start] < 0) {
				++start;
			}
			while (end < nums.length && nums[end] == 0) {
				++end;
			}
			if (start > end) {
				end = start;
				continue;
			}
			if (end < nums.length && start < nums.length && start != end) {
				int temp = nums[end];
				nums[end] = nums[start];
				nums[start] = temp;
			}
		}
	}
}