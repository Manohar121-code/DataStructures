package binaryTree;

public class ZigzagTreeTraversal {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(7);
		root.left.right = new MyBTNode(6);
		
		root.right = new MyBTNode(3);
		root.right.left = new MyBTNode(5);
		root.right.right = new MyBTNode(4);

		ZigzagTreeTraversal obj = new ZigzagTreeTraversal();
		obj.doOperation(root);
	}

	private void doOperation(MyBTNode root) {
		
	}
}
