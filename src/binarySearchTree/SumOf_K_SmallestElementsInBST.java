package binarySearchTree;

public class SumOf_K_SmallestElementsInBST {
	public static void main(String[] args) {
		int[] arr = {20, 8, 4, 12, 10, 14, 22};
		MyBST bstObj = new MyBST();
		for (int i : arr) {
			bstObj.insert(i);
		}
		SumOf_K_SmallestElementsInBST obj = new SumOf_K_SmallestElementsInBST();
		System.out.println("Sum is : "+ obj.findSumOf_K_SmallestElements(bstObj.root, 3));
	}

	private int k = -1, sum = 0;
	private int findSumOf_K_SmallestElements(MyBSTNode root, int k) {
		this.k = k;
		doOperation(root);
		return sum;
	}

	private void doOperation(MyBSTNode root) {
		if (root == null || k == 0)
			return;
		doOperation(root.left);
		if (k > 0)
			sum += root.data;k--;
		doOperation(root.right);
	}
}
