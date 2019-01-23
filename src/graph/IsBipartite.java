package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsBipartite {
	// It should be a complete Bipartite graph
	public static void main(String[] args) {
		IsBipartite obj = new IsBipartite();
		List<BP_Edge> edges = Arrays.asList(new BP_Edge(1, 5),
				new BP_Edge(2, 4), new BP_Edge(3, 4), new BP_Edge(2, 3));
		final int N = 10;
		System.out.println(obj.doOperation(N, edges) ? "Bipartite"
				: "Not a Bipartite");
	}

	// ********************************GFG*********************************
	private boolean isBipartite(int G[][], int V) {
		List<Integer>[] adjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		int input = -1;
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (G[i][j] == 1) {
					if (input == -1) input = i;
					adjList[i].add(j);
					adjList[j].add(i);
				}
			}
		}
		return input == -1 ? false : doBFS(adjList, input);
	}
	// ********************************GFG*********************************

	private boolean doOperation(int N, List<BP_Edge> edges) {
		List<Integer>[] adjList = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < edges.size(); i++) {
			BP_Edge bp_Edge = edges.get(i);
			adjList[bp_Edge.source].add(bp_Edge.dest);
			adjList[bp_Edge.dest].add(bp_Edge.source);
		}
		return doBFS(adjList, 1);
	}

	private boolean doBFS(List<Integer>[] adjList, int i) {
		Queue<Integer> queueObj = new ArrayDeque<>();
		boolean[] visited = new boolean[adjList.length];
		int[] level = new int[adjList.length];
		queueObj.add(i);
		visited[i] = true;
		level[i] = 0;
		while (!queueObj.isEmpty()) {
			Integer v = queueObj.poll();
			for (int v2 : adjList[v]) {
				if (!visited[v2]) {
					visited[v2] = true;
					level[v2] = level[v] + 1;
					queueObj.add(v2);
				} else if (level[v2] == level[v]) {
					return false;
				} else if (v2 == v) {
					return false;
				}
			}
		}
		return true;
	}
}

class BP_Edge {
	int source, dest;

	public BP_Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
}