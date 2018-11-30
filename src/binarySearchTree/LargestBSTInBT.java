package binarySearchTree;

public class LargestBSTInBT {
	public static void main(String[] args) {
//		3 2 L 3 4 R
		/*MyBSTNode root = new MyBSTNode(1);
		root.left = new MyBSTNode(3);
		root.right = new MyBSTNode(2);*/
		
		/*MyBSTNode root = new MyBSTNode(10);
		root.left = new MyBSTNode(8);
		root.right = new MyBSTNode(12);
		root.left.left = new MyBSTNode(7);
		root.left.right = new MyBSTNode(13);
		root.right.left = new MyBSTNode(11);
		root.right.right = new MyBSTNode(15);*/
		
		MyBSTNode root = new MyBSTNode(1);
		root.left = new MyBSTNode(10);
		root.right = new MyBSTNode(20);
		root.right.left = new MyBSTNode(30);
		root.right.left.right = new MyBSTNode(40);
		
		/*MyBSTNode root = new MyBSTNode(20);
		root.left = new MyBSTNode(10);
		root.left.left = new MyBSTNode(5);
		root.left.left.left = new MyBSTNode(1);
		root.left.left.left.right = new MyBSTNode(50);*/
		
//		10 20 L 10 30 R 20 40 L 20 60 R
		/*MyBSTNode root = new MyBSTNode(10);
		root.left = new MyBSTNode(20);
		root.right = new MyBSTNode(30);
		root.left.left = new MyBSTNode(40);
		root.left.right = new MyBSTNode(60);
		root.left.right.right = new MyBSTNode(70);*/
		
		LargestBSTInBT obj = new LargestBSTInBT();
		System.out.println(obj.getNumOfNodesForLargestBst2(root));
	}
	
	private int maxNumOfNodes2 = 0;
	public int getNumOfNodesForLargestBst2(MyBSTNode root) {
		doOperation2(root);
		return maxNumOfNodes2;
	}
	
	private int doOperation2(MyBSTNode root) {
		if (root == null)
			return 0;
		int leftNodesCount = doOperation2(root.left);
		int rightNodesCount = doOperation2(root.right);
//		int result = (root.left == null || root.left.data < root.data) && (root.right == null || root.data < root.right.data) ? leftNodesCount + 1 + rightNodesCount : 1;
		int result = (root.left == null || (leftNodesCount != -1 && root.left.data < root.data)) &&
				(root.right == null || (rightNodesCount != -1 && root.data < root.right.data)) ? leftNodesCount + 1 + rightNodesCount : -1;
		maxNumOfNodes2 = Math.max(maxNumOfNodes2, result);
		return result;
	}

	private int maxNumOfNodes = 0;
	public int getNumOfNodesForLargestBst(MyBSTNode root) {
		doOperation(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return maxNumOfNodes;
	}
	
	private int doOperation(MyBSTNode root, int minValue, int maxValue) {
		if (root == null)
			return 0;
		int leftNodesCount = doOperation(root.left, minValue, root.data);
		int rightNodesCount = doOperation(root.right, root.data, maxValue);
		
//		int result = (root.left == null || root.left.data < root.data) && (root.right == null || root.data < root.right.data) ? leftNodesCount + 1 + rightNodesCount : 1;
		int result = (root.left == null || (minValue < root.left.data && root.left.data < root.data)) && (root.right == null || (root.data < root.right.data && root.right.data < maxValue)) ? leftNodesCount + 1 + rightNodesCount : 1;
		maxNumOfNodes = Math.max(maxNumOfNodes, result);
		return result;
	}
}
