package binaryTree;

public class DiameterOfBT {
	public static void main(String[] args) {
		/*MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.right = new MyBTNode(3);*/
		
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(1);
		root.left.left = new MyBTNode(1);
		root.left.right = new MyBTNode(1);
		root.left.right.left = new MyBTNode(1);
		root.left.right.right = new MyBTNode(1);
		
		root.right = new MyBTNode(1);
		root.right.right = new MyBTNode(1);
		root.right.right.right = new MyBTNode(1);
		root.right.right.right.left = new MyBTNode(1);
		root.right.right.right.right = new MyBTNode(1);
		root.right.right.right.left.left = new MyBTNode(1);
		root.right.right.right.left.right = new MyBTNode(1);

		DiameterOfBT obj = new DiameterOfBT();
		System.out.println(obj.doOperation(root));
	}

	private int diameter = 0;
	private int doOperation(MyBTNode root) {
		getDiameter(root);
		return diameter;
	}
	private int getDiameter(MyBTNode root) {
		if (root == null)
			return 0;
		int left = getDiameter(root.left);
		int right = getDiameter(root.right);
		root.data = Math.max(left, right) + 1;
		diameter = Math.max(diameter, left + right + 1);
		return root.data;
	}
}
