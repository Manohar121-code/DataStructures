package binaryTree;

public class ConstructTreeFromInOrderPostOrder {
	public static void main(String[] args) {
		int[] inOrder =   {4, 8, 2, 5, 1, 6, 3, 7};
		int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};

		ConstructTreeFromInOrderPostOrder obj = new ConstructTreeFromInOrderPostOrder();
		MyBTNode root = obj.doOperation(inOrder, postOrder, 0, inOrder.length-1);
		obj.preOrder(root);
	}

	private int postOrderIndex = 7;
	private MyBTNode doOperation(int[] inOrder, int[] postOrder, int start, int end) {
		if (start > end)
			return null;
		int rootIndex = findInOrderRootIndex(inOrder, postOrder[postOrderIndex--], start, end);
		MyBTNode root = new MyBTNode(inOrder[rootIndex]);
		root.right = doOperation(inOrder, postOrder, rootIndex+1, end);
		root.left = doOperation(inOrder, postOrder, start, rootIndex-1);
		return root;
	}

	private int findInOrderRootIndex(int[] inOrder, int k, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == k) {
				return i;
			}
		}
		return -1;
	}
	
	private void preOrder(MyBTNode root) {
		if (root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}