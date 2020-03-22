/**
 * 
 */
package topkelement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author akashgoyal
 *
 */
public class RearrangeElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String reArrangeString(String str) {
		String output = "";
		Map<Character, Integer> unique = new HashMap<Character, Integer>();
		Map<Character, Integer> multipleCharacter = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (multipleCharacter.get(ch) == null && unique.get(ch) == null) {
				unique.put(str.charAt(i), 1);
			} else if (unique.get(ch) != null) {
				unique.remove(ch);
				multipleCharacter.put(ch, 2);
			} else {
				multipleCharacter.put(ch, multipleCharacter.get(ch) + 1);
			}
		}

		if (unique.size() + 1 < multipleCharacter.size()) {
			return output;
		} else {
			if (multipleCharacter.size() > unique.size()) {
				Iterator<Entry<Character, Integer>> iter1 = multipleCharacter.entrySet().iterator();
				Iterator<Entry<Character, Integer>> iter2 = unique.entrySet().iterator();
				while (iter1.hasNext() || iter2.hasNext()) {
					Entry<Character, Integer> e1 = iter1.next();
					Entry<Character, Integer> e2 = iter2.next();
					output = output + e1.getKey() + e2.getKey();
					if (multipleCharacter.get(e1.getKey()) > 1) {
						multipleCharacter.put(e1.getKey(), multipleCharacter.get(e1.getKey()) - 1);
					} else {
						multipleCharacter.remove(e1.getKey());
					}
					unique.remove(e2.getKey());
				}
			} else {

			}
		}

		return output;
	}

	public static String rearrangeString(String str) {
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char chr : str.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		// add all characters to the max heap
		maxHeap.addAll(charFrequencyMap.entrySet());

		Map.Entry<Character, Integer> previousEntry = null;
		StringBuilder resultString = new StringBuilder(str.length());
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
			// add the previous entry back in the heap if its frequency is greater than zero
			if (previousEntry != null && previousEntry.getValue() > 0)
				maxHeap.offer(previousEntry);
			// append the current character to the result string and decrement its count
			resultString.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue() - 1);
			previousEntry = currentEntry;
		}

		// if we were successful in appending all the characters to the result string,
		// return it
		return resultString.length() == str.length() ? resultString.toString() : "";
	}
}
