
// Java program to convert a decimal 
// number to binary number 
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

class DToB {
	// function to convert decimal to binary

	public static void main(String[] args) {
		int n = 3334;
		negaBynary(-23);
		/*
		 * int a[] = getBitsFromDecimal(-n); for (int i = 0; i < a.length; i++) {
		 * System.out.print(" " + a[i]); }
		 */

		// 01011100010111
	}

	public static void negaBynary(int value) {
		List<Integer> result = new ArrayList<Integer>();
	
		while (value != 0) {
			int remainder = value % -2;
			value = value / -2;
			System.out.println("Before value |" + value + "|remainder |" + remainder);
			if (remainder < 0) {
				remainder += 2;
				value += 1;
			}
			System.out.println("value |" + value + "|remainder |" + remainder);
			result.add(remainder);
		}

		System.out.println(result);
	}

	public static int[] getBitsFromDecimal(int number) {
		number = -number;
		int index = 0;
		int[] result = new int[40];
		while (number != 0) {
			result[index++] = Math.abs(number % 2);
			number /= -2;
		}
		return result;
	}

	static void decToBinary(int n) {
		// array to store binary number
		int[] binaryNum = new int[32];

		// counter for binary array
		int i = 0;
		while (n > 0) {
			// storing remainder in binary array
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}

		// printing binary array in reverse order
		for (int j = i - 1; j >= 0; j--)
			System.out.print(binaryNum[j]);
	}

	// driver program

}

// Contributed by Pramod Kumar 
