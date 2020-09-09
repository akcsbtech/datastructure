/**
 * 
 */
package leetcodeproblem.may2020;

/**
 * @author b0218163
 *
 */
public class LongestPlaindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("AAAAA"));
	}

	public static int longestPalindrome(String s) {
		System.out.println("S :{}" + s);
		int[] frequency = new int[52];

		for (int i = 0; i < s.length(); i++) {
			int x=s.charAt(i);
			System.out.println("ch :{}" + s.charAt(i)+"  "+ x);
			if (x>=65 && x<=90) {
				System.out.println("IF :{}" + s.charAt(i));
				frequency[s.charAt(i) - 'A']++;
			} else {
				System.out.println("ELSE :{}" + s.charAt(i));
				frequency[26 + s.charAt(i) - 'a']++;
			}
		}
		int count = 0;
		boolean odd = false;
		int length = 0;
		for (int i = 0; i < 52; i++) {
			// System.out.println(frequency[i]);
			if (frequency[i] % 2 == 0) {
				length = length + frequency[i];
			} else {
				if (odd) {
					length = length + frequency[i] / 2;
				} else {
					length = length + frequency[i];
					odd = true;
				}
			}
		}
		return length;
	}
}
