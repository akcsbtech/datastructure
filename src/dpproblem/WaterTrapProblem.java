/**
 * 
 */
package dpproblem;

import java.util.ArrayList;

/**
 * @author akashgoyal
 *
 */
public class WaterTrapProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 0, 2, 5, 6, 0, 1 };
		System.out.println(trap(arr));
		System.out.println(trapWithBootStrap(arr));
	}

	public int waterTrap(int[] arr) {

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			int max_left = 0;
			int max_right = 0;

		}
		return ans;
	}

	public static int trap(int[] height) {
		// time : O(n)
		// space : O(1)
		if (height.length == 0)
			return 0;
		int left = 0, right = height.length - 1;
		int leftMax = 0, rightMax = 0;
		int ans = 0;
		while (left < right) {
			if (height[left] > leftMax)
				leftMax = height[left];
			if (height[right] > rightMax)
				rightMax = height[right];
			if (leftMax < rightMax) {
				ans += Math.max(0, leftMax - height[left]);
				left++;
			} else {
				ans += Math.max(0, rightMax - height[right]);
				right--;
			}
		}
		return ans;
	}

	public static int trapWithBootStrap(int[] height) {
		if (height.length == 0)
			return 0;
		int ans = 0;
		int size = height.length;
		ArrayList<Integer> left_max = new ArrayList<Integer>(size);
		ArrayList<Integer> right_max = new ArrayList<Integer>(size);
		left_max.add(height[0]);
		for (int i = 1; i < size; i++) {
			left_max.add(i, Math.max(height[i], left_max.get(i - 1)));
		}
		right_max.add(size - 1, height[size - 1]);
		for (int i = size - 2; i >= 0; i--) {
			right_max.add(i, Math.max(height[i], right_max.get(i + 1)));
		}
		for (int i = 1; i < size - 1; i++) {
			ans += Math.min(left_max.get(i), right_max.get(i) - height[i]);
		}
		return ans;
	}
}
