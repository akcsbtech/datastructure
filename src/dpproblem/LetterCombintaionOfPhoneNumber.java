package dpproblem;

import java.util.ArrayList;

public class LetterCombintaionOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombination("23"));
	}

	public static ArrayList<String> letterCombination(String digits) {
		ArrayList<String> results = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return results;
		}

		String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		letterCombinationRecursive(results, digits, "", 0, mappings);
		return results;
	}

	public static void letterCombinationRecursive(ArrayList<String> results, String digits, String current, int index,
			String[] mapping) {

		if (index == digits.length()) {
			results.add(current);
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];

		for (int i = 0; i < letters.length(); i++) {
			letterCombinationRecursive(results, digits, current + letters.charAt(i), index + 1, mapping);
		}
	}

}
