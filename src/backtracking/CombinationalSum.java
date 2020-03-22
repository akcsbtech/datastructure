/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author akashgoyal
 *
 */
public class CombinationalSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> items = new ArrayList<Integer>();
		items.add(5);
		items.add(10);
		items.add(12);
		items.add(13);
		items.add(15);
		items.add(18);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		combinationSum(items, result, curr, 30, 0);
		System.out.println(result);

		List<List<Integer>> unique = combinationSum2(items, 30);
		System.out.println(unique);

	}

	public static List<List<Integer>> combinationSum2(List<Integer> candidates, int target) {
		Collections.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		backTrack(result, list, candidates, target, 0);

		return result;
	}

	private static void backTrack(List<List<Integer>> result, List<Integer> list, List<Integer> candidates, int target,
			int position) {
		int sum = 0;
		for (int x : list) {
			sum += x;
		}

		if (sum == target) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		if (sum < target) {
			for (int i = position; i < candidates.size(); i++) {
				if (position != i && candidates.get(i) == candidates.get(i - 1)) {
					continue;
				}
				list.add(candidates.get(i));
				backTrack(result, list, candidates, target, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void combinationSum(List<Integer> items, List<List<Integer>> result, List<Integer> currList, int sum,
			int i) {
		if (sum < 0) {
			return;
		}
		if (sum == 0) {
			List<Integer> list = new ArrayList<>(currList);
			result.add(list);
			return;
		}
		while (i < items.size() && sum - items.get(i) >= 0) {
			currList.add(items.get(i));
			combinationSum(items, result, currList, sum - items.get(i), i);
			currList.remove(currList.size() - 1);
			i++;
		}
	}

}
