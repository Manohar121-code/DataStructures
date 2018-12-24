package binaryTree;

public class ConstructTreeFromInOrderPreOrder {
	public static void main(String[] args) {
		int[] inOrder =  {3, 7, 1, 4, 0, 5, 2, 6};
		int[] preOrder = {0, 1, 3, 7, 4, 2, 5, 6};

		ConstructTreeFromInOrderPreOrder obj = new ConstructTreeFromInOrderPreOrder();
		MyBTNode root = obj.doOperation(inOrder, preOrder, 0, inOrder.length-1);
		obj.postOrder(root);
	}

	private int preOrderIndex = 0;
	private MyBTNode doOperation(int[] inOrder, int[] preOrder, int start, int end) {
		if (start > end)
			return null;
		int rootIndex = findInOrderRootIndex(inOrder, preOrder[preOrderIndex++], start, end);
		MyBTNode root = new MyBTNode(inOrder[rootIndex]);
		root.left = doOperation(inOrder, preOrder, start, rootIndex-1);
		root.right = doOperation(inOrder, preOrder, rootIndex+1, end);
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
	
	private void postOrder(MyBTNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
}
