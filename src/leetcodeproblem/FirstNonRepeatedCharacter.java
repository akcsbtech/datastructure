package leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNonRepeatedChar(null));
		System.out.println(findNonRepeatedChar("a"));
		System.out.println(findNonRepeatedChar("aabcdeddee"));

	}

	public static Character findNonRepeatedChar(String s) {
		if (s == null) {
			return '@';
		}
		if (s.length() == 1) {
			return s.charAt(0);
		}

		Map<Character, Integer> frequency = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (frequency.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
		}
		return '@';
	}
}
