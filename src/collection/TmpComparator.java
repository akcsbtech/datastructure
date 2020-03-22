package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class TmpComparator {
	static Comparator<Studentfrequency> smc = new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			Studentfrequency sm1 = (Studentfrequency) o1, sm2 = (Studentfrequency) o2;

			int frequencyFlag = sm2.frequency.compareTo(sm1.frequency);
			return (frequencyFlag == 0) ? sm1.id.compareTo(sm2.id) : frequencyFlag;
		}
	};

	static class Studentfrequency {
		private Integer id;
		private Integer frequency;

		public Studentfrequency(Integer id, Integer frequency) {
			this.id = id;
			this.frequency = frequency;
		}

		@Override
		public boolean equals(Object o) {
			Studentfrequency osm = (Studentfrequency) o;
			return id == osm.id && frequency.equals(osm.frequency);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, frequency);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Formatter fm = new Formatter(sb);

			fm.format("id = %d, frequency = %s\n", id, frequency);

			fm.close();
			return sb.toString();
		}
	}

	public static void test() {
		/*
		 * final Set<Studentfrequency> smSet = new TreeSet<>(smc);
		 * 
		 * smSet.add(new Studentfrequency(146, 1)); smSet.add(new Studentfrequency(148,
		 * 2)); smSet.add(new Studentfrequency(110, 3)); smSet.add(new
		 * Studentfrequency(6, 4)); smSet.add(new Studentfrequency(14, 8));
		 * smSet.add(new Studentfrequency(26, 6));
		 * 
		 * for (Studentfrequency sm : smSet) { System.out.print(sm); }
		 */
		/*
		 * final Map<Integer, Studentfrequency> smSet = new TreeMap<Integer,
		 * Studentfrequency>();
		 * 
		 * smSet.put(146, new Studentfrequency(146, 1)); smSet.put(148, new
		 * Studentfrequency(148, 2)); smSet.put(110, new Studentfrequency(110, 3));
		 * smSet.put(6, new Studentfrequency(6, 4)); smSet.put(14, new
		 * Studentfrequency(14, 8)); smSet.put(326, new Studentfrequency(326, 6));
		 * Set<Integer> smSet1 = smSet.keySet(); for (Integer sm : smSet1) {
		 * System.out.print(sm + "    "); System.out.println(smSet.get(sm)); }
		 */
		final Map<Integer, Integer> smSet = new HashMap<Integer, Integer>();

		smSet.put(146, 1);
		smSet.put(148, 2);
		smSet.put(110, 3);
		smSet.put(6, 4);
		smSet.put(14, 8);
		smSet.put(326, 6);

		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(smSet.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
	
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey())
						: o2.getValue() - o1.getValue();

			}

		});
		for (Entry<Integer, Integer> entry : entries)
			System.out.println(entry.getKey() + " - " + entry.getValue());
		/*
		 * smSet.entrySet().stream() .sorted( (a, b) ->
		 * a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) :
		 * Integer.compareTo(b.getValue(), a.getValue())) .map(e -> entry.getKey() +
		 * " - " + entry.getValue()) .forEach(System.out::println);
		 */
	}

	public static void main(String[] args) {
		test();
	}
}