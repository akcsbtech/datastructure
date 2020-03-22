package stringmanuplation;

public class FindPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "abcdabcdab";
		String pattern = "dab";

		System.out.println("Find Pattern |" + findPattern(text, pattern));
		System.out.println("Find Pattern |" + findOccurences(text, pattern));
	}

	public static int findPattern(String text, String pattern) {
		char[] textChar = text.toCharArray();
		char[] patternChar = pattern.toCharArray();

		for (int i = 0; i < textChar.length - patternChar.length + 1; i++) {
			int previous = i;
			for (int j = 0; j < patternChar.length; j++) {
				if (textChar[i] == patternChar[j]) {
					++i;
				} else {
					i = previous;
					break;
				}

				if (j == patternChar.length - 1) {
					return 1;
				}
			}

		}
		return -1;
	}

	public static int findOccurences(String text, String pattern) {
		char[] textChar = text.toCharArray();
		char[] patternChar = pattern.toCharArray();
		int occurence = 0;
		for (int i = 0; i < textChar.length - patternChar.length + 1; i++) {
			int previous = i;
			for (int j = 0; j < patternChar.length; j++) {
				if (textChar[i] == patternChar[j]) {
					++i;
				} else {
					i = previous;
					break;
				}

				if (j == patternChar.length - 1) {
					++occurence;
					i = previous;
					break;
				}
			}

		}
		return occurence;
	}

}
