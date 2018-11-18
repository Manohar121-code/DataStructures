package binarySearchTree;

public class CheckBSTContainsDeadEnd {
	public static void main(String[] args) {
//		int[] arr = {8, 5, 9, 7, 2, 1};
		int[] arr = {8, 7, 10, 9, 13, 2};
		MyBST bstObj = new MyBST();
		for (int i : arr) {
			bstObj.insert(i);
		}
		
		CheckBSTContainsDeadEnd obj = new CheckBSTContainsDeadEnd();
		int min = 0, max = Integer.MAX_VALUE;
		boolean isDeadEndThere = obj.doOperation(bstObj.root, min, max);
		System.out.println(isDeadEndThere);
	}

	private boolean doOperation(MyBSTNode root, int min, int max) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data - min <= 1 && max - root.data <= 1) {
			return true;
		}
		return doOperation(root.left, min, root.data) || doOperation(root.right, root.data, max);
	}
}
