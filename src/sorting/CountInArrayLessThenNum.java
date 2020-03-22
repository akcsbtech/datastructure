/**
 * 
 */
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author akashgoyal
 *
 */
public class CountInArrayLessThenNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> i = new ArrayList<Integer>();
		i.add(9);
		i.add(5);
		i.add(4);
		i.add(1);
		i.add(10);
		System.out.println(findCount(i));
		System.out.println(findUsingTreeMapCount(i));
	}

	public static List<Integer> findUsingTreeMapCount(List<Integer> a) {
		TreeSet<Integer> ts = new TreeSet<Integer>(Collections.reverseOrder());
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		ts.addAll(a);
		int count = -1;
		int length = a.size();
		for (Integer i : ts) {
			tmap.put(i, (length--));
		}
		System.out.println(tmap);
		List<Integer> ii = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			Integer tcount = tmap.get(a.get(i));
			System.out.println(a.size() - tcount - 1);
			ii.add(tcount - i-1);
		}
		return ii;
	}

	public static List<Integer> findCount(List<Integer> a) {
		List<Integer> count = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			int tempCount = 0;
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i) > a.get(j)) {
					++tempCount;
				}
			}
			count.add(tempCount);
		}
		return count;
	}

}
