package topkelement;

import java.util.PriorityQueue;

public class ConnectRope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectRope ConnectRopes = new ConnectRope();
		int result = ConnectRopes.connectRope(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.connectRope(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.connectRope(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}

	public int connectRope(int[] nums) {
		PriorityQueue<Integer> ii = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

		for (int i = 0; i < nums.length; i++) {
			ii.add(nums[i]);
		}
		while (!ii.isEmpty()) {
			if (ii.size() == 1) {
				return ii.poll();
			}
			int i = ii.poll();
			int i2 = ii.poll();
			ii.add(i + i2);
		}
		return 0;
	}

}
