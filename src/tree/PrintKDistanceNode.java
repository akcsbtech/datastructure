package tree;

public class PrintKDistanceNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node root;

	void printKDistanceNodeDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		printKDistanceNodeDown(node.left, k - 1);
		printKDistanceNodeDown(node.right, k - 1);
	}

	int printKDistanceNode(Node node, Node target, int k) {
		if (node == null) {
			return -1;
		}
		if (node == target) {
			printKDistanceNodeDown(node, k);
			return 0;
		}

		int d1 = printKDistanceNode(node.left, target, k);

		if (d1 != -1) {
			if (d1 + 1 == k) {
				System.out.println(node.data);
			} else {
				printKDistanceNodeDown(node.right, k - d1 - 2);
			}
			return 1 + d1;
		}

		int dr = printKDistanceNode(node.right, target, k);

		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.println(node.data);

			} else {
				printKDistanceNodeDown(node.left, k - dr - 2);
			}
			return 1 + dr;
		}
		return -1;
	}
}
