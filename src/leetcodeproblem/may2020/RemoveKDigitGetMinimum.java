package leetcodeproblem.may2020;

import java.util.Stack;

class RemoveKDigitGetMinimum {
	public static void main(String [] arg) {
		System.out.println(removeKdigits("1432219",3));
	}
	public static String removeKdigits(String num, int k) {
		int n = num.length();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; ++i) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
				System.out.println("Item POP "+stack.peek() +"  "+ num.charAt(i)+"  "+stack.size());
				stack.pop();
				k = k - 1;
			}
			if (!stack.isEmpty() || num.charAt(i) != '0') {
				System.out.println("Item Push "+num.charAt(i));
				stack.push(num.charAt(i));
			}
		}

		while (!stack.isEmpty() && k >0) {
			stack.pop();
			--k;
			if (stack.isEmpty()) {
				return "0";
			}
		}
		String s="";
		while (!stack.isEmpty()) {
			// ch[n-1]=stack.top();
			s=stack.peek()+s;
			stack.pop();
			n = n - 1;
		}
		System.out.println(n);
		return s;
	}
}