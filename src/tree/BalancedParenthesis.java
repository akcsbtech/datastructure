/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class BalancedParenthesis {

	static void _printParenthesis(char str[], int pos, int n, int open, int close) {
		if (close == n) {
			// print the possible combinations
			for (int i = 0; i < str.length; i++)
				System.out.print(str[i]);
			System.out.println();
			return;
		} else {
			if (open > close) {
				str[pos] = '}';
				_printParenthesis(str, pos + 1, n, open, close + 1);
			}
			if (open < n) {
				str[pos] = '{';
				_printParenthesis(str, pos + 1, n, open + 1, close);
			}
		}
	}

	public static void Validparentheses(int openP, int closeP, String string) {
		if (openP == 0 && closeP == 0) // mean all opening and closing 
				System.out.println(string);
		if (openP > closeP) // means closing parentheses is more than open ones
				return;
		if (openP > 0)
			Validparentheses(openP - 1, closeP, string + "("); // put ( and
																// reduce
																// the count by
																// 1
		if (closeP > 0)
			Validparentheses(openP, closeP - 1, string + ")"); // put ) and
																// reduce
																// the count by
																// 1
	}

	static void printParenthesis(char str[], int n) {
		if (n > 0)
			_printParenthesis(str, 0, n, 0, 0);
		return;
	}

	// driver program
	public static void main(String[] args) {
		int n = 3;
		char[] str = new char[2 * n];
		printParenthesis(str, n);
	}

}
