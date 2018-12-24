package binaryTree;

public class BinaryTreeToCDLL {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.left.right.left = new MyBTNode(7);

		root.right = new MyBTNode(3);
		root.right.right = new MyBTNode(6);
		root.right.right.left = new MyBTNode(8);

		BinaryTreeToCDLL obj = new BinaryTreeToCDLL();
		root = obj.BToCDLL(root);
		obj.printList(root);
	}

	MyBTNode resultDDLNode, prevNode;
	private MyBTNode BToCDLL(MyBTNode root) {
		doOperation(root);
		prevNode.right = resultDDLNode;
		resultDDLNode.left = prevNode;
		return resultDDLNode;
	}

	private void doOperation(MyBTNode root) {
		if (root == null)
			return;
		doOperation(root.left);
		if (resultDDLNode == null) {
			resultDDLNode = root;
		} else {
			prevNode.right = root;
			root.left = prevNode;
		}
		prevNode = root;
		doOperation(root.right);
	}

	private void printList(MyBTNode root) {
		MyBTNode itr = root;
		do {
			System.out.print(itr.data + " ");
			itr = itr.right;
		} while (root != itr);
		System.out.println();
		itr = itr.left;
		do {
			System.out.print(itr.data + " ");
			itr = itr.left;
		} while (root != itr);
		System.out.println(itr.data + " ");
	}
}