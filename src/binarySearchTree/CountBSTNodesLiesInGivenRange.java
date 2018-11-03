package binarySearchTree;

public class CountBSTNodesLiesInGivenRange {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(10);
		bstObj.insert(5);
		bstObj.insert(50);
		bstObj.insert(1);
		bstObj.insert(40);
		bstObj.insert(100);
		bstObj.insert(6);
		CountBSTNodesLiesInGivenRange obj = new CountBSTNodesLiesInGivenRange();
		int start = 6, end = 50;
		int countOfNodes = obj.getCountOfNode(bstObj.root, start, end);
		System.out.println(countOfNodes);

	}

	private int getCountOfNode(MyBSTNode root, int low, int high) {
		if (root == null)
			return 0;
		int count = (root.data >= low && root.data <= high) ? 1 : 0;
		if (root.data >= low) {
			count += getCountOfNode(root.left, low, high);
		}
		if (root.data <= high) {
			count += getCountOfNode(root.right, low, high);
		}
		return count;
	}
}
