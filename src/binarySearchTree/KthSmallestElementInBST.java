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
		obj.findKthSmallestElement(bstObj.root, k);
	}

	private void findKthSmallestElement(MyBSTNode root, int k) {
		
	}
}
