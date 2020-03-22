/**
 * 
 */
package graph;

/**
 * @author akashgoyal
 *
 */
public class GraphShortestPath {
	static final int V = 4;
	static final int INF = Integer.MAX_VALUE;

	public int shortestPath(int graph[][], int u, int v, int k) {

		if (k == 0 && u == v) {
			return 0;
		}
		if (k == 1 && graph[u][v] != INF) {
			return graph[u][v];
		}
		if (k <= 0)
			return INF;
		int res = INF;
		for (int i = 0; i < V; i++) {
			if (graph[u][i] != INF && u != i && v != i) {
				int rec_res = shortestPath(graph, i, v, k - 1);
				if (rec_res != INF) {
					res = Math.min(res, graph[u][i] + rec_res);
				}
			}
		}
		return res;
	}

	public int shortestPathUsingDP(int[][] graph, int u, int v, int k) {
		int sp[][][] = new int[V][V][k + 1];

		for (int e = 0; e <= k; e++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					// initialize value
					sp[i][j][e] = INF;

					// from base case
					if (e == 0 && i == j) {
						sp[i][j][e] = 0;
					}
					if (e == 1 && graph[i][j] != INF) {
						sp[i][j][e] = graph[i][j];
					}

					if (e > 1) {
						for (int a = 0; a < V; a++) {
							if (graph[i][a] != INF && i != a && j != a && sp[i][j][e - 1] != INF) {
								sp[i][j][e] = Math.min(sp[i][j][e], graph[i][a] + sp[a][j][e - 1]);
							}
						}
					}
				}
			}
		}
		return sp[u][v][k];
	}

	public static void main(String[] arg) {
		int graph[][] = new int[][] { { 0, 10, 3, 2 }, { INF, 0, INF, 7 }, { INF, INF, 0, 6 }, { INF, INF, INF, 0 } };

		GraphShortestPath gsp = new GraphShortestPath();
		int u = 0, v = 3, k = 2;

		System.out.println("Weight of the shortest path is " + gsp.shortestPath(graph, u, v, k));
	}
}
