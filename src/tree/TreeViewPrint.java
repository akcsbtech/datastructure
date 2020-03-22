package tree;

public class TreeViewPrint {

	Node root;
	static int max_level = 0;

	void rightView(Node node, int level) {
		if (node == null)
			return;

		if (max_level < level) {
			System.out.print("  " + node.data);
			max_level = level;
		}
		rightView(node.right, level + 1);
		rightView(node.left, level + 1);

	}

	void leftView(Node node, int level) {
		if (node == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		leftView(node.left, level + 1);
		leftView(node.right, level + 1);

	}

	void leftView() {
		System.out.print("Left view :");
		leftView(root, 1);
	}

	void rightView() {
		System.out.println();
		System.out.print("Right View :");
		max_level = 0;
		rightView(root, 1);
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		TreeViewPrint tree = new TreeViewPrint();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		tree.leftView();
		tree.rightView();
	}
}
