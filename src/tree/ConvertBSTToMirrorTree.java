/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author akashgoyal
 *
 */
public class ConvertBSTToMirrorTree {

	Node root;

	void mirror() {
		root = mirror(root);
	}

	Node mirror(Node node) {
		if (node == null) {
			return node;
		}
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		node.left = right;
		node.right = left;

		return node;
	}

	void inOrder() {
		inOrder(root);
	}

	void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " >>>");
		inOrder(node.right);

	}

	 void mirrorIterative(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		// Do BFS. While doing BFS, keep swapping
		// left and right children
		while (q.size() > 0) {
			// pop top node from queue
			Node curr = q.peek();
			q.remove();

			// swap left child with right child
			Node temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			

			// push left and right children
			if (curr.left != null)
				q.add(curr.left);
			if (curr.right != null)
				q.add(curr.right);
		}
	}

	public static void main(String[] arg) {
		ConvertBSTToMirrorTree tree = new ConvertBSTToMirrorTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror();

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder();
		
		tree.mirrorIterative(tree.root);

		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder();
	}
}
