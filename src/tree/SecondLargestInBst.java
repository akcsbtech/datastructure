/**
 * 
 */
package tree;

/**
 * @author akashgoyal
 *
 */
public class SecondLargestInBst {

	Node root;

	public static void main(String[] arg) {
		SecondLargestInBst tree = new SecondLargestInBst();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.secondLargest(tree.root);
	}

	public SecondLargestInBst() {
		root = null;
	}

	public void insert(int data) {
		this.root = this.insert(this.root, data);
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			this.root = new Node(data);
			return this.root;
		}

		if (data < node.data) {
			node.left = this.insert(node.left, data);
		} else {
			node.right = this.insert(node.right, data);
		}
		return node;
	}

	public class Count {
		int c = 0;
	}

	public void secondLargestUtil(Node node, Count count) {

		if (node == null || count.c >= 2) {
			return;
		}

		this.secondLargestUtil(node.right, count);
		count.c++;

		if (count.c == 2) {
			System.out.println("Second Largest :" + node.data);
			return;
		}
		this.secondLargestUtil(node.left, count);
	}

	public void secondLargest(Node node) {
		Count c = new Count();
		this.secondLargestUtil(node, c);
	}
}
