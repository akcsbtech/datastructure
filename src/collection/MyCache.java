package collection;

import java.util.HashMap;
import java.util.Map;

public class MyCache {
	private Map<String, Object> map = new HashMap<String, Object>();

	public synchronized void put(String key, Object value) {
		map.put(key, value);
	}

	public Object get(String key) {
		// can cause in an infinite loop in some JDKs!!
		return map.get(key);
	}

	public static synchronized void m1(MyCache myCache) {
		System.out.println("M1 method Call");
				m2(myCache);
	}

	public static synchronized void m2(MyCache myCache) {
		System.out.println("M2 method Call");
	}

}