package tree;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import dpproblem.TreeNode;

public class PrintZigZag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode();
		TreeNode t2 = new TreeNode();
		TreeNode t3 = new TreeNode();
		TreeNode t4 = new TreeNode();

		TreeNode t5 = new TreeNode();
		TreeNode t6 = new TreeNode();
		TreeNode t7 = new TreeNode();
		TreeNode t8 = new TreeNode();
		t4.left = t8;
		t3.left = t6;
		t3.right = t7;
		t2.right = t5;
		t2.left = t4;
		t1.right = t3;
		t1.left = t2;
		t1.val = 1;
		t2.val = 2;
		t3.val = 3;
		t4.val = 4;
		t5.val = 5;
		t6.val = 6;
		t7.val = 7;
		t8.val = 8;
		zigzag(t1);
	}

	public static void zigzag(TreeNode root) throws InterruptedException {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(root.val);
		}

		ArrayBlockingQueue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(20);
		ArrayBlockingQueue<TreeNode> queue2 = new ArrayBlockingQueue<TreeNode>(20);

		queue.add(root);
		System.out.print(">>>" + root.val);
		TreeNode test = new TreeNode();
		test.val = -1;
		queue.add(test);
		boolean leftToRight = true;
		TreeNode node = null;
		while (!queue.isEmpty()) {
			if (leftToRight) {
				node = queue.poll();
				while (node.val == -1) {
					queue2.add(node);

					if (node.right != null)
						queue.add(node.right);
					if (node.left != null)
						queue.add(node.left);

					node = queue.poll();
				}

				while (!queue2.isEmpty()) {
					node = queue2.poll();
					System.out.print(">>" + node.val);

				}
				queue.add(test);
				leftToRight = false;
			} else {
				node = queue.poll();
				while (node.val != -1) {
					System.out.print(">>" + node.val);
					if (node.right != null)
						queue.add(node.right);
					if (node.left != null)
						queue.add(node.left);

					node = queue.poll();
				}
				queue.add(test);
				leftToRight = true;
			}

		}
	}
}
