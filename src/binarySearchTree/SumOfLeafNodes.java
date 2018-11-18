package binarySearchTree;

public class SumOfLeafNodes {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);

		SumOfLeafNodes obj = new SumOfLeafNodes();
		int leafSum = obj.doOperation(bstObj.root);
		System.out.println(leafSum);
	}

	private int doOperation(MyBSTNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		return doOperation(root.left) + doOperation(root.right);
	}
}
