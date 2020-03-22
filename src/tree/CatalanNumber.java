/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class CatalanNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++)
			System.out.println("catalan Num:"+catalanNumber(i));
	}

	public static int catalanNumber(int n) {
		if (n <= 1) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(" n |" + n + "|  res|" + res);
			res = res + catalanNumber(i) * catalanNumber(n - i - 1);

		}
		return res;
	}

	public static int catalanNumberByDp(int n) {
		int catalan[] = new int[n + 1];
		catalan[0] = 1;
		catalan[1] = 1;

		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; ++j) {
				catalan[i] = catalan[i] + (catalan[j] * catalan[i - j - 1]);
			}
		}
		return catalan[n];
	}

	public static int binomialCoeff(int n, int k) {
		int res = 1;

		if (k > n - k) {
			k = n - k;
		}

		for (int i = 0; i < k; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}
		return res;
	}

	public static int catalanNumberByCo(int n) {
		int c = binomialCoeff(2 * n, n);
		return c / (n + 1);
	}
}
