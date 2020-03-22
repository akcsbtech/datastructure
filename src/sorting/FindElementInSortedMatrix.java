/**
 * 
 */
package sorting;

/**
 * @author akashgoyal
 *
 */
public class FindElementInSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { -10, 20, 30, 40 }, { -5, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		System.out.println(searchElement(mat, 4, 4, 32));
		System.out.println(findNegativeElement(mat, 4, 4));
	}

	public static int findNegativeElement(int[][] m, final int row, final int col) {
		int negativeNum = 0;
		int i = 0;
		int k = col - 1;

		while (i < row && k >= 0) {
			if (m[i][k] >= 0) {
				--k;
			} else {
				negativeNum = negativeNum + (k + 1);
				++i;
			}
		}

		return negativeNum;

	}

	public static int searchElement(int[][] m, int row, int col, int k) {
		int i = 0;
		int j = col - 1;

		while (i < row && j >= 0) {
			if (m[i][j] == k) {
				System.out.println("i:" + i + " j:" + j);
				return 1;
			} else if (m[i][j] > k) {
				--j;
			} else if (m[i][j] < k) {
				++i;
			}
			System.out.println("i:" + i + " j:" + j);
		}
		return -1;
	}
}
