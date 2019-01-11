package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSOfGraph {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[10001];
		BFSOfGraph obj = new BFSOfGraph();
		while (t-- > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < 10001; i++)
				adj[i] = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
			}
			// int s=sc.nextInt();
			boolean vis[] = new boolean[1001];
			for (int i = 0; i < 1001; i++)
				vis[i] = false;
			obj.bfs(1, adj, vis);
			System.out.println();
		}
	}
	
	public void bfs(int s, ArrayList<Integer> adj[], boolean visited[]) {
		Queue<Integer> queueObj = new LinkedList<>();
		queueObj.add(s);
		visited[s] = true;
		while (!queueObj.isEmpty()) {
			Integer poll = queueObj.poll();
			ArrayList<Integer> adjList = adj[poll];
			for (Integer i : adjList) {
				if (visited[i] == false)
					queueObj.add(i);
				visited[i] = true;
			}
			System.out.print(poll+" ");
		}
	}
}
