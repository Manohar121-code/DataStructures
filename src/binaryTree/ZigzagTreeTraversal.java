package binaryTree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTreeTraversal {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(7);
		root.left.right = new MyBTNode(6);

		root.right = new MyBTNode(3);
		root.right.left = new MyBTNode(5);
		root.right.right = new MyBTNode(4);

		ZigzagTreeTraversal obj = new ZigzagTreeTraversal();
		obj.doOperation(root);
	}

	private void doOperation(MyBTNode root) {
		Stack<MyBTNode> stkObj1 = new Stack<MyBTNode>();
		Stack<MyBTNode> stkObj2 = new Stack<MyBTNode>();
		stkObj1.add(root);
		boolean check = false;
		while (!stkObj1.isEmpty() || !stkObj2.isEmpty()) {
			if (check) {
				while (!stkObj2.isEmpty()) {
					MyBTNode lastNode = stkObj2.pop();
					if (lastNode.left != null) stkObj1.add(lastNode.right);
					if (lastNode.right != null) stkObj1.add(lastNode.left);
					System.out.print(lastNode.data+" ");
				}
				check = false;
			} else {
				while (!stkObj1.isEmpty()) {
					MyBTNode firstNode = stkObj1.pop();
					if (firstNode.left != null) stkObj2.add(firstNode.left);
					if (firstNode.right != null) stkObj2.add(firstNode.right);
					System.out.print(firstNode.data+" ");
				}
				check = true;
			}
		}
	}
}
