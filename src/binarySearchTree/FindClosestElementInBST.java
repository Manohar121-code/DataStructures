package binarySearchTree;

import java.util.Stack;

public class FindClosestElementInBST {
	public static void main(String[] args) {
//		int[] arr = { 9, 4, 3, 6, 5, 7, 17, 22, 20 };
		int[] arr = {100, 110, 10, 22, 23, 24, 25, 27, 34, 44, 55, 66, 77, 88, 92, 93, 94, 97};
		MyBST bstObj = new MyBST();
		for (int i : arr) {
			bstObj.insert(i);
		}

		FindClosestElementInBST obj = new FindClosestElementInBST();
		System.out.println(obj.doOperation(bstObj.root, 4));
		System.out.println(obj.doOperation(bstObj.root, 18));
		System.out.println(obj.doOperation(bstObj.root, 12));
		System.out.println(obj.doOperation(bstObj.root, 98));
	}

	private int doOperation(MyBSTNode root, int k) {
		Stack<Integer> stkObj = new Stack<>();
		if (root != null) {
			getClosestElement(root, stkObj, k);
			return stkObj.peek();
		} else {
			return -1;
		}
	}

	private void getClosestElement(MyBSTNode root, Stack<Integer> stkObj, int k) {
		if (root == null)
			return;
		if (k == root.data) {
			stkObj.push(root.data);
			return;
		}
		if (stkObj.isEmpty() || (!stkObj.isEmpty() && Math.abs(stkObj.peek() - k) > Math.abs(root.data - k)))
			stkObj.push(Math.abs(root.data));
		
		if (k < root.data)
			getClosestElement(root.left, stkObj, k);
		else
			getClosestElement(root.right, stkObj, k);
	}
}
