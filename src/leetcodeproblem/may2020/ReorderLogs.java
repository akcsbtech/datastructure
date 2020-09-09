package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ReorderLogs {
	public static void main(String[] arg) {
		String args[] = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		System.out.println(reorderLogFiles(args));
	}

	public String[] reorderLogFiles1(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			if (!isDigit1 && !isDigit2) {
				int cmp = split1[1].compareTo(split2[1]);
				if (cmp != 0)
					return cmp;
				return split1[0].compareTo(split2[0]);
			}
			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		});
		return logs;
	}

	public static String[] reorderLogFiles(String[] logs) {
		ArrayList<String> digits = new ArrayList<String>();
		ArrayList<String> letters = new ArrayList<String>();

		for (int i = 0; i < logs.length; i++) {
			if (logs[i].split(" ")[1].charAt(0) < 'a') {
				digits.add(logs[i]);
			} else {
				letters.add(logs[i]);
			}
		}

		Collections.sort(letters, (o1, o2) -> {
			String[] s1 = o1.split(" ");
			String[] s2 = o2.split(" ");
			int len1 = s1.length;
			int len2 = s2.length;
			for (int i = 1; i < Math.min(len1, len2); i++) {
				if (!s1[i].equals(s2[i])) {
					return s1[i].compareTo(s2[i]);
				}
			}
			return s1[0].compareTo(s2[0]);
		});

		int count = 0;

		while (count < letters.size()) {
			logs[count] = letters.get(count);
			count++;
		}

		int i = 0;
		while (i < digits.size()) {
			logs[count] = digits.get(i);
			count++;
			i++;
		}

		return logs;
	}
}