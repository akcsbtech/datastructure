/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class FillWaterInGlasses {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double glasses[][] = new double[10][10];
		int level = fillWaterInGlasses(1, 10, glasses);

		for (int i = 0; i <= level; i++) {
			for (int j = 0; j <= level; j++) {
				System.out.print(" " + glasses[i][j]);
			}
			System.out.println();
		}
	}

	public static int fillWaterInGlasses(double C, double N, double glasses[][]) {
		glasses[0][0] = N;
		int level = 0;
		boolean waterInlevel = true;

		while (waterInlevel) {
			waterInlevel = false;

			for (int i = 0; i <= level; i++) {

				if (glasses[level][i] > C) {
					double extraWater = glasses[level][i] - C;
					glasses[level][i] = C;
					glasses[level + 1][i] += extraWater / 2;
					glasses[level + 1][i + 1] += extraWater / 2;
					waterInlevel = true;
				}
			}
			++level;
		}

		return level - 1;
	}

}
