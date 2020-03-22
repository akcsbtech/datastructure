/**
 * 
 */
package arraystatement;

/**
 * @author akashgoyal
 *
 */
public class MaxArraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4 };
		System.out.println(countSum(a, 6));
	}

	public static int countSum(int[] arr, int sum) {
		int count = 0;
		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currSum = currSum + arr[i];
		}

		if (sum > currSum) {
			return -1;
		}
		int i = 0;
		int j = arr.length - 1;
		int minLength = arr.length;
		while (i < j) {
			int index = findIndex(arr, i, j);

			if ((currSum - arr[index]) >= sum) {
				currSum = currSum - arr[index];
				--minLength;
				if (i == index) {
					i++;
				} else {
					--j;
				}

			} else {
				return minLength;
			}
		}
		return minLength;
	}

	public static int findIndex(int[] arr, int i, int j) {
		return arr[i] > arr[j] ? j : i;
	}
}
