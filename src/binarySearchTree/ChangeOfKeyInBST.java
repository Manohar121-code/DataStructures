package binarySearchTree;

public class ChangeOfKeyInBST {
	public static void main(String[] args) {
		int[] arr = {20, 8, 22, 4, 12, 10, 14};
		ChangeOfKeyInBST obj = new ChangeOfKeyInBST();
		int oldVal = 8, newVal = 1;
		MyBSTNode root = obj.doOperation(arr, oldVal, newVal);
		obj.printInOrder(root);
	}

	private MyBSTNode doOperation(int[] arr, int oldVal, int newVal) {
		
		return null;
	}
	
	private void printInOrder(MyBSTNode root) {
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
}
