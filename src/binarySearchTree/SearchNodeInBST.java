package binarySearchTree;

public class SearchNodeInBST {
	public static void main(String[] args) {
		int[] arr = {2, 81, 87, 42, 66, 90, 45};
		MyBST bstObj = new MyBST();
		for (int i : arr) {
			bstObj.insert(i);
		}
		
		SearchNodeInBST obj = new SearchNodeInBST();
		System.out.println(obj.doOperation(bstObj.root, 90) ? "Found" : "Not found");
	}

	private boolean doOperation(MyBSTNode root, int i) {
		if (root == null)
			return false;
		if (i < root.data) {
			return doOperation(root.left, i);
		} else if (i > root.data) {
			return doOperation(root.right, i);
		} else {
			return true;
		}
	}
}
