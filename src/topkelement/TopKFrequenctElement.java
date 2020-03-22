/**
 * 
 */
package topkelement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akashgoyal
 *
 */
public class TopKFrequenctElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> result = TopKFrequenctElement.topKFrequentElement(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);

		result = TopKFrequenctElement.topKFrequentElement(new int[] { 5, 11, 3,3,3, 11,12,12,24,35,23,23,11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}

	public static List<Integer> topKFrequentElement(int[] nums, int k) {
		Map<Integer, Integer> numFrequencyMap = new HashMap<>();
		for (int n : nums)
			numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> kFrequentItem = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(e1, e2) -> e1.getValue() - e2.getValue());

		for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
			kFrequentItem.add(entry);
			if (kFrequentItem.size() > k) {
				kFrequentItem.poll();
			}

		}
		List<Integer> topNumbers = new ArrayList<>(k);

		while (!kFrequentItem.isEmpty()) {
			topNumbers.add(kFrequentItem.poll().getKey());
		}
		return topNumbers;

	}

}
