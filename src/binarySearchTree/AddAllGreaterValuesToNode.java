package binarySearchTree;

public class AddAllGreaterValuesToNode {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(50);
		bstObj.insert(30);
		bstObj.insert(20);
		bstObj.insert(40);
		bstObj.insert(70);
		bstObj.insert(60);
		bstObj.insert(80);
		
		bstObj.inOrder(bstObj.root);

		AddAllGreaterValuesToNode obj = new AddAllGreaterValuesToNode();
		obj.modify(bstObj.root);
		
		System.out.println();
		bstObj.inOrder(bstObj.root);
	}

	private void modify(MyBSTNode root) {
		addAllGreaterValues(root, 0);
	}

	private int addAllGreaterValues(MyBSTNode root, int greaterValue) {
		if (root == null)
			return greaterValue;
		greaterValue = addAllGreaterValues(root.right, greaterValue);
		root.data += greaterValue;
		return addAllGreaterValues(root.left, root.data);
	}
}
