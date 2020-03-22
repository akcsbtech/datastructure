/**
 * 
 */
package mostfrequentitem;

/**
 * @author akashgoyal
 *
 */
public class KFrequentWordInBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TrieNode newTrieNode() {
		TrieNode trieNode = new TrieNode();
		trieNode.frequency = 0;
		trieNode.indexMinHeap = -1;
		trieNode.isEnd = false;

		return trieNode;
	}

	public MinHeap createMinHeap(int capacity) {
		MinHeap minHeap = new MinHeap();
		minHeap.capacity = capacity;
		minHeap.count = 0;
		minHeap.minHeapNode = new MinHeapNode[capacity];
		return minHeap;
	}

	public void swapMinHeapNode(MinHeapNode m1, MinHeapNode m2) {
		MinHeapNode temp = m1;
		m1 = m2;
		m2 = temp;
	}

	public void minHeapify(MinHeap minHeap, int idx) {
		int left, right, smallest;
		left = 2 * idx + 1;
		right = 2 * idx + 2;
		smallest = idx;

		if (left < minHeap.count && minHeap.minHeapNode[left].frequency < minHeap.minHeapNode[smallest].frequency) {
			smallest = left;
		}

		if (right < minHeap.count && minHeap.minHeapNode[right].frequency < minHeap.minHeapNode[smallest].frequency) {
			smallest = right;
		}

		if (smallest != idx) {
			minHeap.minHeapNode[smallest].root.indexMinHeap = idx;
			minHeap.minHeapNode[idx].root.indexMinHeap = smallest;

			swapMinHeapNode(minHeap.minHeapNode[smallest], minHeap.minHeapNode[idx]);
			minHeapify(minHeap, smallest);
		}

	}

	public void buildMinHeap(MinHeap minHeap) {
		int n, i;
		n = minHeap.count - 1;

		for (i = (n - 1) / 2; i >= 0; --i) {
			minHeapify(minHeap, i);
		}
	}

	public void insertInMinHeap(MinHeap minHeap, TrieNode root, String word) {
		if (root.indexMinHeap != -1) {
			++(minHeap.minHeapNode[root.indexMinHeap].frequency);
			minHeapify(minHeap, root.indexMinHeap);
		} else if (minHeap.count < minHeap.capacity) {
			int count = minHeap.count;
			minHeap.minHeapNode[count].frequency = root.frequency;
			minHeap.minHeapNode[count].word = word;
			minHeap.minHeapNode[count].root = root;
			root.indexMinHeap = minHeap.count;
			++minHeap.count;
			buildMinHeap(minHeap);
		} else if (root.frequency > minHeap.minHeapNode[0].frequency) {
			minHeap.minHeapNode[0].root.indexMinHeap = -1;
			minHeap.minHeapNode[0].root = root;
			minHeap.minHeapNode[0].root.indexMinHeap = 0;
			minHeap.minHeapNode[0].frequency = root.frequency;
			
			
		}
	}
}
