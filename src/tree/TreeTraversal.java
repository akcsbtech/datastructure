/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author akashgoyal
 *
 */
public class TreeTraversal {

	/**
	 * @param args
	 */
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversal tree = new TreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Inorder Traversal :");
		tree.inOrderWithOutRecursion(tree.root);
		System.out.println();
		tree.inOrderWithRecursion(tree.root);

		System.out.println();
		System.out.println("Preorder Traversal :");
		tree.preOrderWithRecursion(tree.root);

		System.out.println();
		tree.preOrderWithOutRecursion(tree.root);

		System.out.println();
		System.out.println("Postorder Traversal :");
		tree.postOrderWithRecursion(tree.root);
		System.out.println();
		tree.postOrderTraversalWithTwoStack(tree.root);
	}

	public void inOrderWithRecursion(Node root) {

		if (root == null) {
			return;
		}
		inOrderWithRecursion(root.left);
		System.out.print(root.data + " >>>");
		inOrderWithRecursion(root.right);

	}

	public void preOrderWithRecursion(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " >>>");
		preOrderWithRecursion(root.left);
		preOrderWithRecursion(root.right);
	}

	public void postOrderWithRecursion(Node root) {

		if (root == null) {
			return;
		}
		postOrderWithRecursion(root.left);
		postOrderWithRecursion(root.right);
		System.out.print(root.data + " >>>");

	}

	public void postOrderTraversalWithTwoStack(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Integer> stack2 = new Stack<Integer>();

		stack1.push(root);
		while (!stack1.isEmpty()) {
			Node pop = stack1.pop();
			stack2.push(pop.data);
			if (pop.left != null) {
				stack1.push(pop.left);
			}
			if (pop.right != null) {
				stack1.push(pop.right);
			}

		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop() + " >>>");
		}

	}

	public void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		stack.push(current);
		Node prev = null;
		while (!stack.isEmpty()) {
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null)
					stack.push(current.left);
				else if (current.right != null)
					stack.push(current.right);
				else {
					stack.pop();
					list.add(current.data);
				}

				/*
				 * go up the tree from left node, if the child is right push it onto stack
				 * otherwise process parent and pop stack
				 */
			} else if (current.left == prev) {
				if (current.right != null)
					stack.push(current.right);
				else {
					stack.pop();
					list.add(current.data);
				}

				/*
				 * go up the tree from right node and after coming back from right node process
				 * parent and pop stack
				 */
			} else if (current.right == prev) {
				stack.pop();
				list.add(current.data);
			}

			prev = current;
		}

	}

	

	public void preOrderWithOutRecursion(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				System.out.print(current.data + " >>>");
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			current = current.right;
		}
	}

	public void inOrderWithOutRecursion(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();

		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data + " >>>");
			current = current.right;
		}
	}
}
