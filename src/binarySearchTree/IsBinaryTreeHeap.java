package binarySearchTree;

public class IsBinaryTreeHeap {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.root = new MyBSTNode(5);
		bstObj.root.left = new MyBSTNode(2);
		bstObj.root.right = new MyBSTNode(3);
//		bstObj.root.right.left = new MyBSTNode(4);
		
		IsBinaryTreeHeap obj = new IsBinaryTreeHeap();
		System.out.println(obj.doOperation(bstObj.root) ? "Its a Heap" : "Its not a Heap");
	}

	private boolean doOperation(MyBSTNode root) {
		if (root == null)
			return true;
		boolean check = true;
		if (root.left != null)
			check = root.data > root.left.data;
		if (check && root.left != null)
			check = root.data > root.left.data;
		return check && doOperation(root.left) && doOperation(root.right);
	}
}
