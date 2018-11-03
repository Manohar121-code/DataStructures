package binarySearchTree;

public class PredecessorAndSuccessor {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(50);
		bstObj.insert(30);
		bstObj.insert(20);
		bstObj.insert(40);
		bstObj.insert(70);
		bstObj.insert(60);
		bstObj.insert(80);

		PredecessorAndSuccessor obj = new PredecessorAndSuccessor();
		Result p = new Result();
		Result s = new Result();
		obj.getPreAndSucc(bstObj.root, p, s, 60);
		System.out.println(((p.pre != null) ? p.pre.data : -1) +" "+ ((s.succ != null) ? s.succ.data : -1));
	}

	private void getPreAndSucc(MyBSTNode root, Result p, Result s, int key) {
		if (root == null)
			return;
		if (key < root.data) {
			s.succ = root;
			getPreAndSucc(root.left, p, s, key);
		} else if (key > root.data) {
			p.pre = root;
			getPreAndSucc(root.right, p, s, key);
		} else {
			if (root.left == null && root.right == null) {
				return;
			} else if (root.left == null) {
				s.succ = root.right;
			} else if (root.right == null) {
				p.pre = root.left;
			} else {
				// getting less value from right tree
				MyBSTNode tempRight = root.right;
				while (tempRight != null && tempRight.left != null) {
					tempRight = tempRight.left;
				}
				s.succ = tempRight;
				
				// getting greater value from left tree
				MyBSTNode tempLeft = root.left;
				while (tempLeft != null && tempLeft.right != null) {
					tempLeft = tempLeft.right;
				}
				p.pre = tempLeft;
			}
		}
	}
}

class Result {
	MyBSTNode pre = null;
	MyBSTNode succ = null;
}
