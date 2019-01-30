package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	private boolean isCyclic(int v, LinkedList<Integer>[] aList) {
		boolean[] visited = new boolean[aList.length];
		for (int i = 0; i < aList.length; i++) {
			if (!visited[i])
				if (doDFS(i, aList, visited, -1))
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
*/	private Boolean doDFS(int currentVertex, LinkedList<Integer>[] adjList, boolean[] visited, int parent) {
		visited[currentVertex] = true;
		for (Integer i : adjList[currentVertex]) {
			if (i != parent) {
				if (visited[i])
					return true;
				else
					doDFS(i, adjList, visited, currentVertex);
			}
		}
		return false;
	}
}
