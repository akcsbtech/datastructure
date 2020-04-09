package leetcodeproblem;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("ab-cd"));
	}

	public static String reverseString(String s) {
		if (s == null) {
			return "-";
		} else if (s.length() == 1) {
			return s;
		}

		int start = 0;
		int end = s.length() - 1;
		char[] ch = s.toCharArray();
		while (start < end) {
			if (ch[start] >= 97 && ch[start] <= 122 && ch[end] >= 97 && ch[end] <= 122) {
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				++start;
				--end;
			} else if (!(ch[start] >= 97 && ch[start] <= 122)) {
				++start;
			} else if (!(ch[end] >= 97 && ch[end] <= 122)) {
				--end;
			}
		}
		System.out.println(ch.toString());
		return new String(ch);
	}

}
