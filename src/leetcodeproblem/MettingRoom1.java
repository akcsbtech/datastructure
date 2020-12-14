/**
 * 
 */
package leetcodeproblem;

import java.util.Arrays;

/**
 * @author b0218163
 *
 */
public class MettingRoom1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean meetingRoom(int starts[], int ends[]) {

		Arrays.sort(starts);
		Arrays.sort(ends);

		for (int i = 0; i < starts.length; i++) {
			if (starts[i] > ends[i])
				return false;
		}
		return true;
	}
}
