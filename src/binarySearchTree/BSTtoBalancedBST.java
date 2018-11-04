package binarySearchTree;

import java.util.Vector;

public class BSTtoBalancedBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(10);
		bstObj.insert(8);
		bstObj.insert(7);
		bstObj.insert(6);
		bstObj.insert(5);
		bstObj.insert(4);
		bstObj.insert(2);
		bstObj.insert(1);

		BSTtoBalancedBST obj = new BSTtoBalancedBST();
		MyBSTNode root = obj.makeBSTBalanced(bstObj.root);
		System.out.println(obj.getHeightOfBST(root));
	}

	private int getHeightOfBST(MyBSTNode root) {
		if (root == null)
			return 0;
		return Math.max(getHeightOfBST(root.left), getHeightOfBST(root.right)) + 1;
	}

	private MyBSTNode makeBSTBalanced(MyBSTNode root) {
		Vector<MyBSTNode> vectorObj = new Vector<>();
		storeNodesToVector(root, vectorObj);
		return constructBalancedBST(vectorObj, 0, vectorObj.size()-1);
	}

	private MyBSTNode constructBalancedBST(Vector<MyBSTNode> vectorObj, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end)/2;
		MyBSTNode root = vectorObj.get(mid);
		root.left = constructBalancedBST(vectorObj, start, mid-1);
		root.right = constructBalancedBST(vectorObj, mid+1, end);
		return root;
	}

	private void storeNodesToVector(MyBSTNode root, Vector<MyBSTNode> vectorObj) {
		if (root == null)
			return;
		storeNodesToVector(root.left, vectorObj);
		vectorObj.add(root);
		storeNodesToVector(root.right, vectorObj);
	}
}
