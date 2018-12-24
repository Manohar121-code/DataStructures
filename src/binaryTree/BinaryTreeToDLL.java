package binaryTree;

public class BinaryTreeToDLL {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.left.right.left = new MyBTNode(7);
		
		root.right = new MyBTNode(3);
		root.right.right = new MyBTNode(6);
		root.right.right.left = new MyBTNode(8);

		BinaryTreeToDLL obj = new BinaryTreeToDLL();
		root = obj.BToDLL(root);
		obj.printList(root);
	}

	MyBTNode resultDDLNode, prevNode;
	private MyBTNode BToDLL(MyBTNode root) {
		doOperation(root);
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
		MyBTNode lastNode = null;
		while (root != null) {
				System.out.print(root.data+" ");
				lastNode = root;
				root = root.right;
		}
		System.out.println();
		while (lastNode != null) {
			System.out.print(lastNode.data+" ");
			lastNode = lastNode.left;
		}
	}
}
