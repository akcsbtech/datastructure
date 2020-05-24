package leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

class LongestSubStringWithOutRepeat {
	public static void main(String[] arg) {
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("  "));
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}

	public static  int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0 || s.equals("")) {
			return 0;
		}
		if (s.equals(" ")) {
			return 1;
		}
		int start = 0;
		int maxLength = Integer.MIN_VALUE;
		int end = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (end < s.length()) {
			System.out.println(map +"  "+end );
			if (map.get(s.charAt(end)) == null) {
				map.put(s.charAt(end), 1);
				++end;
				maxLength = Math.max(maxLength, end - start);
			} else {
				while (start <= end) {
					map.remove(s.charAt(start));
					if (s.charAt(end) == s.charAt(start)) {
						++start;
						break;
					}else {
						++start;
					}
				}
			}
		}
		return maxLength;
	}
}