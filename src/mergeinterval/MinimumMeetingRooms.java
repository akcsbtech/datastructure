package mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MinimumMeetingRooms {

	public static int findMinimumMeetingRooms1(List<Meeting> meetings) {
		if (meetings == null || meetings.size() == 0)
			return 0;

		// sort the meetings by start time
		Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

		System.out.println(meetings);
		int minRooms = 0;
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
		for (Meeting meeting : meetings) {
			// remove all meetings that have ended
			while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
				minHeap.poll();
			// add the current meeting into the minHeap
			minHeap.offer(meeting);
			// all active meeting are in the minHeap, so we need rooms for all of them.
			minRooms = Math.max(minRooms, minHeap.size());
			System.out.println("min heap {}"+minHeap);

		}
		return minRooms;
	}

	public static int findMinimumMeetingRooms(List<Meeting> meetings) {
		// TODO: Write your code here
		// Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
		Collections.sort(meetings, (d1, d2) -> (d1.start - d2.start));
		int i = 0, j = 0;
		int count = 0;
		int maxMee = 0;
		while (i < meetings.size() && j < meetings.size()) {
			if (meetings.get(i).start < meetings.get(j).end) {
				++count;
				++i;
				// return false;
			} else {
				++j;
				--count;
			}
			maxMee = Math.max(maxMee, count);
		}

		return maxMee;
	}

	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required 1: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 5));
				add(new Meeting(7, 9));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required 2: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(6, 7));
				add(new Meeting(2, 4));
				add(new Meeting(8, 12));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required 3: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 3));
				add(new Meeting(3, 6));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required 4: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required 5: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
		System.out.println("Minimum meeting rooms required 1: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 5));
				add(new Meeting(7, 9));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
		System.out.println("Minimum meeting rooms required 2: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(6, 7));
				add(new Meeting(2, 4));
				add(new Meeting(8, 12));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
		System.out.println("Minimum meeting rooms required 3: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 3));
				add(new Meeting(3, 6));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
		System.out.println("Minimum meeting rooms required 4: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
		System.out.println("Minimum meeting rooms required 5: " + result);
	}
}
