package binarySearchTree;

public class ConstructBSTFromPreOrder {
	
	MyBSTNode root;
//	     10
//	   /    \
//	  5      40
//	 /  \      \
//	1    7      50
	public static void main(String[] args) {
		ConstructBSTFromPreOrder obj = new ConstructBSTFromPreOrder();
//		int[] arr = {10, 5, 1, 7, 40, 50};
		int[] arr = {10, 3, 1, 9, 18, 15, 13, 17, 20, 19, 27};
		long startTime = System.nanoTime();
		obj.doOperation(arr);
		long endTime = System.nanoTime();
		obj.printInOrder();
		System.out.println("Total time taken : "+(endTime - startTime));
	}
	
	private void doOperation(int[] arr) {
		root = null;
		root = constructBstByPreOrder(root, arr, 0, arr.length-1);
	}

	private MyBSTNode constructBstByPreOrder(MyBSTNode node, int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		node = new MyBSTNode(arr[start]);
		int nextGreaterIndex = getNextGreaterElement(arr, start, end);
		//create left & right of node by recursion
		if (start+1 < nextGreaterIndex) {
			node.left = constructBstByPreOrder(node.left, arr, start+1, nextGreaterIndex-1);
		}
		if (nextGreaterIndex >= start+1) {
			node.right = constructBstByPreOrder(node.right, arr, nextGreaterIndex, end);
		}
		return node;
	}
	
	private int getNextGreaterElement(int[] arr, int start, int end) {
		int startValue = arr[start];
		for (int i = start+1; i <= end; i++) {
			if (startValue < arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private void printInOrder() {
		System.out.print("InOrder -> ");
		inOrder(root);
		System.out.println();
	}
	
	public void inOrder(MyBSTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
}
