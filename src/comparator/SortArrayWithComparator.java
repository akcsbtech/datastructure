/**
 * 
 */
package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author akashgoyal
 *
 */
public class SortArrayWithComparator {

	/**
	 * @param args
	 */
	static class Url implements Comparable<Url> {
		String url;
		int count;

		public Url(String url, int count) {
			this.url = url;
			this.count = count;
		}

		public boolean equals(Object oo) {
			Url u = (Url) oo;
			if (this.url.equals(u.url)) {
				return true;
			} else {
				return false;
			}
		}

		public int hashcode(Object oo) {
			Url u = (Url) oo;
			return u.url.hashCode();
		}

		public int compareTo(Url o) {
			Url u = (Url) o;

			if (u.count > this.count) {
				return 1;
			} else if (u.count == this.count && u.url.compareTo(this.url) > 0) {
				return 1;
			} else if (u.count == this.count && u.url.compareTo(this.url) == 0) {
				return 0;
			}
			return -1;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url = { "www.google.com", "www.hackerrank.com", "www.google.com", "www.ajio.com", "www.hackerrank.com",
				"www.abc.com" };
		printUrlAccordingToFreq(url);
	}

	public static void printUrlAccordingToFreq(String[] urls) {
		ArrayList<Url> list = new ArrayList<Url>();

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < urls.length; i++) {
			Url url = new Url(urls[i], 1);
			if (list.contains(url)) {
				int index = list.indexOf(url);
				Url u1 = list.get(index);
				u1.count = ++u1.count;
				list.add(u1);
			} else {
				list.add(url);
			}
			/*
			 * Integer ii = map.putIfAbsent(urls[i], 1);
			 * 
			 * if (ii != null) { map.put(urls[ii], ++ii); }
			 */
		}
		/*
		 * System.out.println(map); Set<String> keys = map.keySet(); for (String ss :
		 * keys) { list.add(new Url(ss, map.get(ss))); }
		 */
		Collections.sort(list);
		System.out.println(list.size());

		for (Url ll : list) {
			System.out.println(ll.url);
		}
	}

}
