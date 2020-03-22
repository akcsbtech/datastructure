/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class EggDropingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDropsDPSolution(3, 100));
	}

	public static int minDropsRequire(int egg, int floor) {
		int minimum;
		if (egg == 1 || floor == 0 || floor == 1) {
			return floor;
		} else {
			minimum = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= floor; i++) {
			minimum = Math.min(minimum,
					1 + Math.max(minDropsRequire(egg - 1, floor - 1), minDropsRequire(egg, floor - i)));
		}
		return minimum;
	}

	public static int minDropsDPSolution(int egg, int floor) {
		int md[][] = new int[egg + 1][floor + 1];
		int j, x;
		for (int i = 0; i <= floor; i++) {
			md[0][i] = 0;
		}
		for (int i = 0; i <= floor; i++) {
			md[1][i] = i;
		}
		for (int i = 0; i <= egg; i++) {
			md[i][0] = 0;
		}

		for (int i = 2; i <= egg; i++) {
			for (j = 1; j <= floor; j++) {
				int min = Integer.MAX_VALUE;

				for (x = 1; x <= j; x++) {
					min = Math.min(min, 1 + Math.max(md[i][j - x], md[i - 1][x - 1]));
				}
				md[i][j] = min;
			}
		}

		for (int i = 0; i <= egg; i++) {
			for (j = 0; j <= floor; j++) {
				System.out.print(md[i][j] + "  ");
			}
			System.out.println();
		}
		return md[egg][floor];
	}
}
