/**
 * 
 */
package dpproblem;

import java.util.HashMap;

/**
 * @author akashgoyal
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* int[] arr = { 2, 2, 2, 2, 2, 2 ,1, 8, 7, 4, 1}; */
		/* int[] arr = { 1,2,1,2,1,2,1,2,3,3,3,3,3}; */
		
		int[] arr = { 1,1,1,2,2,2,3,3,1};

		System.out.println("Majority element is " + majorityElement(arr));
		System.out.println("Majority element is " + isMajority(arr));
	}

	public static boolean majorityElement(int[] elements) {
		HashMap<Integer, Integer> majorityMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < elements.length; i++) {
			if (majorityMap.containsKey(elements[i])) {
				Integer count = majorityMap.get(elements[i]);
				System.out.println("Count |"+count);
				if (count >= elements.length / 2) {
					return true;
				}
				majorityMap.put(elements[i], ++count);
			} else {
				majorityMap.put(elements[i], 1);
			}
		}

		return false;
	}

	// boyer moore majority vote algorithm
	public static int isMajority(int a[]) {
		int m = -1;
		int i = 0;

		for (int j = 0; j < a.length; j++) {
			if (i == 0) {
				m = a[j];
				i = 1;
			} else if (m == a[j]) {
				i = i + 1;
			} else {
				i--;
			}
		}
		return m;
	}
}
