package dpproblem;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution1 {

	/*
	 * Complete the 'computeCount' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER m 2. INTEGER n
	 */

	public static void putBacteria(long[][] new_matrix,long[][] matrix, int row, int col, int arow, int acol) {
		System.out.println(" Row col |"+row +" "+col +" "+arow+" "+acol);
		if ((col + 1) < acol) {
			new_matrix[row][col + 1] = ++(new_matrix[row][col + 1]);
		}
		if ((col - 1) >= 0) {
			new_matrix[row][col - 1] = ++(new_matrix[row][col - 1]);
		}

		if ((row + 1) < arow) {
			new_matrix[row + 1][col] = ++(new_matrix[row + 1][col]);
		}
		if ((row - 1) >= 0) {
			new_matrix[row - 1][col] = ++(new_matrix[row - 1][col]);
		}
		if ((row + 1) < arow && (col + 1) < acol) {
			new_matrix[row + 1][col + 1] = ++(new_matrix[row + 1][col + 1]);
		}
		if ((row - 1) >= 0 && (col - 1) >= 0) {
			new_matrix[row - 1][col - 1] = ++(new_matrix[row - 1][col - 1]);
		}
		if ((row + 1) < arow && (col - 1) >= 0) {
			new_matrix[row + 1][col - 1] = ++(new_matrix[row + 1][col - 1]);
		}
		if ((row - 1) >= 0 && (col + 1) < acol) {
			new_matrix[row - 1][col + 1] = ++(new_matrix[row - 1][col + 1]);
		}

	}

	public static void printMatrix(long [][]new_matrix,long [][]matrix ,int m,int n) {
		System.out.println(" m |n| "+m+"  "+n);
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static long computeCount(int m, int n) {
		
		long[][] matrix = new long[m][n];
        long [][] new_matrix=new long [m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
				new_matrix[i][j] = 0;
			}
		}
		matrix[m - 1][0] = 1;

		for (int i = 0; i < n-1; i++) {
			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (matrix[r][c] == 1) {
						matrix[r][c] = --(matrix[r][c]);
						putBacteria(new_matrix,matrix, r, c, m, n);
						printMatrix(new_matrix,matrix,m,n);
					}
				}
			}
			matrix=new_matrix;
		}

		return matrix[m -1][n -1];
	}



	public static void main(String [] arg) {
		System.out.println(computeCount(4,3));
	}
}
