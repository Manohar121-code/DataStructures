package binarySearchTree;

public class MyBST {
	MyBSTNode root;
	
	public void insert(int data) {
		if (root == null) {
			root = new MyBSTNode(data);
			return;
		}
		insert(root, data);
	}
	public MyBSTNode insert(MyBSTNode node, int data) {
		if (node == null) {
			return node = new MyBSTNode(data);
		}
		
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public void inOrder(MyBSTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public void preOrder(MyBSTNode root) {
		if (root != null) {
			System.out.print(root.data+" ");
			inOrder(root.left);
			inOrder(root.right);
		}
	}
	
	public void postOrder(MyBSTNode root) {
		if (root != null) {
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	private boolean search(MyBSTNode root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		} else if (data < root.data) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}
	
	private void printInOrder() {
		System.out.print("InOrder -> ");
		postOrder(root);
		System.out.println();
	}
	private void printPreOrder() {
		System.out.print("PreOrder -> ");
		preOrder(root);
		System.out.println();
	}
	private void printPostOrder() {
		System.out.print("PostOrder -> ");
		inOrder(root);
		System.out.println();
	}
	
	private void search(int data) {
		if (search(root, data)) {
			System.out.println("found");
		} else {
			System.out.println("Not found");
		}
	}
	
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(10);
		bstObj.insert(3);
		bstObj.insert(18);
		bstObj.insert(9);
		bstObj.insert(15);
		bstObj.insert(1);
		bstObj.insert(20);
		bstObj.insert(13);
		
		bstObj.printInOrder();
		bstObj.printPreOrder();
		bstObj.printPostOrder();
		
		bstObj.search(100);
	}
}

class MyBSTNode {
	MyBSTNode left, right;
	int data;
	public MyBSTNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	
}