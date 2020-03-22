/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class LevelOrderTraversal {

	/**
	 * @param args
	 */
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		levelOrderTraversal(root);
		System.out.println("No of time call " + count);
	}

	public static boolean printLevel(Node root, int level) {
		++count;
		if (root == null) {
			return false;
		}
		if (level == 1) {
			System.out.print(root.data + "->>>");
			return true;
		}

		boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);

		return left || right;
	}

	public static void levelOrderTraversal(Node root) {
		int level = 1;

		while (printLevel(root, level)) {
			++level;
		}
	}

}
