package matrix;

public class RotateMatrix90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate90Degree(m, 3);
		int[][] rotate = rotate(m, 3);

		//rotate90Degree(m, 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(rotate[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] rotate(int[][] matrix, int n) {
		for (int i = 0; i < n / 2; ++i) {
			for (int j = i; j < n - 1 - i; ++j) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
		return matrix;
	}

	public static int[][] rotate90Degree(int[][] matrix, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.println();
		}
		return matrix;
	}
}
