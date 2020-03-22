package stringmanuplation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueCharacterFromList {

	static Map<String, Boolean> status = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> str = new ArrayList<String>();
		str.add("pqr");
		str.add("abc");
		str.add("pqre");
		System.out.println(uniqueCharacter(str));

	}

	public int maxLength(List<String> arr) {
		int result[] = new int[1];
		maxUnique(arr, 0, "", result);
		return result[0];
	}

	public void maxUnique(List<String> arr, int index, String current, int[] result) {
		if (arr.size() == index && uniqueCharCount(current) > result[0]) {
			result[0] = current.length();
			return;
		}
		if (index == arr.size()) {
			return;
		}
		maxUnique(arr, index + 1, current, result);
		maxUnique(arr, index + 1, current + arr.get(index), result);

	}

	public int uniqueCharCount(String str) {
		int counts[] = new int[26];
		for (char c : str.toCharArray()) {
			if (counts[c - 'a']++ > 0) {
				return -1;
			}
		}
		return str.length();
	}

	public static int uniqueCharacter(List<String> list) {
		int result[] = new int[1];
		return findUniqueChar(list);
	}

	public static int findUniqueChar(List<String> list) {
		int maxLength = 0;
		for (int i = 0; i < list.size(); i++) {
			String resultStr = list.get(i);
			if (!isDuplicateCharacter("", resultStr)) {
				continue;
			}
			for (int j = i + 1; j < list.size(); j++) {
				if (isDuplicateCharacter(resultStr, list.get(j))) {
					resultStr = resultStr + list.get(j);
					maxLength = Math.max(resultStr.length(), maxLength);
					System.out.println("string |" + resultStr);
				}
			}
		}

		return maxLength;
	}

	public static Boolean isDuplicateCharacter(String str1, String str2) {
		HashMap<Character, Integer> map = new HashMap<>();
		if (status.get(str1 + str2) == null) {
			for (int i = 0; i < str1.length(); i++) {
				map.put(str1.charAt(i), 1);
			}
			for (int i = 0; i < str2.length(); i++) {
				if (map.get(str2.charAt(i)) == null) {
					map.put(str2.charAt(i), 1);
				} else {
					status.put(str1 + str2, false);
					return false;
				}
			}
			status.put(str1 + str2, true);
			return true;
		}
		return status.get(str1 + str2);
	}
}
