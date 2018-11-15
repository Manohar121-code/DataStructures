package binarySearchTree;

import java.util.HashSet;
import java.util.Set;

public class CommonNodesInBSTs {
	public static void main(String[] args) {
		MyBST bstObj1 = new MyBST();
		bstObj1.insert(5);
		bstObj1.insert(1);
		bstObj1.insert(10);
		bstObj1.insert(0);
		bstObj1.insert(4);
		bstObj1.insert(7);
		bstObj1.insert(9);
		
		MyBST bstObj2 = new MyBST();
		bstObj2.insert(10);
		bstObj2.insert(7);
		bstObj2.insert(20);
		bstObj2.insert(4);
		bstObj2.insert(9);
		CommonNodesInBSTs obj = new CommonNodesInBSTs();
		
		obj.printCommon(bstObj1.root, bstObj2.root);
	}

	private void printCommon(MyBSTNode root, MyBSTNode root2) {
		Set<Integer> set = new HashSet<>();
		fillSetForHashing(root, set);
		getCommonFromSet(root2, set);
	}

	private void fillSetForHashing(MyBSTNode root, Set<Integer> set) {
		if (root == null)
			return;
		fillSetForHashing(root.left, set);
		set.add(root.data);
		fillSetForHashing(root.right, set);
	}

	private void getCommonFromSet(MyBSTNode root, Set<Integer> set) {
		if (root == null)
			return;
		getCommonFromSet(root.left, set);
		if (set.contains(root.data))
			System.out.print(root.data+" ");
		getCommonFromSet(root.right, set);
	}
	
}
