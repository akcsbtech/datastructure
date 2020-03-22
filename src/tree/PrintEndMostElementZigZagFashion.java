/**
 * 
 */
package tree;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import dpproblem.TreeNode;

/**
 * @author akashgoyal
 *
 */
public class PrintEndMostElementZigZagFashion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void zigzag(TreeNode root) throws InterruptedException {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(root.val);
		}

		BlockingQueue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(20);
		queue.add(root);
		System.out.print(">>>" + root.val);
		queue.add(null);
		boolean flagLevel = false;
		TreeNode prev = null;
		TreeNode node = null;
		while (!queue.isEmpty()) {
			prev = node;
			node = queue.take();

			if (node == null) {
				if (flagLevel) {
					System.out.print(">>>" + prev.val);
					queue.add(null);
					flagLevel = false;
				} else {
					TreeNode rightNode = queue.take();
					System.out.print(">>>" + rightNode.val);
					queue.add(null);
					if (rightNode.right != null) {
						queue.add(rightNode.right);
					}
					if (rightNode.left != null) {
						queue.add(rightNode);
					}
					flagLevel = true;
				}
			} else {
				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
			}
		}
	}
}
