package tree;

import java.util.HashMap;

import dpproblem.TreeNode;

public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int position=5;
		//System.out.println(x -> position);
	}

	int max_width = 0;
	HashMap<Integer, Integer> left_mostPositions;

	public int widthOfBinaryTree(TreeNode root) {
		left_mostPositions = new HashMap<>();
		get_width(root, 0, 0);
		return max_width;
	}

	public void get_width(TreeNode node, int depth, int position) {
		if (node == null)
			return;

		left_mostPositions.computeIfAbsent(depth, x -> position);
		max_width = Math.max(max_width, position - left_mostPositions.get(depth) + 1);
		get_width(node.left, depth + 1, position * 2);
		get_width(node.right, depth + 1, position * 2 + 1);

	}

}
