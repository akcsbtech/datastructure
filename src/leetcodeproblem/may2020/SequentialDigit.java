/**
 * 
 */
package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author b0218163
 *
 */
public class SequentialDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> digit = new ArrayList<Integer>();

		if (low > high)
			return result;

		int length = (low + "").length();

		for (int i = 1; i <= length; i++)
			digit.add(i);
		int num = low;
		while (num <= high) {
			num = 0;
			for (Integer ii : digit) {
				num = num * 10 + ii;
			}
			System.out.println(num);
			if (num >= low && num <= high) {
				result.add(num);
			}
			int last = digit.get(digit.size() - 1);
			if (last < 9) {
				digit.remove(0);
				digit.add(++last);
			} else {
				int size = digit.size();
				digit.clear();

				for (int i = 1; i <= size + 1; i++)
					digit.add(i);
			}
		}

		return result;
	}
}
