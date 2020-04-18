package grokkingpattern;

public class CheckEqualString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CheckEqualString.checkString1("aa#b", "aab"));
		System.out.println(CheckEqualString.checkString1("aa#b", "ab"));
		System.out.println(CheckEqualString.checkString1("#b", "ab"));
		System.out.println(CheckEqualString.checkString1("a#b", "b"));

		System.out.println(CheckEqualString.checkString("aa#b", "aab"));
		System.out.println(CheckEqualString.checkString("aa#b", "ab"));
		System.out.println(CheckEqualString.checkString("#b", "ab"));
		System.out.println(CheckEqualString.checkString("a#b", "b"));
	}

	public static boolean checkString(String s1, String s2) {
		int end1 = s1.length() - 1;
		int end2 = s2.length() - 1;
		// "aa#b" "aab"
		int len1 = s1.length();
		int len2 = s2.length();
		while (end1 >= 0 || end2 >= 0) {
			while (end1 >= 0 && s1.charAt(end1) == '#') {
				end1 = end1 - 2;
				len1 = len1 - 2;
			}
			while (end2 >= 0 && s2.charAt(end2) == '#') {
				end2 = end2 - 2;
				len2 = len2 - 2;
			}

			if (end1 >= 0 && end2 >= 0 && s1.charAt(end1) == s2.charAt(end2)) {
				--end1;
				--end2;
			} else {
				if (len1 == len2) {
					return true;
				} else {
					return false;
				}
			}

		}
		System.out.println("Len1 |" + len1 + "|  Len2|" + len2);
		if (len1 == len2) {
			return true;
		} else {
			return false;
		}

	}

	public static Boolean checkString1(String s1, String s2) {

		if (s1 != null && s2 != null && s1.equals("") && s2.equals("")) {
			return true;
		}
		if (s1 == null || s2 == null) {
			return false;
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i < s1.length()) {
			if (i == 0 && s1.charAt(i) == '#') {
				return false;
			} else if (s1.charAt(i) == '#') {
				sb1.deleteCharAt(i - 1);
			} else {
				sb1.append(s1.charAt(i));
			}
			i++;
		}
		while (j < s2.length()) {
			if (j == 0 && s2.charAt(j) == '#') {
				return false;
			} else if (s2.charAt(j) == '#') {
				sb2.deleteCharAt(j - 1);
			} else {
				sb2.append(s2.charAt(j));
			}
			j++;
		}

		if (sb1.toString().equals(sb2.toString())) {
			return true;
		} else {
			return false;
		}

	}

}
