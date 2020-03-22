package cache;

import java.util.LinkedHashMap;
import java.util.Set;

class LRUCache1 {

	LinkedHashMap<Integer, Integer> cache = null;
	int capacity;
	int currentCapacity;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<Integer, Integer>();
		currentCapacity = 0;
	}

	public int get(int key) {
		Integer value = cache.get(key);
		if (value == null) {
			return -1;
		} else {
			cache.remove(key);
			cache.put(key, value);
			return value;
		}
	}

	public int put(int key, int value) {

		if (currentCapacity < capacity) {
			cache.put(key, value);
			++currentCapacity;
		} else {
			Set<Integer> keys = cache.keySet();
			for (Integer i : keys) {
				cache.remove(i);
				break;
			}
			cache.put(key, value);
		}
		return 0;
	}

	public static void main(String[] arg) {
		LRUCache1 cache1 = new LRUCache1(2);
		int out = 0;
		System.out.print("  " + out);
		out = cache1.put(1, 1);
		System.out.print("  " + out);
		out = cache1.put(2, 2);
		System.out.print("  " + out);

		out = cache1.get(1);
		System.out.print("  " + out);

		out = cache1.put(3, 3);
		System.out.print("  " + out);

		out = cache1.get(2);
		System.out.print("  " + out);

		out = cache1.put(4, 4);
		System.out.print("  " + out);

		out = cache1.get(1);
		System.out.print("  " + out);

		out = cache1.get(3);
		System.out.print("  " + out);

		out = cache1.get(4);
		System.out.print("  " + out);
	}
}