package Immutability;

import java.util.HashMap;
import java.util.Map;

public class HashCodeConcept {

	public static void main(String[] arg) throws IllegalAccessException {
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");

		String ph = m.get(new PhoneNumber(707, 867, 5309));
		String ph1 = m.get(new PhoneNumber(707, 867, 5300));

		System.out.println("Object found " + ph+"| ph1 |"+ph1);
		System.out.println("Map Data :{}" + m);
	}
}
