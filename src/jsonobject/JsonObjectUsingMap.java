package jsonobject;

import java.util.HashMap;
import java.util.Map;

public class JsonObjectUsingMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Object,Object> jso=new HashMap<Object,Object>();
		Map<Object,Object> jso1=new HashMap<Object,Object>();

		jso1.put(1, "akash");
		
		jso.put(1, "akash");
		jso.put("abc", "hello");
		jso.put("c", "party");
		jso.put(5, jso1);
		
		String mapValue=jso.toString();
		System.out.println("map {}"+mapValue);
	
		//Map<Object,Object> jso2=(Map<Object,Object> )mapValue;

	}

}
