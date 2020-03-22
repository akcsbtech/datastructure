package comparator;

import java.util.HashMap;
import java.util.TreeSet;

public class SortPersonBySalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList<Person> pp = new ArrayList<Person>();
		TreeSet<Person> pp = new TreeSet<Person>();
		pp.add(new Person("akash", 100));
		pp.add(new Person("akash", 100));
		pp.add(new Person("pulkit", 200));
		pp.add(new Person("devansu", 150));

		System.out.println(pp+" "+pp.size());
		
		HashMap<Person,Person> pps=new HashMap<Person,Person>();
		pps.put(new Person("akash", 100),new Person("akash", 100));
		pps.put(new Person("akash", 100),new Person("akash", 100));
		pps.put(new Person("akash1", 100),new Person("akash", 100));
		
		System.out.println(pps+"   "+pps.size());

		

	}

}
