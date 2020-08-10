package leetcodeproblem;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		// System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("0P"));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.equals(""))
			return true;

		int start = 0;
		int end = s.length() - 1;
		s = s.toLowerCase();
		System.out.println(s);
		while (start < end) {
			System.out.println("start |" + start + "|  end |" + end);
			if (!( (s.charAt(start) >= 'a' && s.charAt(start) <= 'z')
					|| (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
				System.out.println("start |" + start + " Char |" + s.charAt(start));
				++start;
				continue;
			}
			if (!((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
				System.out.println("end |" + end);
				--end;
				continue;
			}
			System.out.println("start |" + start + "|  end |" + end);
			if (s.charAt(end) == s.charAt(start)) {
				++start;
				--end;
			} else {
				return false;
			}
		}
		return true;

	}

}
