package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.right = new MyBTNode(3);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.right.left = new MyBTNode(6);
		root.right.right = new MyBTNode(7);
		
		LevelOrderTraversalLineByLine obj = new LevelOrderTraversalLineByLine();
		obj.printWithDollar(root);
		System.out.println();
		obj.byGFG(root);
	}

	private void printWithDollar(MyBTNode root) {
		Queue<Object> queueObj = new LinkedList<Object>();
		queueObj.add(root);queueObj.add("$");
		while (!queueObj.isEmpty() && queueObj.size() > 1) {
			if (!queueObj.peek().equals("$")) {
				MyBTNode node = (MyBTNode) queueObj.poll();
				System.out.print(node.data+" ");
				if (node.left != null)
					queueObj.add(node.left);
				if (node.right != null)
					queueObj.add(node.right);
			} else {
				System.out.print(queueObj.poll()+" ");
				queueObj.add("$");
			}
		}
		System.out.println(queueObj.poll()+" ");
	}
	
	private void byGFG(MyBTNode root) {
		Queue<MyBTNode> queueObj = new LinkedList<MyBTNode>();
		queueObj.add(root);
		while (!queueObj.isEmpty()) {
			int size = queueObj.size();
			while (size-- > 0) {
				MyBTNode node = queueObj.poll();
				if (node.left != null) queueObj.add(node.left);
				if (node.right != null) queueObj.add(node.right);
				System.out.print(node.data+" ");
			}
			System.out.print("$ ");
		}
	}
}
