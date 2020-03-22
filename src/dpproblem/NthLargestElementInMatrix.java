package dpproblem;

public class NthLargestElementInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(nthLargest(a, 3, 3, 2)); // output 8
		int b[][] = { { 1, 2, 13 }, { 4, 5, 16 }, { 7, 8, 19 } };
		System.out.println(nthLargest(b, 3, 3, 3)); // ouptut 13

		int c[][] = { { 1, 2, 3 }, { 4, 15, 16 }, { 14, 19, 20 } };
		System.out.println(nthLargest(c, 3, 3, 3)); // output 16
	}

	public static int nthLargest(int[][] arr, int n, int m, int nthelement) {
		if (n == 0 && m == 0) {
			return -1;
		}
		if (n == 1 && m == 1 || n == 1 && m > 1 || m == 1 && n > 1 || nthelement == 1) {
			return arr[n - 1][m - 1];
		}

		int largest = arr[n - 1][m - 1];
		int count = 1;
		int i = n - 1;
		int j = m - 1;
		while (count < nthelement) {
			int ele1 = arr[i - 1][j];
			int ele2 = arr[i][j - 1];
			if (ele1 > ele2) {
				--i;
				largest = ele1;
			} else {
				largest = ele2;
				--j;
			}
			++count;
		}

		return largest;
	}

}
