/**
 * 
 */
package java8.functionalInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b0218163
 *
 */
public class FunctionalInterfaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		System.out.println(value +"  "+nameMap);

	}

}
