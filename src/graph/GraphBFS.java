/**
 * 
 */
package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author akashgoyal
 *
 */
public class GraphBFS {

	/**
	 * @param args
	 */
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	GraphBFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		System.out.println();
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			List<Integer> ii = adj[s];
			for (Integer n : ii) {
				// int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {
		GraphBFS g = new GraphBFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(0);
		g.BFS(1);
		g.BFS(2);
		g.BFS(3);
	}
}
