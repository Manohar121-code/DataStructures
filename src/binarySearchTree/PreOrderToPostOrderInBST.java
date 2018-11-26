package binarySearchTree;

import java.util.Stack;

public class PreOrderToPostOrderInBST {
	public static void main(String[] args) {
		int[] arr = {40, 30, 25, 32, 35, 80, 90, 100, 120};

		PreOrderToPostOrderInBST obj = new PreOrderToPostOrderInBST();
		new MyBST().postOrder(obj.doOperation(arr));
	}

	//OP : 25, 35, 32, 30, 120, 100, 90, 80, 40
	private MyBSTNode doOperation(int[] arr) {
		MyBSTNode root = new MyBSTNode(arr[0]);
		Stack<MyBSTNode> stkObj = new Stack<>();
		stkObj.push(root);
		for (int i = 1; i < arr.length; i++) {
			MyBSTNode temp = null;
			while (!stkObj.isEmpty() && arr[i] > stkObj.peek().data) {
				temp = stkObj.pop();
			}
			if (temp != null) {
				temp.right = new MyBSTNode(arr[i]);
				stkObj.push(temp.right);
			} else {
				stkObj.peek().left = new MyBSTNode(arr[i]);
				stkObj.push(stkObj.peek().left);
			}
		}
		return root;
	}
}
