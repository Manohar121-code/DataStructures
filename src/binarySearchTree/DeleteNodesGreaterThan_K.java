package binarySearchTree;

import javax.xml.transform.Templates;

public class DeleteNodesGreaterThan_K {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		/*bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);*/
		
		String input = "887 778 916 794 336 387 493 650 422 363 28 691 60 764 927 541 427 173 737 212 369 568 430 783 531 863 124 68 136 930 803 23 59 70 168 394 457 12 43 230 374 422 920 785 538 199 325 316 371 414 527 92 981 957 874 863 171 997 282 306 926 85 328 337 506 847 730 314 858 125 896 583 546 815 368 435 365 44 751 88 809 277 179 789";
		String[] split = input.split(" ");
		for (String s : split) {
			bstObj.insert(Integer.parseInt(s));
		}
		bstObj.inOrder(bstObj.root);
		System.out.println();
		
		DeleteNodesGreaterThan_K obj = new DeleteNodesGreaterThan_K();
		int k = 926;
		MyBSTNode root = obj.byGFG(bstObj.root, k);
//		MyBSTNode root = obj.deleteNodesGreaterThan_K(bstObj.root, k);
		bstObj.inOrder(root);
		
		System.out.println("\n--------------------");
		MyBSTNode rootNode = bstObj.root;
		while (root != null && rootNode.data >= k) {
			rootNode = rootNode.left;
		}
		MyBSTNode root2 = obj.byManohar(rootNode, k);
		bstObj.inOrder(root2);
	}
	
	private MyBSTNode byManohar(MyBSTNode root, int k) {
		if (root == null)
			return null;
		root.left = byManohar(root.left, k);
		root.right = byManohar(root.right, k);
		return (root.data < k) ? root : null;
	}

	private MyBSTNode byGFG(MyBSTNode root, int k) {
		if (root == null)
			return null;
		if (root.data >= k) {
			return byGFG(root.left, k);
		} else {
			root.right = byGFG(root.right, k);
			return root;
		}
	}

	private MyBSTNode deleteNodesGreaterThan_K(MyBSTNode root, int k) {
		while (root != null && root.data >= k) {
			root = root.left;
		}
		deleteNodesGreaterThan_K(root, null, k);
		return root;
	}

	private void deleteNodesGreaterThan_K(MyBSTNode root, MyBSTNode parentNode, int k) {
		if (root == null)
			return;
		deleteNodesGreaterThan_K(root.left, root, k);
		deleteNodesGreaterThan_K(root.right, root, k);
		if (root.data >= k)
			parentNode = deleteNode(parentNode, root.data);
	}
	
	private MyBSTNode deleteNode(MyBSTNode root, int data) {
		if (root == null)
			return null;
		if (data < root.data)
			root.left = deleteNode(root.left, data);
		else if (data > root.data)
			root.right = deleteNode(root.right, data);
		else {
			if (root.left == null && root.right == null)
				return null;
			else if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
		}
		return root;
	}
}
