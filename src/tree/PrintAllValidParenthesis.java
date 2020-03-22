/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class PrintAllValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		validParenthesis(n / 2, n / 2, "", 0);

	}

	public static void validParenthesis(int openP, int closeP, String s,int count) {
		if (openP == 0 && closeP == 0) {
			++count;
			System.out.println(s+"  "+count);
			
		}

		if (openP > closeP) {
			return;
		}
		if (openP > 0) {
			validParenthesis(openP - 1, closeP, s + "(",count);
		}
		if (closeP > 0) {
			validParenthesis(openP, closeP - 1, s + ")",count);
		}
	}

}
