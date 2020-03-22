/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class ElementOnceInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		findOnceInArray(arr, 0, arr.length - 1);
	}

	public static void findOnceInArray(int a[], int low, int high) {

		if (low > high) {
			return;
		} else if (low == high) {
			System.out.println(a[low]);
			return;
		}
//{ 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		int mid = (low + high) / 2;

		if (mid % 2 == 0) {
			if (a[mid] == a[mid + 1]) {
				findOnceInArray(a, mid + 2, high);
			} else {
				findOnceInArray(a, low, mid);
			}
		} else if (mid % 2 == 1) {
			if (a[mid] == a[mid - 1]) {
				findOnceInArray(a, mid + 1, high);
			} else {
				findOnceInArray(a, low, mid - 1);
			}
		}
	}

}
