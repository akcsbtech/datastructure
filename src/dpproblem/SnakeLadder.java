/**
 * 
 */
package dpproblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author akashgoyal
 *
 */
public class SnakeLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

	static class Qentry {
		int v;
		int dist;
	}

	static int getMinDiceThrows(int[] move, int n) {
		int visited[] = new int[n];
		Queue<Qentry> q = new LinkedList<Qentry>();
		Qentry qe = new Qentry();

		qe.v = 0;
		qe.dist = 0;

		visited[0] = 1;
		q.add(qe);

		while (!q.isEmpty()) {
			qe = q.remove();

			int v = qe.v;

			if (v == n - 1) {
				break;
			}

			for (int i = v + 1; i <= v + 6 && i < n; i++) {
				if (visited[i] == 0) {
					Qentry a = new Qentry();
					a.dist = qe.dist + 1;
					visited[i] = 1;

					if (move[i] != -1)
						a.v = move[i];
					else
						a.v = i;
					q.add(a);

				}
			}
		}
		return qe.dist;
	}

}
