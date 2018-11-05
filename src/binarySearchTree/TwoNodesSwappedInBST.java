package binarySearchTree;

public class TwoNodesSwappedInBST {
	public static void main(String[] args) {
		MyBSTNode root = new MyBSTNode(10);
		root.left = new MyBSTNode(5);
		root.right = new MyBSTNode(17);
		root.left.left = new MyBSTNode(1);
		root.left.right = new MyBSTNode(11);
		root.right.left = new MyBSTNode(8);
		root.right.right = new MyBSTNode(20);

		TwoNodesSwappedInBST obj = new TwoNodesSwappedInBST();
		obj.checkCheck(root);
	}

	private MyBSTNode n1 = null, n2 = null;
	private void checkCheck(MyBSTNode root) {
		if (checkForBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Its a BST");
		else
			System.out.println("Its not a BST");
		
		inOrder(root);
		System.out.println();
		
		int temp = n1.data;
		n1.data = n2.data;
		n2.data = temp;
		
		inOrder(root);
		System.out.println();
	}

	private void inOrder(MyBSTNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}

	private boolean checkForBst(MyBSTNode root, int minValue, int maxValue) {
		if (root == null)
			return true;
		if (minValue > root.data || maxValue < root.data) {
			if (n1 == null) {
				n1 = root;
			} else {
				n2 = root;
			}
			return false;
		}
		boolean checkForBst = checkForBst(root.left, minValue, root.data-1);
		boolean checkForBst2 = checkForBst(root.right, root.data+1, maxValue);
		return checkForBst && checkForBst2;
	}

}
