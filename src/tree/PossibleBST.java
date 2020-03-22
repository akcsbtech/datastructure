/**
 * 
 */
package tree;

import java.util.Vector;

/**
 * @author akashgoyal
 *
 */
public class PossibleBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int in[] = { 4, 5, 7 };

		int n = in.length;

		PossibleBST bst = new PossibleBST();

		Vector<Node> trees = bst.getTrees(in, 0, n - 1);

		System.out.println("Preorder traversal of different  binary trees are:");

		for (int i = 0; i < trees.size(); i++) {
			bst.preOrder(trees.get(i));
			System.out.println("");
		}
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + "----->");
			preOrder(node.left);
			preOrder(node.right);
		}

	}

	public Vector<Node> getTrees(int[] arr, int start, int end) {
		Vector<Node> trees = new Vector<Node>();

		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++) {
			Vector<Node> ltrees = getTrees(arr, start, i - 1);
			Vector<Node> rtrees = getTrees(arr, i + 1, end);

			for (int j = 0; j < ltrees.size(); j++) {
				for (int k = 0; k < rtrees.size(); k++) {
					Node node = new Node(arr[i]);
					node.left = ltrees.get(j);
					node.right = rtrees.get(k);
					trees.add(node);
				}
			}

		}
		return trees;
	}
}
