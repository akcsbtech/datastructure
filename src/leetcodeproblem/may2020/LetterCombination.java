package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombination {
	public static void main(String [] arg) {
		System.out.println(letterCombinations("23"));
	}
	public static  List<String> letterCombinations(String digits) {
		Map<Integer, String> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		if (digits == null || digits.equals(""))
			return result;
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");

		helper(digits, map, result);
		return result;
	}

	public static  void helper(String input, Map<Integer, String> map, List<String> result) {

		for (int i = 0; i < input.length(); i++) {
			String str = map.get(input.charAt(i) - 48);

			List<String> chs = new ArrayList<>();
			for (int j = 0; j < str.length(); j++) {
				chs.add(str.charAt(j) + "");
			}
			if (result.size() == 0) {
				result.addAll(chs);
			} else {
				List<String> res = new ArrayList<>();
				for (String s : result) {
					for (String ch : chs) {
						res.add(s + ch);
					}
				}
				System.out.println(res);
				result.clear();
				result.addAll(res);
				System.out.println(result);
			}

		}
	}
}