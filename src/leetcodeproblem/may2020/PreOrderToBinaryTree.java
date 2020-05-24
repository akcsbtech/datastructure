package leetcodeproblem.may2020;

class PreOrderToBinaryTree {
	public static void main(String [] arg) {
		int a[]= {8,5,1,7,10,12};
		TreeNode root=bstFromPreorder(a);
		preOrder(root);
	}
	public static void preOrder(TreeNode root) {
		
		if(root==null) return;
		System.out.print("->  "+root.val);
		preOrder(root.left);
		preOrder(root.right);
		
	}
	public static TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root=null;
		if (preorder.length == 0) {
			return root;
		}

		if (preorder.length >= 1) {
			root = new TreeNode(preorder[0]);
		}
		for (int i = 1; i < preorder.length; i++) {
			TreeNode temp = root;
			TreeNode node = new TreeNode(preorder[i]);
			while (temp.val > preorder[i]) {
				if (temp.left == null) {
					temp.left = node;
					break;
				} else {
					temp = temp.left;
				}
			}
			while (temp.val < preorder[i]) {
				if (temp.right == null) {
					temp.right = node;
					break;
				} else {
					temp = temp.right;
				}
			}
		}
		return root;
	}
}