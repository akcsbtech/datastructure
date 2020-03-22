/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class MinMaxPositionalElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(positionalMinMaxCount(a, 3, 3));
	}

	public static int positionalMinMaxCount(int[][] mat, int row, int col) {

		int count = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (isMinMax(mat, row, col, i, j)) {
					++count;
				}
			}
		}
		return count;
	}

	public static boolean isMinMax(int[][] mat, int row, int col, int currRow, int currCol) {

		int ele = mat[currRow][currCol];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < row; i++) {
			if (mat[i][currCol] < min) {
				min = mat[i][currCol];
			}
			if (mat[i][currCol] > max) {
				max = mat[i][currCol];
			}
		}
		if (min == ele || max == ele) {
			return true;
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < col; i++) {
			if (mat[currRow][i] < min) {
				min = mat[currRow][i];
			}
			if (mat[currRow][i] > max) {
				max = mat[currRow][i];
			}
		}
		if (min == ele || max == ele) {
			return true;
		}

		return false;
	}

}
