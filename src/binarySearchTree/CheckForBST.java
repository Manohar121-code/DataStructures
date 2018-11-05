package binarySearchTree;

public class CheckForBST {
	
	public static void main(String[] args) {
		MyBSTNode root = new MyBSTNode(10);
		root.left = new MyBSTNode(5);
		root.right = new MyBSTNode(17);
		root.left.left = new MyBSTNode(1);
		root.left.right = new MyBSTNode(11);
		root.right.left = new MyBSTNode(13);
		root.right.right = new MyBSTNode(20);

		CheckForBST obj = new CheckForBST();
		
		//best way
		if (obj.checkForBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Its a BST");
		else
			System.out.println("Its not a BST");
		
		/*// worst way
		if (root != null)
			obj.checkIsBST(root);
		System.out.println("Its a BST");*/
	}

	private boolean checkForBst(MyBSTNode root, int minValue, int maxValue) {
		if (root == null)
			return true;
		if (minValue > root.data || maxValue < root.data) {
			return false;
		}
		boolean checkForBst = checkForBst(root.left, minValue, root.data-1);
		boolean checkForBst2 = checkForBst(root.right, root.data+1, maxValue);
		return checkForBst && checkForBst2;
	}

	private int checkIsBST(MyBSTNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int LRvalue = Integer.MIN_VALUE;
		LRvalue = checkIsBST(root.left);
		if (LRvalue != Integer.MIN_VALUE) {
			if (LRvalue > root.data) {
				System.out.println("Not a BST");
				System.exit(0);
			}
		}
		LRvalue = checkIsBST(root.right);
		if (LRvalue != Integer.MIN_VALUE) {
			if (LRvalue < root.data) {
				System.out.println("Not a BST");
				System.exit(0);
			}
		} else {
			LRvalue = root.data;
		}
		return LRvalue;
	}
	
}
