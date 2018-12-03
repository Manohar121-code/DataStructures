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
		
		/*MyBSTNode root = new MyBSTNode(1);
		root.left = new MyBSTNode(10);
		root.right = new MyBSTNode(20);
		root.right.left = new MyBSTNode(30);
		root.right.left.right = new MyBSTNode(40);*/
		
		MyBSTNode root = new MyBSTNode(20);
		root.left = new MyBSTNode(10);
		root.left.left = new MyBSTNode(5);
		root.left.left.left = new MyBSTNode(1);
		root.left.left.left.right = new MyBSTNode(50);
		
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
		doOperation2(root.data, root, root.data);
		return maxNumOfNodes2;
	}
	
	private Util doOperation2(int start, MyBSTNode root, int end) {
		if (root == null)
			return new Util(start, 0, end);
		Util leftNodesCount = doOperation2(root.data, root.left, root.data);
		Util rightNodesCount = doOperation2(root.data, root.right, root.data);
		Util result = (leftNodesCount != null && (root.left ==null || (root.left.data < root.data && root.data > leftNodesCount.getEnd()))) &&
				(rightNodesCount != null && (root.right == null || (root.data < root.right.data && root.data < rightNodesCount.getStart()))) 
				? new Util(leftNodesCount.getStart(), leftNodesCount.getCount() + 1 + rightNodesCount.getCount(), rightNodesCount.getEnd()) 
				: null;
		if (result != null)
			maxNumOfNodes2 = Math.max(maxNumOfNodes2, result.getCount());
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

class Util {
	private int start;
	private int count;
	private int end;
	
	public Util(int start, int count, int end) {
		super();
		this.start = start;
		this.count = count;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
