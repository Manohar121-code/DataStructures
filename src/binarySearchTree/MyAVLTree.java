package binarySearchTree;

class AVLNode {
	AVLNode left, right;
	int data, height;
	public AVLNode(int data) {
		this.data = data;
		this.left = this.right = null;
		this.height = 0;
	}
}

public class MyAVLTree {
	private AVLNode root;
	
	public MyAVLTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	private int height(AVLNode node) {
		return node != null ? node.height : -1;
	}
	
}