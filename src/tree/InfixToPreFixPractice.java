/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author akashgoyal
 *
 */
public class InfixToPreFixPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infix = "a+b+c";
		System.out.println(inFixToPreFix(infix));

	}

	public static boolean isOperator(char c) {
		return (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9'));
	}

	public static int isPriority(char c) {
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else if (c == '^') {
			return 3;
		} else {
			return 0;
		}
	}

	public static String inFixToPreFix(String infix) {
		Stack<String> operands = new Stack<String>();
		Stack<Character> operators = new Stack<Character>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (!operators.isEmpty() && operators.peek() != '(') {
					String op1 = operands.pop();
					String op2 = operands.pop();
					char ch = operators.pop();
					String tmp = ch + op2 + op1;
					operands.push(tmp);

				}
				operators.pop();
			} else if (!isOperator(c)) {
				operands.push(c + "");
			} else {
				while (!operators.isEmpty() && isPriority(c) <= isPriority(operators.peek())) {
					String op1 = operands.pop();
					String op2 = operands.pop();
					char ch = operators.pop();
					operands.push(ch + op2 + op1);
				}
				operators.push(c);
			}

		}
		while (!operators.isEmpty()) {
			String op1 = operands.pop();
			String op2 = operands.pop();
			char ch = operators.pop();
			operands.push(ch + op2 + op1);
		}
		return operands.peek();
	}
}
