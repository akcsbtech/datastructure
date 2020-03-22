/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class ConstructBST {

	Index ii = new Index();

	public Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {
		if (preIndex.index >= size || low > high) {
			return null;
		}
		Node root = new Node(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		if (low == high) {
			return root;
		}

		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.data) {
				break;
			}
		}
		root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
		root.right = constructTreeUtil(pre, preIndex, i, high, size);

		return root;
	}

	Node constructTree(int pre[], int size) {
		return constructTreeUtil(pre, ii, 0, size - 1, size);
	}

}
