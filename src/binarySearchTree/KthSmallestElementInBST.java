package binarySearchTree;

public class KthSmallestElementInBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(4);
		bstObj.insert(22);
		bstObj.insert(12);

		KthSmallestElementInBST obj = new KthSmallestElementInBST();
		int k = 3;
		obj.doOperation(bstObj.root, k);
	}
	
	private int num = -1;
	private void doOperation(MyBSTNode root, int k) {
		num = k;
		findKthSmallestElement(root);
	}

	private void findKthSmallestElement(MyBSTNode root) {
		if (root == null || num == 0)
			return;
		findKthSmallestElement(root.left);
		if (--num == 0)
			System.out.println(root.data);
		findKthSmallestElement(root.right);
	}
}
