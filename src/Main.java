import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// Insert Code here...
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] nums = new int[num];
		for (int i = 0; i < num; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(allElementEqual(nums, num));
	}

	public static int allElementEqual(int[] nums, int n) throws InterruptedException {
		int count = 0;
		while (true) {
			Thread.sleep(1000);
			Arrays.sort(nums);
			printArray(nums, n);
			if (isElementEqual(nums, n)) {
				return count;
			} else {
				for (int i = 0; i < n - 1; i++) {
					nums[i] = nums[i] + 1;
				}
				++count;
			}
		}
	}

	

	public static boolean isElementEqual(int[] nums, int n) {
		return nums[0] == nums[n - 1];
	}

	public static void printArray(int[] nums, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
