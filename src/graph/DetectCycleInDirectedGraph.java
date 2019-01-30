package graph;

import java.util.LinkedList;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
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
			}
			boolean[] visited = new boolean[v];
			boolean[] explored = new boolean[v];
			if (obj.isCyclic(v, alist, visited, explored)) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
	}
/*
1
3 3
0 1 1 2 0 2

1
4 5
0 1 1 2 2 3 3 1 0 2

1
4 4
0 1 1 2 2 3 0 2

1
68 24
6 48 15 47 21 55 4 10 32 3 10 4 20 40 41 65 63 39 30 41 21 45 7 49 60 0 46 40 24 13 27 39 2 42 26 31 37 30 49 9 34 59 21 62 39 62 0 43

*/
	private boolean isCyclic(int v, LinkedList<Integer>[] aList, boolean[] visited, boolean[] explored) {
		for (int i = 0; i < aList.length; i++) {
			if (doDFS(i, aList, visited, explored))
				return true;
		}
		return false;
	}
/*
2
2 2
0 1 0 0
4 3
0 1 1 2 2 3
*/	private Boolean doDFS(int currentVertex, LinkedList<Integer>[] adjList, boolean[] visited, boolean[] explored) {
		if (explored[currentVertex])
			return true;
		if (visited[currentVertex])
			return false;
		
		explored[currentVertex] = true;
		visited[currentVertex] = true;
		for (Integer i : adjList[currentVertex]) {
			if (doDFS(i, adjList, visited, explored))
				return true;
		}
		explored[currentVertex] = false;
		return false;
	}
}
