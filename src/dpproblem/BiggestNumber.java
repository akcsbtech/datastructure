/**
 * 
 */
package dpproblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author akashgoyal
 *
 */
public class BiggestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> vv = new Vector<String>();
		vv.add("123");
		vv.add("1");
		biggestNumber(vv);

	}

	public static void biggestNumber(Vector<String> arr) {

		Collections.sort(arr, new Comparator<String>() {

			// A comparison function which is used by
			// sort() in printLargest()
			@Override
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;

				// Now see which of the two formed numbers
				// is greater
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next());

	}

}
