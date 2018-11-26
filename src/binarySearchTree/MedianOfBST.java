package binarySearchTree;

public class MedianOfBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		String input = "1 3 4 6 7 8";
		String[] split = input.split(" ");
		for (String s : split) {
			bstObj.insert(Integer.parseInt(s));
		}
		
		MedianOfBST obj = new MedianOfBST();
		int numOfNodes = obj.countNodes(bstObj.root);
		System.out.println(obj.getMedian(bstObj.root, numOfNodes));
	}

	private int getMedian(MyBSTNode root, int numOfNodes) {
		
	}

	private int countNodes(MyBSTNode root) {
		if (root == null)
			return 0;
		return countNodes(root.left) + 1 + countNodes(root.right);
	}
}
