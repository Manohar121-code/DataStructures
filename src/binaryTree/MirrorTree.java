package binaryTree;

public class MirrorTree {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(3);
		root.right = new MyBTNode(2);
		root.right.left = new MyBTNode(5);
		root.right.right = new MyBTNode(4);

		MirrorTree obj = new MirrorTree();
		obj.doOperation(root);
	}

	private void doOperation(MyBTNode root) {
		if (root == null)
			return;
		doOperation(root.left);
		doOperation(root.right);
		MyBTNode tempLeft = root.left;
		root.left = root.right;
		root.right = tempLeft;
	}
}
