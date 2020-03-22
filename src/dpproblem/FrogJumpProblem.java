/**
 * 
 */
package dpproblem;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author akashgoyal
 *
 */
public class FrogJumpProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] stones=new int [] {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}

	public static boolean canCross(int[] stones) {

		for (int i = 3; i < stones.length; i++) {

			if (stones[i] > stones[i - 1] * 2) {
				return false;
			}
		}
		int lastStone = stones[stones.length - 1];
		Stack<Integer> positions = new Stack<>();
		Stack<Integer> jumps = new Stack<>();
		HashSet<Integer> stone = new HashSet<Integer>();
		for (int i = 0; i < stones.length; i++) {
			stone.add(stones[i]);
		}
		positions.add(0);
		jumps.add(0);

		while (!positions.isEmpty()) {
			int position = positions.pop();
			int jumpDistance = jumps.pop();

			for (int i = jumpDistance - 1; i <=jumpDistance + 1; i++) {

				if (i <= 0) {
					continue;
				}
				int nextPosition = position + i;
				if (nextPosition == lastStone) {
					return true;
				} else if (stone.contains(nextPosition)) {
					System.out.println("nextPosition |"+nextPosition+"| i |"+i);
					positions.add(nextPosition);
					jumps.add(i);
				}
			}
		}

		return false;
	}

}
