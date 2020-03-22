/**
 * 
 */
package collection;

import java.util.LinkedHashMap;

/**
 * @author akashgoyal
 *
 */
public class LinkedHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap< String, String> cache=new LinkedHashMap<String, String>(5);
		cache.put("1","1");
		cache.put("2","2");
		cache.put("3","3");
		cache.put("4","4");
		cache.put("5","5");
		cache.put("6","6");
		
		System.out.println(cache);

	}

}
