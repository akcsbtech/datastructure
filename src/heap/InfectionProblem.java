package heap;

import java.util.HashSet;

public class InfectionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] data = { { 1, 2 }, { 1, 1 } };
		System.out.println(timeRequireForInfection(data));
	}

	public static int timeRequireForInfection(int[][] data) {
		int requireMin = 0;
		HashSet<String> infected = new HashSet<String>();
		HashSet<String> fresh = new HashSet<String>();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == 1) {
					fresh.add("" + i + j);
				} else if (data[i][j] == 2) {
					infected.add("" + i + j);
				}
			}
		}
		if (infected.size() == 0) {
			return -1;
		}
		if (fresh.size() == 0) {
			return 0;
		}

		while (fresh.size() > 0) {
			HashSet<String> rotten = new HashSet<String>();
			int[][] movement = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			System.out.println("fresh |" + fresh + "  |new rotten|" + rotten + " | infected |" + infected);
			//{{0,-1},{0,1},{-1,0},{1,1}}
			for (String infect : infected) {
				int row = infect.charAt(0) - '0';
				int col = infect.charAt(1) - '0';

				for (int i = 0; i < movement.length; i++) {
					int newRow = row + movement[i][0];
					int newCol = col + movement[i][1];

					if (fresh.contains("" + newRow + newCol)) {
						rotten.add("" + newRow + newCol);
						fresh.remove("" + newRow + newCol);

					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fresh |" + fresh + "  |new rotten|" + rotten + " | infected |" + infected);
			infected = rotten;
			++requireMin;
		}

		return requireMin;
	}

}
