package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListOfGraph {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		List<Integer> graph[];
		while (testCases-- > 0) {
			int vertices = scr.nextInt();
			graph = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++)
				graph[i] = new LinkedList<Integer>();
			int edges = scr.nextInt();
			for (int i = 0; i < edges; i++) {
				int v1 = scr.nextInt();
				int v2 = scr.nextInt();
				graph[v1].add(v2);
				graph[v2].add(v1);
			}
			for (int i = 0; i < graph.length; i++) {
				List<Integer> list = graph[i];
				System.out.print(i);
				for (Integer v2 : list) {
					System.out.print("-> "+v2);
				}
				System.out.println();
			}
		}
	}
}
