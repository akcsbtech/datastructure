package dpproblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class KthSmallestItemInSortedMatrix {
	class Node {
		int x;
		int y;
		int val;

		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public int kthSmallest1(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || k <= 0) {
			return 0;
		}
		int n = matrix.length;
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.val - b.val;
			}
		});

		// Initialize the queue with head elements
		for (int i = 0; i < n; i++) {
			queue.offer(new Node(i, 0, matrix[i][0]));
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (k == 1) {
				return node.val;
			}
			if (node.y + 1 < n) {
				queue.offer(new Node(node.x, node.y + 1, matrix[node.x][node.y + 1]));
			}
			k--;
		}

		return 0;
	}
	
	public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) return -1;
        
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int target = min + (max - min) / 2;
            int count = countSmallerItem(matrix, target);
            if (count < k) { // need larger target
                min = target + 1; // target is counted, skip over
            } else {
                max = target;
            }
        }
        return min;
    }
    
    // O(n)
    private int countSmallerItem(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int i = 0, j = n - 1; // n*n
        while (i < n && j >= 0) {
            if (matrix[i][j] > target) { //item too large, skip
                j--;
            } else { // meet requirement, add (j+1) since j is 0-based, also move on to next row
                count += j + 1;
                i++;
            }
        }
        return count;
    }
}