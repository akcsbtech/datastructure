package Immutability;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
	
	final private int a;
	final private Map<String,String> map;
	
	public ImmutableClass(int a,Map<String,String> map) {
		this.a=a;
		this.map=map;
		
	}
	
	public int getA() {
		return a;
	}
	
	public Map<String,String> getMap() {
		Map<String,String> mapCopy=new HashMap<String,String>();
		mapCopy.putAll(map);
		return mapCopy;
	}

	@Override
	public String toString() {
		return "ImmutableClass [a=" + a + ", map=" + map + "]";
	}
	
	

}
