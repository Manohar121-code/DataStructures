package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(1);

		root.right = new Node(5);
		root.right.left = new Node(15);
		root.right.right = new Node(2);

		ConnectNodesAtSameLevel obj = new ConnectNodesAtSameLevel();
		obj.printElementsInLevelOrder(obj.doOperation(root));
	}

	private List<Node> doOperation(Node root) {
		List<Node> list = new ArrayList<Node>();
		Queue<Node> queueObj = new LinkedList<Node>();
		queueObj.add(root);
		while (!queueObj.isEmpty()) {
			Node currentNode = queueObj.poll();
			list.add(currentNode);
			Node tempLast = null;
			while (currentNode != null) {
				if (currentNode.left != null) {
					if (tempLast != null)
						tempLast.nextRight = currentNode.left;
					tempLast = currentNode.left;
					if (queueObj.isEmpty())
						queueObj.add(currentNode.left);
				}
				if (currentNode.right != null) {
					if (tempLast != null)
						tempLast.nextRight = currentNode.right;
						tempLast = currentNode.right;
					if (queueObj.isEmpty())
						queueObj.add(currentNode.right);
				}
				currentNode = currentNode.nextRight;
			}
		}
		return list;
	}
	
	private void printElementsInLevelOrder(List<Node> list) {
		for (Node currentNode : list) {
			while (currentNode != null) {
				System.out.print(currentNode.data+" -> ");
				currentNode = currentNode.nextRight;
			}
			System.out.println("NULL ");
		}
	}
}

class Node {
	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}