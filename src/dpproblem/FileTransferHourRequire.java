/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class FileTransferHourRequire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] values = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
		System.out.println(hourRequire(4, 5, values));
	}

	/*
	 * public boolean checkStatus(int cRow, int cCol, int row, int col, boolean[][]
	 * status, int[][] values) { if (cRow < row && cCol < col && !status[cRow][CCol]
	 * && values[][]) {
	 * 
	 * } }
	 */

	public static boolean checkStatus(int currRow, int currCol, int row, int col, int[][] values) {

		if (currRow >= 0 && currCol >= 0 && currRow < row && currCol < col && values[currRow][currCol] == 0) {
			return true;
		}
		return false;
	}

	public static boolean noFileOnServer(int row, int col, int[][] values) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (values[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isFileTransferOnAllServer(int row, int col, int[][] values) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (values[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void resetBoolArray(int row, int col, boolean[][] status) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				status[i][j] = false;
			}
		}
	}

	public static int hourRequire(int row, int col, int[][] values) {

		if (!noFileOnServer(row, col, values))
			return -1;
		/*
		 * if (!isFileTransferOnAllServer(row, col, values)) { return 0; }
		 */

		int hourRequire = 0;
		boolean[][] status = new boolean[row][col];
		int rowNbr[] = { 0, 0, -1, 1 };
		int colNbr[] = { -1, 1, 0, 0 };
		boolean allFileTransfer = false;
		while (!allFileTransfer) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (values[i][j] == 1 && !status[i][j]) {
						for (int k = 0; k < 4; k++) {
							int currRow = i + rowNbr[k];
							int currCol = j + colNbr[k];
							if (checkStatus(currRow, currCol, row, col, values) && !status[currRow][currCol]) {
								status[currRow][currCol] = true;
								values[currRow][currCol] = 1;
							}

						}
					}
				}
			}

			allFileTransfer = isFileTransferOnAllServer(row, col, values);
			if (!allFileTransfer) {
				resetBoolArray(row, col, status);
				++hourRequire;
			}

		}

		return hourRequire;
	}

}
