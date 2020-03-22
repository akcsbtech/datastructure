/**
 * 
 */
package concept;

/**
 * @author akashgoyal
 *
 */
public class FibboNacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibbonacciSericeUsingLoop(8));
		System.out.println(fibbonacciSericeUsingRecursion(8));
	}

	public static int fibbonacciSericeUsingLoop(int n) {
		int previousN = 0, nextN = 1, sum = 0;
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			sum = previousN + nextN;
			previousN = nextN;
			nextN = sum;
		}

		return nextN;
	}

	public static int fibbonacciSericeUsingRecursion(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibbonacciSericeUsingRecursion(n - 1) + fibbonacciSericeUsingRecursion(n - 2);
	}

}
