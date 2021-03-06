package mergeinterval;

import java.util.Arrays;

class ConflictingAppointments {

	public static boolean canAttendAllAppointments(Interval[] intervals) {
		// TODO: Write your code here
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}

	public static boolean conflictMeeting(Interval[] intervals) {
		// TODO: Write your code here
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		int i = 1, j = 0;
		while (i < intervals.length && j < intervals.length) {
			if (intervals[i].start < intervals[j].end) {
				System.out.println("start [" + intervals[j].start + "," + intervals[j].end + "] [" + intervals[i].start
						+ "," + intervals[i].end + "]");
				++i;
				// return false;
			} else {
				++j;
				++i;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);

		// result = ConflictingAppointments.conflictMeeting(intervals);

		// result = ConflictingAppointments.conflictMeeting(intervals1);

		// result = ConflictingAppointments.conflictMeeting(intervals2);

		Interval[] intervals3 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6), new Interval(5, 7),
				new Interval(7, 8) };

		result = ConflictingAppointments.conflictMeeting(intervals3);

	}
}
