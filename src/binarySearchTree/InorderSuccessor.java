package binarySearchTree;

public class InorderSuccessor {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);

		InorderSuccessor obj = new InorderSuccessor();
		Result s = new Result();
		obj.getInorderSuccessor(bstObj.root, s, 8);
		System.out.println((s.succ != null) ? s.succ.data : -1);
		System.out.println("------------");
		obj.getInorderSuccessor(bstObj.root, s, 10);
		System.out.println((s.succ != null) ? s.succ.data : -1);
	}

	private void getInorderSuccessor(MyBSTNode root, Result s, int k) {
		if (root == null)
			return;
		if (root.data > k) {
			s.succ = root;
			getInorderSuccessor(root.left, s, k);
		} else {
			getInorderSuccessor(root.right, s, k);
		}
	}
}
