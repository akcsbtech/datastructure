/**
 * 
 */
package binary;

/**
 * @author akashgoyal
 *
 */
public class CountSetBit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 1;
		int countSetBit = 0;
		while (t > 0) {
			if (t % 2 == 1) {
				++countSetBit;
			}
			t = t / 2;
		}
		System.out.println("Set Count Bit |" + countSetBit);
		System.out.println("Set Count Bit |" + countSetBit(100));

	}

	public static int countSetBit(int x) {
		int c;
		int times=0;
		for (c = 0; x > 0; c++) {
			x &= x - 1; // clear the least significant bit set
		}
		return c;
	}
}
