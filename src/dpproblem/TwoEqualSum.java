/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class TwoEqualSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1,1,1, 2, 3, 4, 5, 5 };
		int n = arr.length;
		printTwoParts(arr, n);

	}

	public static int findSplitPoint(int arr[], int n) {

		int leftSum = 0;
		for (int i = 0; i < n; i++) {
			leftSum += arr[i];
			int rightSum = 0;
			for (int j = i + 1; j < n; j++)
				rightSum += arr[j];
			if (leftSum == rightSum)
				return i + 1;
		}
		return -1;
	}

	// split point using findSplitPoint()
	static void printTwoParts(int arr[], int n) {
		int splitPoint = findSplitPoint(arr, n);
		if (splitPoint == -1 || splitPoint == n) {
			System.out.println("Not Possible");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (splitPoint == i)
				System.out.println();
			System.out.print(arr[i] + " ");

		}
	}

}
