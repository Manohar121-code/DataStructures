package binaryTree;

public class DiameterOfBT {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.right = new MyBTNode(3);

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
		int currDiameter = getDiameter(root.left) + 1 + getDiameter(root.right);
		diameter = Math.max(diameter, currDiameter);
		return currDiameter;
	}
}
