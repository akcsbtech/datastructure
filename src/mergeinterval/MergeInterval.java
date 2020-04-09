package mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : MergeInterval.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : MergeInterval.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		System.out.print("Merged intervals: ");
		for (Interval interval : MergeInterval.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

	public static class MinMax {
		int min;
		int max;

		public MinMax(int min, int max) {
			this.max = max;
			this.min = min;
		}

	}

	public static List<MinMax> mergeInterval(int[][] a) {
		int i = 0;
		int j = 0;
		List<MinMax> ll = new ArrayList<>();
		while (i < a.length && j < a.length) {
			if (a[i + 1][0] > a[j][1]) {
				ll.add(new MinMax(a[i][0], a[j][1]));
				i++;
				j++;
			} else {
				j++;
			}
		}
		return ll;
	}

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2)
			return intervals;

		// sort the intervals by start time
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		List<Interval> mergedIntervals = new LinkedList<Interval>();
		Iterator<Interval> intervalItr = intervals.iterator();
		Interval interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;

		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start <= end) { // overlapping intervals, adjust the 'end'
				end = Math.max(interval.end, end);
			} else { // non-overlapping interval, add the previous interval and reset
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// add the last interval
		mergedIntervals.add(new Interval(start, end));

		return mergedIntervals;
	}

}
