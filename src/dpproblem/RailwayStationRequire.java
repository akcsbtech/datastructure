/**
 * 
 */
package dpproblem;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author akashgoyal
 *
 */
public class RailwayStationRequire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minStationsRequire(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int n = arrival.length;
		int plat_needed = 1, result = 1;
		int i = 1;
		int j = 0;

		while (i < n && j < n) {
			if (arrival[i] <= departure[j]) {
				plat_needed++;
				i++;

				if (plat_needed > result) {
					result = plat_needed;
				}
			} else {
				plat_needed--;
				j++;
			}
		}
		return result;
	}
}
