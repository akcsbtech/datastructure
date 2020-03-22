/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class SwapElementToMakeArraySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 30, 20, 40, 50, 60, 70 };
		int n = arr.length;

		System.out.println("Given array is ");
		printArray(arr, n);

		sortByOneSwap(arr, n);

		System.out.println("Sorted array is ");
		printArray(arr, n);
	}

	public static void sortByOneSwap(int a[], int n) {

		for (int i = n - 1; i >= 0; --i) {
			if (a[i] < a[i - 1]) {
				int j = i - 1;

				while (j >= 0 && a[i] < a[j])
					--j;

				int temp = a[i];
				a[i] = a[j + 1];
				a[j + 1] = temp;

				break;
			}
		}
	}

	static void printArray(int arr[], int n) {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
