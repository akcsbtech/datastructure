package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("abccde"));
		
		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength1("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength1("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength1("abccde"));

	}

	public static int findLength(String str) {
		int maxLength = 0;
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> fre = new HashMap<Character, Integer>();

		for (end = 0; end < str.length(); end++) {
			if (fre.get(str.charAt(end)) == null) {
				fre.put(str.charAt(end), 1);
			} else {
				fre.put(str.charAt(end), fre.get(str.charAt(end)) + 1);
				while (start <= end) {
					if (str.charAt(end) == str.charAt(start)) {
						if (fre.get(str.charAt(end)) >= 2) {
							fre.put(str.charAt(end), fre.get(str.charAt(end)) - 1);
							++start;
							break;
						}
					} else {
						fre.remove(str.charAt(start));
						++start;
					}

				}
			}
			maxLength = Math.max(maxLength, fre.size());
		}
		return maxLength;
	}

	public static int findLength1(String str) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>();
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// if the map already contains the 'rightChar', shrink the window from the
			// beginning so that
			// we have only one occurrence of 'rightChar'
			if (charIndexMap.containsKey(rightChar)) {
				// this is tricky; in the current window, we will not have any 'rightChar' after
				// its previous index
				// and if 'windowStart' is already ahead of the last index of 'rightChar', we'll
				// keep 'windowStart'
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
			}
			charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}

		return maxLength;
	}
}
