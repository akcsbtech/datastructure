/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 4, 5, 6, 7, 1, 2, 3 }; // 4
		System.out.println(findRotationPoint(a, 0, a.length));

		int b[] = { 5, 6, 7, 1, 2, 3, 4 }; // 3
		System.out.println(findRotationPoint(b, 0, b.length));

		int c[] = { 1, 2, 3, 4, 5, 6, 7 }; // 0
		System.out.println(findRotationPoint(c, 0, c.length));

		System.out.println(findRotationPointWithOutRec(a));
		System.out.println(findRotationPointWithOutRec(b));
		System.out.println(findRotationPointWithOutRec(c));
	}

	public static int findRotationPointWithOutRec(int a[]) {
		int length = a.length - 1;
		if (a[0] < a[length]) {
			return 0;
		}

		int start = 0;
		int end = length ;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (a[mid] < a[mid + 1]) {
				return mid ;
			} else if (a[mid] >= a[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}

	public static int findRotationPoint(int a[], int start, int last) {
		if (start == last) {
			return start;
		}
		int mid = (start + last) / 2;
		if (mid == a.length - 1) {
			return mid + 1;
		}
		if (a[mid] > a[mid + 1]) {
			return mid + 1;
		} else if (a[mid] < a[mid + 1] && a[mid] > a[mid - 1] && a[mid] > a[start]) {
			return findRotationPoint(a, mid, last);
		} else {
			return findRotationPoint(a, start, mid);
		}
	}

}
