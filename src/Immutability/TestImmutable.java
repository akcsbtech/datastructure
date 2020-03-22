package Immutability;

import java.util.HashMap;
import java.util.Map;

public class TestImmutable {
	public static void main(String [] arg) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("Test1","A");
		map.put("Test2","B");
		map.put("Test3","C");
		
		ImmutableClass ic=new ImmutableClass(10,map);
		
		System.out.println(ic);
		ic.getMap().put("10","20");
		System.out.println(ic);
	}

}
