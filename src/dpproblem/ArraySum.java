package dpproblem;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraySum {

	static long numberOfLists(long s, int m, int d) {
		// Complete this function
		return numberOfLists(s, m, d, 1);
	}

	static long count = 0;

	static long numberOfLists(long rs, int m, int d, int start) {
		if (rs == 0) {
			return 1;
		}
		if (rs < 0) {
			return 0;
		}
		if (start >= m) {
			return 0;
		}

		for (int i = start; i <= (start + d); i++) {
			System.out.println(" i" + i);
			count = count + numberOfLists(rs - i, m, d, i);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Return the number of lists satisfying the conditions above, modulo
		// 1000000009.
		long s = in.nextLong();
		int m = in.nextInt();
		int d = in.nextInt();
		long result = numberOfLists(s, m, d);
		System.out.println(result + " " + count);
	}
}