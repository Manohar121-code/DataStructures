package graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class SnakeAndLadderByGFG {
	private static class Node {
		int val;
		LinkedList<Integer> edges = new LinkedList<>();
		int depth = 0;
		boolean visited = false;

		public Node(int val) {
			this.val = val;
			for (int i = val + 1; i < val + 7; i++) {
				addEdge(i);
			}
		}

		public void addEdge(int edge) {
			if (edge < 0 || edge >= 30) {
				return;
			}

			if (edges.contains(edge)) {
				return;
			}

			edges.add(edge);
		}
	}

	private static final int BOARD_SIZE = 30;
	private static Scanner scanner;
	private static Node graph[];

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int numTestCases = scanner.nextInt();

		for (int i = 0; i < numTestCases; i++) {
			runTest();
		}

	}

	private static void runTest() {
		buildGraph();

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(graph[0]);
		graph[0].visited = true;

		while (!queue.isEmpty()) {
			Node node = queue.pop();

			if (node.val == graph.length - 1) {
				System.out.println("" + node.depth);
				return;
			}

			ListIterator<Integer> iter = node.edges.listIterator();

			while (iter.hasNext()) {
				Node child = graph[iter.next()];
				if (child.visited) {
					continue;
				}

				child.depth = node.depth + 1;
				child.visited = true;

				queue.add(child);
			}
		}
	}

	private static void buildGraph() {
		graph = new Node[BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			graph[i] = new Node(i);
		}

		addLaddersAndSnakes();
	}

	private static void addLaddersAndSnakes() {
		int numItems = scanner.nextInt();

		for (int i = 0; i < numItems; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			for (int j = x - 2; j > x - 8; j--) {
				if (j < 0) {
					break;
				}
				graph[j].addEdge(y - 1);
			}

		}
	}
}