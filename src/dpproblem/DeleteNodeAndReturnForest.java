/**
 * 
 */
package dpproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author akashgoyal
 *
 */
public class DeleteNodeAndReturnForest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> remaining = new ArrayList<TreeNode>();
		Set<Integer> toDelete = new HashSet<Integer>();

		for (int i : to_delete) {
			toDelete.add(i);
		}
		removeNodes(root, toDelete, remaining);

		if (!toDelete.contains(root.val)) {
			remaining.add(root);
		}
		return remaining;
	}

	public TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {

		if (root == null) {
			return null;
		}

		root.left = removeNodes(root.left, toDelete, remaining);
		root.right = removeNodes(root.right, toDelete, remaining);

		if (toDelete.contains(root.val)) {
			if (root.left != null) {
				remaining.add(root.left);
			}

			if (root.right != null) {
				remaining.add(root.right);
			}
			return null;
		}
		return root;
	}

}
