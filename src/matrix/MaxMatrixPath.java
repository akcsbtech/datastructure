package matrix;

public class MaxMatrixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		// { { 1, 2, 3 }, { 4, 5, 4 }, { 12, 6, 5 } };
		System.out.println(maxPath(data, 3, 3));
	}

	public static int maxPath(int[][] data, int row, int col) {
		int count = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int pathCount = move(data, row, col, i, j);
				System.out.println("pathCount " + pathCount);
				if (pathCount > count) {
					count = pathCount;
				}
			}
		}
		return count;
	}

	public static int move(int[][] data, int row, int col, int currRow, int currCol) {

		int rowMove[] = { 0, -1, 0, 1 };
		int colMove[] = { -1, 0, 1, 0 };
		int count = 1;
		boolean status[][] = new boolean[row][col];

		for (int a = 0; a < row; a++) {
			for (int b = 0; b < col; b++) {
				status[a][b] = false;
			}
		}
		status[currRow][currCol] = true;
		while (true) {
			boolean state = false;
			for (int i = 0; i < 4; i++) {
				boolean isCount = isCount(data, row, col, currRow + rowMove[i], currCol + colMove[i]);
				if (isCount) {
					if (!status[currRow + rowMove[i]][currCol + colMove[i]]
							&& (data[currRow][currCol] - data[currRow + rowMove[i]][currCol + colMove[i]] == -1)) {
						currRow = currRow + rowMove[i];
						currCol = currCol + colMove[i];
						status[currRow][currCol] = true;
						++count;
						state = true;
						break;
					}
				}
			}
			if (!state) {
				return count;
			}
		}

	}

	public static boolean isCount(int[][] data, int row, int col, int currRow, int currCol) {
		if (row > currRow && col > currCol && currRow >= 0 && currCol >= 0) {
			return true;
		}
		return false;
	}
}
