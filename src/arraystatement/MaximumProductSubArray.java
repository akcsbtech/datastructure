/**
 * 
 */
package arraystatement;

/**
 * @author akashgoyal
 *
 */
public class MaximumProductSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[] { -8, 2, 3, 0, -5, 1 };
		// System.out.println(maxProductInSubArray(A));
		System.out.println(maxSubarrayProduct(A));
		System.out.println(maxProduct(A));
		System.out.println(selfAssignment(A));

	}

	public static int selfAssignment(int a[]) {

		int maxValue = 1;
		int minValue = 1;
		int maxProduct = 1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				maxProduct = maxProduct * a[i];
				minValue = minValue * a[i];
			} else if (a[i] == 0) {
				maxProduct = 1;
				minValue = 1;
			} else {
				if (minValue < 0) {
					if (maxProduct < minValue * a[i]) {
						maxProduct = minValue * a[i];
					}
				}
				minValue = minValue * a[i];
			}
			if (minValue > maxValue) {
				maxValue = minValue;
				maxProduct = minValue;
			}
			if (maxProduct > maxValue) {
				maxValue = maxProduct;
			}
		}
		return maxValue;
	}

	static int min(int x, int y) {
		return x < y ? x : y;
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}

	public static int maxProductInSubArray(int[] A) {
		if (A.length == 0) {
			return 0;
		} else if (A.length == 1) {
			return A[0] > 0 ? A[0] : 0;
		}
		int totalProduct = 1;
		int previousProd = 1;
		int maxProduct = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				previousProd = totalProduct;
				totalProduct = 1;
			} else {
				totalProduct = totalProduct * A[i];
				if (totalProduct < 0) {
					previousProd = totalProduct / A[i];
				}
			}
			if (totalProduct > maxProduct) {
				maxProduct = totalProduct;
			}
			if (maxProduct < previousProd) {
				maxProduct = previousProd;
			}
		}
		return maxProduct;
	}

	static int maxSubarrayProduct(int arr[]) {
		int n = arr.length;
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = 1;
		int flag = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				max_ending_here = max_ending_here * arr[i];
				min_ending_here = min(min_ending_here * arr[i], 1);
				flag = 1;
			} else if (arr[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else {
				int temp = max_ending_here;
				max_ending_here = max(min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		if (flag == 0 && max_so_far == 1) {
			return 0;
		}
		return max_so_far;
	}

	public static int maxProduct(int[] nums) {
		int length = nums.length;
		int max = 1;
		int currentMax = 1;
		int currentMin = 1;
		int flag = 0;

		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				currentMax = currentMax * nums[i];
				currentMin = Math.min(currentMin * nums[i], 1);
				flag = 1;
			} else if (nums[i] == 0) {
				currentMax = 1;
				currentMin = 1;
			} else {
				int temp = currentMax;
				currentMax = Math.max(currentMin * nums[i], 1);
				currentMin = temp * nums[i];
			}

			if (max < currentMax) {
				max = currentMax;
			}
		}

		if (flag == 0 && currentMax == 1) {
			return 0;
		}
		return max;

	}
}
