package binarySearchTree;

import java.util.Stack;

public class ConstructBSTFromPreOrder {
	
	MyBSTNode root;
//	     10
//	   /    \
//	  5      40
//	 /  \      \
//	1    7      50
	public static void main(String[] args) {
		ConstructBSTFromPreOrder obj = new ConstructBSTFromPreOrder();
//		int[] arr = {10, 5, 1, 7, 40, 50};
		int[] arr = {10, 3, 1, 9, 18, 15, 13, 17, 20, 19, 27};
		obj.doOperation(arr);
	}
	
	private void doOperation(int[] arr) {
		long startTime = System.nanoTime();
		root = null;
		root = constructBstByPreOrder(arr, 0, arr.length-1);
		long endTime = System.nanoTime();
		printInOrder();
		System.out.println("Total time taken for O(n^2) : "+ (endTime - startTime));
		
		System.out.println("------------");
		
		long startTimeByStack = System.nanoTime();
		root = null;
		root = constructBstByPreOrderByStack(arr, arr.length);
		long endTimeByStack = System.nanoTime();
		printInOrder();
		System.out.println("Total time taken by Stack : "+ (endTimeByStack - startTimeByStack));
	}

	private MyBSTNode constructBstByPreOrderByStack(int[] arr, int size) {
		Stack<MyBSTNode> stackObj = new Stack<MyBSTNode>();
		MyBSTNode root = new MyBSTNode(arr[0]);
		stackObj.push(root);
		for (int i = 1; i < size; i++) {
			MyBSTNode tempNode = null;
			while (!stackObj.isEmpty() && arr[i] > stackObj.peek().data) {
				tempNode = stackObj.pop();
			}
			if (tempNode != null) {
				tempNode.right = new MyBSTNode(arr[i]);
				stackObj.push(tempNode.right);
			} else {
				tempNode = stackObj.peek();
				tempNode.left = new MyBSTNode(arr[i]);
				stackObj.push(tempNode.left);
			}
		}
		return root;
	}

	private MyBSTNode constructBstByPreOrder(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		MyBSTNode node = new MyBSTNode(arr[start]);
		int nextGreaterIndex = getNextGreaterElement(arr, start, end);
		//create left & right of node by recursion
		node.left = constructBstByPreOrder(arr, start+1, (/*nextGreaterIndex > start+1*/ nextGreaterIndex != -1) ? nextGreaterIndex-1 : end);
		if (nextGreaterIndex > start) {
			node.right = constructBstByPreOrder(arr, nextGreaterIndex, end);
		}
		return node;
	}
	
	private int getNextGreaterElement(int[] arr, int start, int end) {
		int startValue = arr[start];
		for (int i = start+1; i <= end; i++) {
			if (startValue < arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private void printInOrder() {
		System.out.print("InOrder -> ");
		inOrder(root);
		System.out.println();
	}
	
	public void inOrder(MyBSTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
}
