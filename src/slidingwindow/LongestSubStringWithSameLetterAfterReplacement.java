package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLetterAfterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestSubStringWithSameLetterAfterReplacement.findLength("aabccbb", 2));
		System.out.println(LongestSubStringWithSameLetterAfterReplacement.findLength("abbcb", 1));
		System.out.println(LongestSubStringWithSameLetterAfterReplacement.findLength("abccde", 1));
	}

	public static int findLength(String str, int K) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int start = 0;
		int maxLength = 0;
		int temp = K;
		int tempstart = 0;
		for (int end = 1; end < str.length(); end++) {
			// System.out.println(end + " " + start + " " + temp + " " + tempstart);
			// System.out.println(str.charAt(start) + " " + str.charAt(end));
			if (str.charAt(end) != str.charAt(start)) {
				--temp;
			}
			if (str.charAt(end) == str.charAt(start) && end == start + 1) {
				++tempstart;
			}
			if (temp == -1 || end == str.length() - 1) {
				maxLength = Math.max(maxLength, end - start + 1);
				System.out.println(" subStrng |" + str.substring(start, end) + "| start |" + start + " | end |" + end);
				start = tempstart;
				end = ++start;
				temp = K;
				tempstart = start;
			}
		}
		return maxLength;
	}

	public static int findLength1(String str, int k) {
		int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
		Map<Character, Integer> letterFrequencyMap = new HashMap<>();
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

			// current window size is from windowStart to windowEnd, overall we have a
			// letter which is
			// repeating 'maxRepeatLetterCount' times, this means we can have a window which
			// has one letter
			// repeating 'maxRepeatLetterCount' times and the remaining letters we should
			// replace.
			// if the remaining letters are more than 'k', it is the time to shrink the
			// window as we
			// are not allowed to replace more than 'k' letters
			if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
				char leftChar = str.charAt(windowStart);
				letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
				windowStart++;
			}

			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}

}
