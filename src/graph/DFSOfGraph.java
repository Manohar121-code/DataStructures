package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFSOfGraph {
	private static int V;
	private static LinkedList<Integer> adj[];

	DFSOfGraph(int v) {
		V = v;
		adj = new LinkedList[10001];
		for (int i = 0; i < 10001; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		DFSOfGraph obj = null;
		int t = sc.nextInt();
		while (t-- > 0) {
			boolean[] vis = new boolean[10001];
			for (int i = 0; i < 10001; i++)
				vis[i] = false;
			int n = sc.nextInt();
			obj = new DFSOfGraph(n);
			for (int i = 0; i < n; i++)
				addEdge(sc.nextInt(), sc.nextInt());
			obj.DFS(1, adj, vis);
			System.out.println();
		}
	}

	public static void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public void DFS(int s, LinkedList<Integer> adj[], boolean visited[]) {
		Stack<Integer> stkObj = new Stack<>();
		stkObj.add(s);
		visited[s] = true;
		doOperation(stkObj, adj, visited);
	}

	private void doOperation(Stack<Integer> stkObj, LinkedList<Integer>[] adj,
			boolean[] visited) {
		while (!stkObj.isEmpty()) {
			Integer pop = stkObj.pop();
			LinkedList<Integer> adjList = adj[pop];
			System.out.print(pop + " ");
			for (Integer i : adjList) {
				if (visited[i] == false) {
					stkObj.add(i);
					visited[i] = true;
					doOperation(stkObj, adj, visited);
				}
			}
		}
	}

	//By GFG
	public void DFSByGFG(int v, LinkedList<Integer> adj[], boolean visited[]) {
		Iterator<Integer> iter = adj[v].listIterator();
		visited[v] = true;
		System.out.print(v + " ");

		while (iter.hasNext()) {
			int n = iter.next();
			if (!visited[n]) {
				DFSByGFG(n, adj, visited);
			}
		}
	}
}
