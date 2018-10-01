package binarySearchTree;

public class BSTImplementation {
	public static Node root;

	public BSTImplementation() {
		this.root = null;
	}
	
	public void insert(int i) {
		Node newNode = new Node(i);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		while (true) {
			if (i < current.value) {
				if (current.left == null) {
					current.left = newNode;
					return;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = newNode;
					return;
				}
				current = current.right;
			}
		}
	}
	
	public void traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			System.out.print(root.value+" ");
			traverse(root.right);
		}
	}

	public static void main(String[] args) {
		BSTImplementation bstObj = new BSTImplementation();
		bstObj.insert(40);
		bstObj.insert(2);
		bstObj.insert(34);
		bstObj.insert(78);
		bstObj.insert(36);
		bstObj.insert(81);
		bstObj.insert(67);
//		System.out.println(root.value);
		bstObj.traverse(root);
	}
}

class Node {
	Node left;
	Node right;
	int value;

	public Node() {
		super();
	}

	public Node(int value) {
		super();
		this.left = null;
		this.right = null;
		this.value = value;
	}

}