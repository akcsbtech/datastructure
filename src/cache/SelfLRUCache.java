package cache;

import java.util.HashMap;

public class SelfLRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<Integer, Entry> hashmap;
	Entry start, end;
	int LRU_SIZE = 4;
	// Here i am setting 4 to test the LRU cache
	// implementation, it can make be dynamic

	public SelfLRUCache() {
		hashmap = new HashMap<Integer, Entry>();
	}

	public int getEntry(int key) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the
		{
			Entry entry = hashmap.get(key);
			removeNode(entry);
			addAtTop(entry);
			return entry.value;
		}
		return -1;
	}

	public void removeNode(Entry node) {

		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}

	public void putEntry(int key, int value) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the value and move it to top
		{
			Entry entry = hashmap.get(key);
			entry.value = value;
			removeNode(entry);
			addAtTop(entry);
		} else {
			Entry newnode = new Entry();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			if (hashmap.size() > LRU_SIZE) // We have reached maxium size so need to make room for new element.
			{
				hashmap.remove(end.key);
				removeNode(end);
				addAtTop(newnode);

			} else {
				addAtTop(newnode);
			}

			hashmap.put(key, newnode);
		}
	}

	public void addAtTop(Entry node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}
}
