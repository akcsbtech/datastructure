package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrderTraversal {
	
	public static void main(String [] arg) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		System.out.println(levelOrderBottom(root));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		TreeNode dummyNode = new TreeNode(-1);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(dummyNode);

		while (!queue.isEmpty()) {
			System.out.println(queue.size()+"   "+result+"  "+item);
			TreeNode temp = queue.remove();
			if (temp.val == -1) {
				if(item.size()==0)
					break;
				result.add(item);
				item = new ArrayList<>();
				queue.add(dummyNode);
			} else {
				item.add(temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}

		}
		List<List<Integer>> finalResult = new ArrayList<>();
		Collections.reverse(result);
		System.out.println(result);
		return result;
	}
}
