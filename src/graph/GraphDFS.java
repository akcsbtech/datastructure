/**
 * 
 */
package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author akashgoyal
 *
 */
public class GraphDFS {

	private int V;
	private LinkedList<Integer> adj[];

	public GraphDFS(int v) {
		this.V = v;
		adj = new LinkedList[V];

		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v + " ");
		// Iterator<Integer> i = adj[v].listIterator();

		for (Integer i : adj[v]) {
			// int n = i.next();

			if (!visited[i]) {
				DFSUtil(i, visited);
			}
		}

	}

	void DFS(int v) {
		boolean visited[] = new boolean[V];

		DFSUtil(v, visited);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphDFS g = new GraphDFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}

}
