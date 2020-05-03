package grokkingpattern;

import java.util.Stack;

public class EqualsParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println(Equalss.checks("{{}}"));
		 * System.out.println(Equalss.checks("{{****}}"));
		 * System.out.println(Equalss.checks("{{}}}****}}"));
		 * System.out.println(Equalss.checks("{{}}**{**}}"));
		 * System.out.println(Equalss.checks("{*{}"));
		 * System.out.println(Equalss.checks("{*{{}}"));
		 */
		System.out.println(EqualsParenthesis.checks("(())((())()()(*)(*()(())())())()()((()())((()))(*"));

	}

	public static boolean checks(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		int count = 0;
		Stack<Character> stack = new Stack<Character>();
		if (s.charAt(0) == ')') {
			return false;
		} else if (s.charAt(0) == '*') {
			++count;
		} else {
			stack.add('(');
		}

		// {{****}}
		int i = 1;

		while (i < s.length()) {
			System.out.println("Size |" + stack.size() + "  |  count |" + count + "  |char |" + s.charAt(i));
			if (s.charAt(i) == '(') {
				stack.add('(');
			} else if (s.charAt(i) == '*') {
				++count;
			} else {
				if (!stack.isEmpty()) {
					System.out.println("Stack Size |" + stack.size());
					stack.pop();
				} else if (count > 0) {
					System.out.println("Count |" + count);
					--count;
				} else {
					return false;
				}

			}
			++i;
		}
		if (stack.isEmpty() || stack.size() <= count) {
			return true;
		} else {
			return false;
		}
	}

}
