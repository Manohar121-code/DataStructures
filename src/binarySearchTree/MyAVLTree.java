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
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k2), height(k1.right)) + 1;
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
	
//	   X     	    X     	  Z
//	  /      	   /      	 / \
//	 Y       	  Z       	Y   X
//	  \      	 /        
//	   Z     	Y         
	private AVLNode leftRightRotation(AVLNode node) {
		node.left = leftRotation(node.left);
		return rightRotation(node);
	}
	
//	 X         X         	  Z
//	  \    	    \        	 / \
//	   Y   	     Z       	X   Y
//	  /    	      \      
//	 Z     	       Y     
//	   
	private AVLNode rightLeftRotation(AVLNode node) {
		node.right = rightRotation(node.right);
		return leftRotation(node);
	}
	
	private AVLNode insert(AVLNode node, int data) {
		if (node == null)
			node = new AVLNode(data);
		else if (data < node.data) {
			node.left = insert(node.left, data);
			if (height(node.left) - height(node.right) == 2) {
				if (data < node.left.data) {
					node = rightRotation(node);
				} else {
					node = leftRightRotation(node);
				}
			}
		} else if (data > node.data) {
			node.right = insert(node.right, data);
			if (height(node.right) - height(node.left) == 2) {
				if (data > node.right.data) {
					node = leftRotation(node);
				} else {
					node = rightLeftRotation(node);
				}
			}
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	
	public void insert(int data) {
		root = insert(root, data);
		System.out.println("Inserted "+ data);
	}
	
	private int countNodes(AVLNode node) {
		if (node == null)
			return 0;
		int n = 1;
		n += countNodes(node.left);
		n += countNodes(node.right);
		return n;
	}

	public int countNodes() {
		return countNodes(root);
	}
	
	private boolean search(AVLNode root, int k) {
		if (root == null)
			return false;
		if (root.data == k) {
			return true;
		} else if (k < root.data) {
			return search(root.left, k);
		} else {
			return search(root.right, k);
		}
	}
	
	private boolean search(int k) {
		return search(root, k);
	}
	
	private int getBalance(AVLNode node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}
	
	private int getLeastFromRightSubTree(AVLNode node) {
		if (node != null && node.left != null) {
			node = node.left;
		}
		return node.data;
	}
	
	private AVLNode delete(AVLNode node, int k) {
		if (k < node.data) {
			node.left = delete(node.left, k);
		} else if (k > node.data) {
			node.right = delete(node.right, k);
		} else {
			if (node.left == null && node.right == null)
				node = null;
			else if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			else {
				int lessRightTreeData = getLeastFromRightSubTree(node.right);
				node.data = lessRightTreeData;
				delete(node.right, lessRightTreeData);
			}
		}
		if (node == null)
			return node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		int balance = getBalance(node);
		if (balance > 1 && getBalance(node.left) >= 0) {
			return rightRotation(node);
		}
		if (balance > 1 && getBalance(node.left) < 0) {
			return leftRightRotation(node);
		}
		if (balance < -1 && getBalance(node.right) <= 0) {
			return leftRotation(node);
		}
		if (balance < -1 && getBalance(node.right) > 0) {
			return rightLeftRotation(node);
		}
		return node;
	}
	
	public void delete(int k) {
		root = delete(root, k);
		System.out.println("Deleted : "+ k);
	}

	public static void main(String[] args) {
		MyAVLTree avlTreeObj = new MyAVLTree();
		avlTreeObj.insert(10);
		avlTreeObj.insert(20);
		avlTreeObj.insert(30);
		avlTreeObj.insert(40);
		avlTreeObj.insert(50);
		avlTreeObj.insert(60);
		avlTreeObj.insert(70);
		avlTreeObj.insert(80);
		
		int numOfNodes = avlTreeObj.countNodes();
		System.out.println("Number nodes : "+ numOfNodes);
		
		int k = 780;
		System.out.println((avlTreeObj.search(k) ? "Found " : "Not found ")+ k);
		
		avlTreeObj.delete(50);
	}

}