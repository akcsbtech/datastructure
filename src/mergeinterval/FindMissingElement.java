package mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = { 1, 2, 3, 4, 5, 10 };
		Integer b[] = { 2, 3, 1, 0, 5 };
		System.out.println(findMissingElement(a, b));

		System.out.println(findMissingElementUsingSort(Arrays.asList(a), Arrays.asList(b)));

		Integer c[] = { 4, 3, 5, 9, 11 };
		Integer d[] = { 4, 9, 3, 11, 10 };

		System.out.println(findMissingElement(c, d));
		System.out.println(findMissingElementUsingSort(Arrays.asList(c), Arrays.asList(d)));

	}

	public static List<Integer> findMissingElementUsingSort(List<Integer> a, List<Integer> b) {

		Collections.sort(a);
		Collections.sort(b);
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		// Integer a[] = {1, 2, 3, 4, 5, 10 };
		// Integer b[] = {0,1, 2, 3, 5 };
		while (i < a.size() && j < b.size()) {
			if (a.get(i) == b.get(j)) {
				++i;
				++j;
			} else if (a.get(i) < b.get(j)) {
				result.add(a.get(i));
				++i;
			} else {
				++j;
			}
		}
		while (i < a.size()) {
			result.add(a.get(i));
			++i;
		}
		return result;
	}

	public static Set<Integer> findMissingElement(Integer[] a, Integer[] b) {
		HashMap<Integer, Integer> ii = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			ii.put(a[i], 1);
		}

		for (int i = 0; i < b.length; i++) {
			ii.remove(b[i]);
		}
		return ii.keySet();
	}
}
