package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PairsViolatingBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.root = new MyBSTNode(50);
		bstObj.root.left = new MyBSTNode(30);
		bstObj.root.left.left = new MyBSTNode(20);
		bstObj.root.left.right = new MyBSTNode(25);
		bstObj.root.right = new MyBSTNode(60);
		bstObj.root.right.left = new MyBSTNode(10);
		bstObj.root.right.right = new MyBSTNode(40);
		
		bstObj.inOrder(bstObj.root);
		System.out.println();

		PairsViolatingBST obj = new PairsViolatingBST();
		int count = obj.doOperation(bstObj.root);
		System.out.println("Number of pairs Violating : "+count);
	}
	
	
	private int doOperation(MyBSTNode root) {
		pairsViolatingBST(root, new ArrayList<Integer>());
		return count;
	}

	private int count = 0;

	private void pairsViolatingBST(MyBSTNode root, List<Integer> list) {
		if (root == null)
			return;
		pairsViolatingBST(root.left, list);
		for (Integer i : list) {
			if (i > root.data) {
				System.out.println("("+i+", "+root.data+")");
				count++;
			}
		}
		list.add(root.data);
		pairsViolatingBST(root.right, list);
	}
}
