package dpproblem;

public class NumberOfIslands {

	static final int ROW = 5, COL = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }
			};

		System.out.println(countIslands(M));
	}

	public static boolean isSafe(int M[][], int row, int col, boolean[][] visited) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
	}

	public static void DFS(int M[][], int row, int col, boolean[][] visited) {

		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}

	public static int countIslands(int M[][]) {
		boolean visited[][] = new boolean[ROW][COL];

		int count = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {

				if (M[i][j] == 1 && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
				}
			}
		}

		return count;
	}
}
