package cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
	
	public static void main(String [] arg) {
		Map<String, String> lmap=new LinkedHashMap<String, String>();
		lmap.put("1","1");
		lmap.put("2","1");
		lmap.put("3","2");
		lmap.put("4","1");
		lmap.put("5","1");
		System.out.println(lmap);
	
		Map<String, String> lmap1=new HashMap<String, String>();
		lmap1.put("1","1");
		lmap1.put("2","1");
		lmap1.put("3","2");
		lmap1.put("4","1");
		lmap1.put("5","1");
		System.out.println(lmap1);
	}

}
