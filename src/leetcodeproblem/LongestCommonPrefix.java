package leetcodeproblem;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "aaa", "aab", "aab", "aa" };
		System.out.println(longestCommonPrefix(str));
	}

	public static String longestCommonPrefix(String[] str) {
		if (str == null || str.length == 0) {
			return null;
		}
		String longestCommonPrefix = str[0];

		for (int i = 1; i < str.length; i++) {
			int j = 0;
			String temp = "";
			while (longestCommonPrefix.length() > j && str[i].length() > j
					&& longestCommonPrefix.charAt(j) == str[i].charAt(j)) {
				temp = temp + longestCommonPrefix.charAt(j);
				++j;
			}
			longestCommonPrefix = temp;
		}
		return longestCommonPrefix;

	}
}
