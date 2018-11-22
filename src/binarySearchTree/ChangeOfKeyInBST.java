package binarySearchTree;

public class ChangeOfKeyInBST {
	public static void main(String[] args) {
		int[] arr = {20, 8, 22, 4, 12, 10, 14};
		MyBST bstObj = new MyBST();
		for (int i : arr) {
			bstObj.insert(i);
		}
		ChangeOfKeyInBST obj = new ChangeOfKeyInBST();
		int oldVal = 8, newVal = 1;
		MyBSTNode root = obj.doOperation(bstObj.root, oldVal, newVal);
		obj.printInOrder(root);
	}

	private MyBSTNode doOperation(MyBSTNode root, int oldVal, int newVal) {
		root = deleteNode(root, oldVal);
		insert(root, newVal);
		return root;
	}
	
	private MyBSTNode insert(MyBSTNode node, int data) {
		if (node == null) {
			return node = new MyBSTNode(data);
		}

		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	private int getLeastNodeFromRightSubTree(MyBSTNode node) {
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node.data;
	}

	private MyBSTNode deleteNode(MyBSTNode root, int data) {
		if (data < root.data) {
			root.left = deleteNode(root.left, data);
		} else if (data > root.data) {
			root.right = deleteNode(root.right, data);
		} else {
			if (root.left == null && root.right == null)
				return null;
			else if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				int lessRightTreeData = getLeastNodeFromRightSubTree(root.right);
				root.data = lessRightTreeData;
				root.right = deleteNode(root.right, lessRightTreeData);
			}
		}
		return root;
	}

	private void printInOrder(MyBSTNode root) {
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
}
