/**
 * 
 */
package corejava;

import java.util.ArrayList;

/**
 * @author akashgoyal
 *
 */
public class ArrayListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> al = new ArrayList<String>();
		System.out.println(al.size());
		al.add("A");
		al.add("B");
		al.add(1, "C");
		System.out.println(al.size() + "  " + al);
		al.remove("B");
		al.remove(2);

		System.out.println(al.size() + "  " + al);

	}

}
