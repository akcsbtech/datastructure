package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class HashMapUsingLinkedList {
	MapNode start, end;
	List<Integer> keys = new ArrayList<Integer>();

	public static void main(String[] arg) {
		HashMapUsingLinkedList hmap = new HashMapUsingLinkedList();
		hmap.put(1, 10);
		hmap.put(2, 20);
		hmap.put(3, 30);
		hmap.put(1, 20);
		hmap.put(4, 40);
		hmap.put(5, 50);
		hmap.put(1, 60);
		
		while (hmap.start != null && hmap.end != null) {
			System.out.println(hmap.start.key + "  " + hmap.start.value);
			hmap.start = hmap.start.next;
		}
	}

	public void put(Integer key, Integer value) {
		if (!keys.contains(key)) {
			keys.add(key);
			MapNode node = new MapNode();
			node.key = key;
			node.value = value;
			if (start == null) {
				start = node;
				end = node;
			} else {
				MapNode temp = end;
				end.next = node;
				end = node;

			}
		}
	}

}
