/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class SecondLargestInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6,9,0};
		System.out.println(secondLargestArray(arr, 0, arr.length));
	}

	public static int secondLargestArray(int arr[], int start, int end) {
		int secondSmallest = Integer.MIN_VALUE;
		int mid = start + end / 2;
		System.out.println("start |" + start + "|  end |" + end + " | mid |" + mid);
		if (mid == start) {
			return arr[mid + 1];
		}
		if (mid == end) {
			return arr[0];
		}
		if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
			return arr[mid + 1];
		} else if (arr[mid] < arr[mid + 1]) {
			return secondLargestArray(arr, start, mid);
		} else {
			return secondLargestArray(arr, mid, end);
		}
	}
}
