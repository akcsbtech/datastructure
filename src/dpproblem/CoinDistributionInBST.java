/**
 * 
 */
package dpproblem;

/**
 * @author akashgoyal
 *
 */
public class CoinDistributionInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoinDistributionInBST coind = new CoinDistributionInBST();
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode();
		TreeNode left = new TreeNode();
		TreeNode right = new TreeNode();
		left.val = 3;
		right.val = 0;
		root.val = 0;
		root.left = left;
		root.right = right;

		System.out.println(coind.distributeCoins(root));
	}

	int ans;

	public int distributeCoins(TreeNode root) {
		ans = 0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int L = dfs(node.left);
		System.out.println("Left |" + L);
		int R = dfs(node.right);
		System.out.println("Right |" + R);
		ans += Math.abs(L) + Math.abs(R);
		System.out.println("Ans |" + (node.val + L + R - 1));
		return node.val + L + R - 1;
	}

}
