package binarySearchTree;

public class DeleteNodesGreaterThan_K {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);
		bstObj.inOrder(bstObj.root);
		System.out.println();
		
		DeleteNodesGreaterThan_K obj = new DeleteNodesGreaterThan_K();
		int k = 12;
		MyBSTNode root = obj.byGFG(bstObj.root, k);
//		MyBSTNode root = obj.deleteNodesGreaterThan_K(bstObj.root, k);
		bstObj.inOrder(root);
	}
	
	private MyBSTNode byGFG(MyBSTNode root, int k) {
		if (root == null)
			return null;
		if (root.data >= k) {
			return byGFG(root.left, k);
		} else {
			root.right = byGFG(root.right, k);
			return root;
		}
	}

	private MyBSTNode deleteNodesGreaterThan_K(MyBSTNode root, int k) {
		while (root != null && root.data >= k) {
			root = root.left;
		}
		deleteNodesGreaterThan_K(root, null, k);
		return root;
	}

	private void deleteNodesGreaterThan_K(MyBSTNode root, MyBSTNode parentNode, int k) {
		if (root == null)
			return;
		deleteNodesGreaterThan_K(root.left, root, k);
		deleteNodesGreaterThan_K(root.right, root, k);
		if (root.data >= k)
			parentNode = deleteNode(parentNode, root.data);
	}
	
	private MyBSTNode deleteNode(MyBSTNode root, int data) {
		if (root == null)
			return null;
		if (data < root.data)
			root.left = deleteNode(root.left, data);
		else if (data > root.data)
			root.right = deleteNode(root.right, data);
		else {
			if (root.left == null && root.right == null)
				return null;
			else if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
		}
		return root;
	}
}
