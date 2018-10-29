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
	
	private AVLNode leftRotation(AVLNode k2) {
		AVLNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(k2.left.height, k2.right.height) + 1;
		k1.height = Math.max(k2.height, k1.right.height) + 1;
		return k1;
	}
	
	private AVLNode rightRotation(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(k2.left.height, k2.right.height) + 1;
		k1.height = Math.max(k1.left.height, k2.height) + 1;
		return k1;
	}
	
}