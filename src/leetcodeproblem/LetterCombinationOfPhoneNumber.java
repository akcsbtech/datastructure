package leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allPossibleCombinationOfDigit("12"));
		System.out.println(allPossibleCombinationOfDigit("23"));

		
	}

	public static List<String> allPossibleCombinationOfDigit(String s) {
		List<String> result = new ArrayList<String>();
		String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		findRecursiveString(s, result, "", 0, mapping);
		return result;
	}

	public static void findRecursiveString(String digit, List<String> result, String curr, int index,
			String[] mapping) {
		if (index == digit.length()) {
			result.add(curr);
			return;
		}
		String letters = mapping[digit.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			findRecursiveString(digit, result, curr + letters.charAt(i), index + 1, mapping);
		}
	}

}
