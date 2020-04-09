package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeStringUsingHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Rearrange String :" + rearrangeString("aaaabbcc"));
		System.out.println("Rearramge String :" + rearrangeString("aaabb"));
		System.out.println("Rearramge String :" + rearrangeString("aaab"));
		System.out.println("Rearramge String :" + rearrangeString("aaaccbbbb"));

	}

	public static String rearrangeString(String s) {

		if (s.length() <= 1) {
			return s;
		}
		HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
		}

		// aaaabbcc
		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(
				(c1, c2) -> frequency.get(c2) - frequency.get(c1));
		maxHeap.addAll(frequency.keySet());
		StringBuilder ss = new StringBuilder();
		while (maxHeap.size() > 1) {
			Character curr = maxHeap.remove();
			Character next = maxHeap.remove();
			ss.append(curr);
			ss.append(next);

			frequency.put(curr, frequency.get(curr) - 1);
			frequency.put(next, frequency.get(next) - 1);

			if (frequency.get(curr) > 0) {
				maxHeap.add(curr);
			}
			if (frequency.get(next) > 0) {
				maxHeap.add(next);
			}
		}
		if (maxHeap.size() > 0) {
			Character curr = maxHeap.remove();
			ss.append(curr);
			if (maxHeap.size() > 0 || frequency.get(curr) > 1) {
				return "";
			}
		}
		return ss.toString();
	}

}
