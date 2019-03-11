package binaryTree;

public class MaximumPathSum {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(15);
		root.left = new MyBTNode(5);
		root.left.left = new MyBTNode(800);
		root.left.right = new MyBTNode(1);
		root.left.left.right = new MyBTNode(-3);
		
		root.right = new MyBTNode(6);
		root.right.left = new MyBTNode(3);
		root.right.right = new MyBTNode(9);
		root.right.right.right = new MyBTNode(0);
		root.right.right.right.left = new MyBTNode(4);
		root.right.right.right.right = new MyBTNode(-1);
		root.right.right.right.right.left = new MyBTNode(10);

		MaximumPathSum obj = new MaximumPathSum();
		System.out.println(obj.doOperation(root));
	}

	private int maxSum = 0;
	private int doOperation(MyBTNode root) {
		getDiameter(root);
		return maxSum;
	}
	private int getDiameter(MyBTNode root) {
		if (root == null)
			return 0;
		int left = getDiameter(root.left);
		int right = getDiameter(root.right);
		maxSum = Math.max(maxSum, left + right + root.data);
		if (root.left == null || root.right == null) {
			return left + right + root.data;
		}
		return Math.max(left, right) + root.data;
	}
}
