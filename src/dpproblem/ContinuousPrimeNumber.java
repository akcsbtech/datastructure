/**
 * 
 */
package dpproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akashgoyal
 *
 */
public class ContinuousPrimeNumber {

	/**
	 * @param args
	 */
	private static Map<Integer, Boolean> primeCheck = new HashMap<Integer, Boolean>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 2, 3, 5, 6, 7, 13, 11, 17, 23 };
		System.out.println(findLargestContinuousPrime(a, a.length));
	}

	public static int findLargestContinuousPrime(int[] nums, int n) {
		int max_count = 0, curr_count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(nums[i])) {
				++curr_count;

				if (curr_count > max_count) {
					max_count = curr_count;
				}
			} else {
				curr_count = 0;
			}
		}
		return max_count;
	}

	public static boolean isPrime(int n) {
		if (primeCheck.get(n) == null) {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			primeCheck.put(n, true);
			return true;
		} else {
			return primeCheck.get(n);
		}
	}
}
