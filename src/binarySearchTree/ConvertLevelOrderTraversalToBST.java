package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertLevelOrderTraversalToBST {
	public static void main(String[] args) {
//		int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		int[] arr = {253, 102, 525, 484, 2181, 463, 498, 1128, 435, 875, 1581, 792, 1364, 1726, 1532, 1533};
		ConvertLevelOrderTraversalToBST obj = new ConvertLevelOrderTraversalToBST();
		long s = System.nanoTime();
		MyBSTNode root = obj.doOperation(arr);
		long e = System.nanoTime();
		obj.printInOrder(root);
		System.out.println("\nTime taken : "+ (e-s));
	}

	private void printInOrder(MyBSTNode root) {
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}

//	     7
//	    / \
//	   4   12
//	  / \  /
//	 3   6 8
//	/   /   \
// 1   5     10
	private MyBSTNode doOperation(int[] arr) {
		//253, 102, 525, 484, 2181, 463, 498, 1128, 435, 875, 1581, 792, 1364, 1726, 1532, 1533
		Queue<NodeStartEnd> queueObj = new LinkedList<>();

		MyBSTNode root = new MyBSTNode(arr[0]);
		queueObj.add(new NodeStartEnd(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		for (int i = 1; i < arr.length; i++) {
			boolean leftCheck = false;
			if (!queueObj.isEmpty()) {
				NodeStartEnd nodeSEObj = queueObj.peek();
				MyBSTNode bstNode = (MyBSTNode) nodeSEObj.getNode();
				int start = nodeSEObj.getStart(), end = nodeSEObj.getEnd();
				if (start < arr[i] && arr[i] < bstNode.data) {
					MyBSTNode leftNode = new MyBSTNode(arr[i]);
					bstNode.left = leftNode;
					queueObj.add(new NodeStartEnd(leftNode, start, bstNode.data));
					leftCheck = true;
				}
				if (bstNode.data < arr[i] && arr[i] < end) {
					MyBSTNode rightNode = new MyBSTNode(arr[i]);
					bstNode.right = rightNode;
					queueObj.add(new NodeStartEnd(rightNode, bstNode.data, end));
					queueObj.poll();
					continue;
				}
				if (!leftCheck || (i+1 < arr.length && !(bstNode.data < arr[i+1] && arr[i+1] < end))) {
					queueObj.poll();
					if (!leftCheck)
						i--;
				}
			}
		}
		return root;
	}

//	     7
//	    / \
//	   4   12
//	  / \  /
//	 3   6 8
//	/   /   \
// 1   5     10

}

class NodeStartEnd {
	private MyBSTNode node;
	private int start;
	private int end;
	public NodeStartEnd(MyBSTNode node, int start, int end) {
		super();
		this.node = node;
		this.start = start;
		this.end = end;
	}
	public MyBSTNode getNode() {
		return node;
	}
	public void setNode(MyBSTNode node) {
		this.node = node;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}