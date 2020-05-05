package leetcodeproblem.may2020;

import java.util.HashMap;

class RandomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || ransomNote.equals("")) {
			return true;
		}

		if (magazine == null || ransomNote.equals("")) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (map.get(ransomNote.charAt(i)) != null) {
				int j = map.get(ransomNote.charAt(i));
				if (j > 1) {
					map.put(ransomNote.charAt(i), --j);
				} else {
					map.remove(ransomNote.charAt(i));
				}
			} else {
				return false;
			}
		}
		return true;
	}
}