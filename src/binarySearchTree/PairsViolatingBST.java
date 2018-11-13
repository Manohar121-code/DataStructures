package binarySearchTree;

public class PairsViolatingBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.root = new MyBSTNode(50);
		bstObj.root.left = new MyBSTNode(30);
		bstObj.root.left.left = new MyBSTNode(20);
		bstObj.root.left.right = new MyBSTNode(25);
		bstObj.root.right = new MyBSTNode(60);
		bstObj.root.right.left = new MyBSTNode(10);
		bstObj.root.right.right = new MyBSTNode(40);
		
		bstObj.inOrder(bstObj.root);
		System.out.println();

		PairsViolatingBST obj = new PairsViolatingBST();
		MyBSTNode root = obj.pairsViolatingBST(bstObj.root);
	}

	private MyBSTNode pairsViolatingBST(MyBSTNode root) {
		
		return null;
	}
}
