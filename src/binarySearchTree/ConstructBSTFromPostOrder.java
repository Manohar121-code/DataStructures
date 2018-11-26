package binarySearchTree;

import java.util.Stack;

public class ConstructBSTFromPostOrder {
//	     10
//	   /    \
//	  5      40
//	 /  \      \
//	1    7      50
	public static void main(String[] args) {
		ConstructBSTFromPostOrder obj = new ConstructBSTFromPostOrder();
//		int[] arr = {1, 7, 5, 50, 40, 10};
		int[] arr = {216, 823, 476, 429, 850, 93, 18, 975, 862};
		MyBSTNode root = obj.constructTreeByStack(arr, arr.length);
		new MyBST().inOrder(root);
		System.out.println();
		
		MyBSTNode root2 = obj.constructTreeByArray(arr, arr.length);
		new MyBST().inOrder(root2);
		System.out.println();
	}
	
	private MyBSTNode constructTreeByStack(int[] arr, int length) {
		MyBSTNode root = new MyBSTNode(arr[length - 1]);
		Stack<MyBSTNode> stkObj = new Stack<>();
		stkObj.push(root);
		for (int i = length - 2; i >= 0; i--) {
			MyBSTNode temp = null;
			while (!stkObj.isEmpty() && arr[i] < stkObj.peek().data) {
				temp = stkObj.pop();
			}
			if (temp != null) {
				MyBSTNode leftNode = new MyBSTNode(arr[i]);
				temp.left = leftNode;
				stkObj.push(leftNode);
			} else {
				MyBSTNode rightNode = new MyBSTNode(arr[i]);
				stkObj.peek().right = rightNode;
				stkObj.push(rightNode);
			}
		}
		return root;
	}
	
	//216, 823, 476, 429, 850, 93, 18, 975, 862
	public MyBSTNode constructTreeByArray(int[] arr, int length) {
		MyBSTNode root = new MyBSTNode(arr[length - 1]);
		MyBSTNode[] stkObj = new MyBSTNode[length];
		int count = 0;
		stkObj[count] = root;
		for (int i = length - 2; i >= 0; i--) {
			MyBSTNode temp = null;
			while (count >= 0 && arr[i] < stkObj[count].data) {
				temp = stkObj[count--];
			}
			if (temp != null) {
				MyBSTNode leftNode = new MyBSTNode(arr[i]);
				temp.left = leftNode;
				stkObj[++count] = leftNode;
			} else {
				MyBSTNode rightNode = new MyBSTNode(arr[i]);
				stkObj[count].right = rightNode;
				stkObj[++count] = rightNode;
			}
		}
		return root;
	}
}
