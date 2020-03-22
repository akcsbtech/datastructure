package collection;

import java.util.*;

public class Tmp {
	static class StudentMaster implements Comparable<StudentMaster> {
		private Integer id;
		private Integer frequency;

		public StudentMaster(Integer id, Integer master) {
			this.id = id;
			this.frequency = master;
		}

		@Override
		public int compareTo(StudentMaster other) {
			if(frequency>other.frequency) {
				return 1;
			}else if(frequency==other.frequency){
				return 0;
			}else {
				return -1;
			}
		}

		@Override
		public boolean equals(Object o) {
			StudentMaster osm = (StudentMaster) o;
			return id == osm.id && master.equals(osm.master);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, master);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Formatter fm = new Formatter(sb);

			fm.format("id = %d, master = %s\n", id, master);

			fm.close();
			return sb.toString();
		}
	}

	public static void test() {
		final Set<StudentMaster> smSet = new TreeSet<>();

		smSet.add(new StudentMaster(146, "Sweden"));
		smSet.add(new StudentMaster(148, "Sweden"));
		smSet.add(new StudentMaster(110, "Orebro"));
		smSet.add(new StudentMaster(6, "Malmo"));
		smSet.add(new StudentMaster(14, "Orebro"));
		smSet.add(new StudentMaster(26, "Malmo"));

		for (StudentMaster sm : smSet) {
			System.out.print(sm);
		}
	}

	public static void main(String[] args) {
		test();
	}
}