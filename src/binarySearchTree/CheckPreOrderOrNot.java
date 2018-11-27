package binarySearchTree;

import java.util.Stack;

public class CheckPreOrderOrNot {
	public static void main(String[] args) {
		int[] arr = {40, 30, 25, 32, 35, 80, 90, 100, 120};
//		int[] arr = {7, 9, 6, 1, 4, 2, 3, 40};
		CheckPreOrderOrNot obj = new CheckPreOrderOrNot();
		System.out.println(obj.doOperation(arr));
	}

	public boolean checkPreOrderOrNot(int[] arr) {
		return doOperation(arr);
	}
	
	private boolean doOperation(int[] arr) {
		Stack<NodeStartEnd> stkObj = new Stack<>();
		stkObj.push(new NodeStartEnd(new MyBSTNode(arr[0]), Integer.MIN_VALUE, Integer.MAX_VALUE));
		for (int i = 1; i < arr.length; i++) {
			NodeStartEnd temp = null;
			while (!stkObj.isEmpty() && arr[i] > stkObj.peek().getNode().data) {
				temp = stkObj.pop();
			}
			if (temp != null) {
				if (!(temp.getNode().data < arr[i] && arr[i] < temp.getEnd())) {
					return false;
				}
				stkObj.push(new NodeStartEnd(new MyBSTNode(arr[i]), temp.getNode().data, temp.getEnd()));
			} else {
				temp = stkObj.peek();
				if (!(temp.getStart() < arr[i] && arr[i] < temp.getNode().data)) {
					return false;
				}
				stkObj.push(new NodeStartEnd(new MyBSTNode(arr[i]), temp.getStart(), temp.getNode().data));
			}
		}
		return true;
	}
}
