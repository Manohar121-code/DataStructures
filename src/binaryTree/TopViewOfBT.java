package binaryTree;

public class TopViewOfBT {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.right = new MyBTNode(3);
		
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		
		root.right.left = new MyBTNode(6);
		root.right.right = new MyBTNode(7);
		
		root.left.left.left = new MyBTNode(8);
		root.left.right.left = new MyBTNode(9);
		
		root.right.left.right = new MyBTNode(10);
		root.right.right.right = new MyBTNode(11);
		
		TopViewOfBT obj = new TopViewOfBT();
		obj.doIt(root);
	}

	MyBTNode tempRoot = null;
	private void doIt(MyBTNode root) {
		tempRoot = root;
		doOperation(root, 'L');
	}

	private void doOperation(MyBTNode root, char ch) {
		if (root == null)
			return;
		if (ch == 'L')
			doOperation(root.left, ch);
		System.out.print(root.data+" ");
		if (root == tempRoot)
			ch = 'R';
		if (ch == 'R')
			doOperation(root.right, ch);
	}
}
