/**
 * 
 */
package matrix;

/**
 * @author akashgoyal
 *
 */
public class MoveZeroInLast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 0, 0, 0, 0, 1, 1, 0, 2, 2, 2, 0 };
		int pivot = 1;
		moveZeroInLast(a, pivot);

		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	public static void moveZeroInLast(int[] a, int pivot) {
		if (a.length <= 1) {
			return;
		}
		int i = 0;
		int j = a.length - 1;
		int count = 0;

		while (i < j) {

			while (a[i] > pivot) {
				++i;
				++count;
			}

			while (a[j] < pivot) {
				--j;
				++count;
			}
			if (a[j] == pivot && a[i] < a[j]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				++i;
				--j;
			} else if (i < j - 1) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				++i;
				--j;
			}
		}

		System.out.println("No of Times Loop iterate {}" + count);
		/*
		 * for (int k = 0; k < a.length; k++) { System.out.print(" " + a[i]); }
		 */
	}

	public static void usingQuickSort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		int pivot = 0;
		int i = 0;
		int j = a.length - 1;

	}

	public static void usingSortArrayByMid(int[] a) {
		int lo = 0, mid = 0, hi = a.length - 1;
		int temp = 0;

		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1: {
				++mid;
				break;
			}
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				--hi;
				break;
			}
			}

		}

	}
}
