/**
 * 
 */
package graph;

import java.util.LinkedList;

/**
 * @author akashgoyal
 *
 */
public class GFG {
	static class Graph {
		int V;
		LinkedList<Integer> adjListArray[];

		public Graph(int V) {
			this.V = V;
			adjListArray = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adjListArray[i] = new LinkedList<Integer>();
			}

		}
	}

	public static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}

	public static void printGraph(Graph graph) {
		for (int i = 0; i < graph.V; ++i) {
			System.out.println("Vertex :" + i);
			System.out.println("Head");

			for (Integer ii : graph.adjListArray[i]) {
				System.out.print(ii + " --->");
			}
			System.out.println("");
		}
	}

	public static void main(String[] arg) {
		int V = 5;
		Graph graph = new Graph(V);

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		printGraph(graph);
	}
}
