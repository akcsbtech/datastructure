/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author akashgoyal
 *
 */
public class PostFixToInfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postFix = "ab+ef*g*-"; // left right root
		String output = "a+b-e*f*g"; // we want this output. left root right

		PostFixToInfix expression = new PostFixToInfix();
		Node root = expression.constructTree(postFix.toCharArray());
		System.out.println("Expression :");
		expression.inOrderTraversal(root);
	}

	public boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '|' || c == '%') {
			return true;
		}
		return false;
	}

	public Node constructTree(char[] postfix) {
		Stack<Node> st = new Stack();
		Node t, t1, t2;

		for (int i = 0; i < postfix.length; i++) {
			if (!isOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			} else {
				t = new Node(postfix[i]);
				t1 = st.pop();
				t2 = st.pop();

				t.right = t1;
				t.left = t2;

				st.push(t);
			}
		}
		t = st.peek();
		st.pop();
		return t;
	}

	public void inOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(" " + (char)root.data);
		inOrderTraversal(root.right);
	}
}
