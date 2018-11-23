package binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
	private static int PRINT = 1, TO_LIST = 2;
	public static void main(String[] args) {
		MyBSTNode root = new MyBSTNode(10);
		root.left = new MyBSTNode(20);
		root.right = new MyBSTNode(30);
		root.left.left = new MyBSTNode(40);
		root.left.right = new MyBSTNode(60);
		
		BinaryTreeToBST obj = new BinaryTreeToBST();
		MyBSTNode newRoot = obj.doOperation(root);
		obj.printOrToListInOrder(newRoot, null, PRINT);
	}

	private MyBSTNode doOperation(MyBSTNode root) {
		List<Integer> list = new ArrayList<>();
		printOrToListInOrder(root, list, TO_LIST);
		Collections.sort(list);
		makeBTtoBST(root, list);
		return root;
	}

	private int index = 0;
	private void makeBTtoBST(MyBSTNode root, List<Integer> list) {
		if (root == null)
			return;
		makeBTtoBST(root.left, list);
		root.data = list.get(index++);
		makeBTtoBST(root.right, list);
	}

	private void printOrToListInOrder(MyBSTNode root, List<Integer> list, int key) {
		if (root == null)
			return;
		printOrToListInOrder(root.left, list, key);
		if (key == PRINT)
			System.out.print(root.data+" ");
		else
			list.add(root.data);
		printOrToListInOrder(root.right, list, key);
	}
}
