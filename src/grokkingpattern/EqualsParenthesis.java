package grokkingpattern;

import java.util.Stack;

public class EqualsParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EqualsParenthesis.checkParenthesis("{{}}"));
		System.out.println(EqualsParenthesis.checkParenthesis("{{****}}"));
		System.out.println(EqualsParenthesis.checkParenthesis("{{}}}****}}"));
		System.out.println(EqualsParenthesis.checkParenthesis("{{}}**{**}}"));
		System.out.println(EqualsParenthesis.checkParenthesis("{*{}"));
		System.out.println(EqualsParenthesis.checkParenthesis("{*{{}}"));

	}

		public static boolean checkParenthesis(String parenthesis) {
			if (parenthesis == null || parenthesis.equals("")) {
				return true;
			}
			int count = 0;
			Stack<Character> s = new Stack<Character>();
			if (parenthesis.charAt(0) == '}') {
				return false;
			} else if (parenthesis.charAt(0) == '*') {
				++count;
			} else {
				s.add('{');
			}
	
			//{{****}}
			int i = 1;
	
			while (i < parenthesis.length()) {
				if (parenthesis.charAt(i) == '{') {
					s.add('{');
				} else if (parenthesis.charAt(i) == '*') {
					++count;
				} else {
					if (!s.isEmpty()) {
						s.pop();
					} else if (count > 0) {
						--count;
					} else {
						return false;
					}
	
				}
				++i;
			}
			if (s.isEmpty() || s.size() <= count) {
				return true;
			} else {
				return false;
			}
		}

}
