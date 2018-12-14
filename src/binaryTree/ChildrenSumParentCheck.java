package binaryTree;

public class ChildrenSumParentCheck {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(4);
		root.left = new MyBTNode(1);
		root.right = new MyBTNode(3);
		root.right.left = new MyBTNode(3);
		root.right.right = new MyBTNode(0);

		ChildrenSumParentCheck obj = new ChildrenSumParentCheck();
		System.out.println(obj.doOperation(root));
	}

	private int doOperation(MyBTNode root) {
		if (root == null || (root.left == null && root.right == null))
			return 1;
		return (root.data == (root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0)) 
				? (doOperation(root.left) == 1 && doOperation(root.right) == 1) ? 1 : 0 : 0;
	}
}
