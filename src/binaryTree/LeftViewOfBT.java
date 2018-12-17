package binaryTree;

public class LeftViewOfBT {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(3);
		root.right = new MyBTNode(2);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.right.left = new MyBTNode(6);
		root.right.right = new MyBTNode(7);
		root.left.left.right = new MyBTNode(8);

		LeftViewOfBT obj = new LeftViewOfBT();
		obj.doOperation(root);
	}
	
	private void doOperation(MyBTNode root) {
		int heightOfBT = heightOfBT(root);
		getLeftView(root, 1, heightOfBT);
	}

	private boolean reached = false;
	private int actual = 0;
	
	private void getLeftView(MyBTNode root, int curr, int heightOfBT) {
		if (root == null || reached)
			return;
		if (curr > actual) {
			actual = curr;
			System.out.print(root.data+" ");
		}
		if (curr == heightOfBT) {
			reached = true;
			return;
		}
		getLeftView(root.left, curr+1, heightOfBT);
		getLeftView(root.right, curr+1, heightOfBT);
	}

	private int heightOfBT(MyBTNode root) {
		if (root == null)
			return 0;
		return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
	}
}
