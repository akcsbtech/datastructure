package heap;

import java.util.ArrayList;
import java.util.List;

public class PartitionLevels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLevels("ababcbacadefegdehijhklij"));
	}

	public static List<Integer> partitionLevels(String s) {
		List<Integer> list = new ArrayList<Integer>();
		int[] chars = new int[26];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a'] = i;
		}
		int i = 0;
		int end = 0;
		while (i < s.length()) {
			end = chars[s.charAt(i) - 'a'];
			int j = i;
			while (j != end) {
				end = Math.max(end, chars[s.charAt(j++) - 'a']);
			}
			list.add(j - i + 1);
			i = j + 1;
		}
		return list;

	}

}
