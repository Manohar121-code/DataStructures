package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class DetectCycleInUndirectedGraph {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int v = in.nextInt();
			int e = in.nextInt();
			LinkedList<Integer>[] alist = new LinkedList[v];
			for (int i = 0; i < v; i++)
				alist[i] = new LinkedList<Integer>();
			while (e-- > 0) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				alist[n1].add(n2);
				alist[n2].add(n1);
			}
			if (obj.isCyclic(v, alist)) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
	}

	private Boolean isCyclic(int V, LinkedList<Integer>[] adjList) {
		Set<Integer> passedVertexes = new HashSet<>();
		Queue<Integer> queueObj = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[V];
		queueObj.add(0);
		passedVertexes.add(0);
		while (!queueObj.isEmpty()) {
			Integer curr = queueObj.poll();
			for (int adjV : adjList[curr]) {
				if (!visited[adjV]) {
					visited[adjV] = true;
					passedVertexes.add(adjV);
					queueObj.add(adjV);
				} else if (passedVertexes.contains(adjV)) {
					return true;
				}
			}
		}
		return false;
	}
}
