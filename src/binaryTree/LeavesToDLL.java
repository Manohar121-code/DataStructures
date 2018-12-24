package binaryTree;

public class LeavesToDLL {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.left.right.left = new MyBTNode(7);
		
		root.right = new MyBTNode(3);
		root.right.right = new MyBTNode(6);
		root.right.right.left = new MyBTNode(8);

		LeavesToDLL obj = new LeavesToDLL();
		root = obj.doOperation(root);
//		obj.inOrder(root);
//		System.out.println();
	}
	
	
	private MyBTNode doOperation(MyBTNode root) {
		convertToDDL(root);
		pritntDLL();
		return resultDDLNode;
	}
	
	private MyBTNode resultDDLNode, prevNode;
	private void convertToDDL(MyBTNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (prevNode != null) {
				prevNode.right = root;
				root.left = prevNode;
			}
			prevNode = root;
			if (resultDDLNode == null) resultDDLNode = root;
			return;
		}
		convertToDDL(root.left);
		convertToDDL(root.right);
	}
	
	private void pritntDLL() {
		MyBTNode lastNode = null;
		while (resultDDLNode != null) {
				System.out.print(resultDDLNode.data+" ");
				lastNode = resultDDLNode;
				resultDDLNode = resultDDLNode.right;
		}
		System.out.println();
		while (lastNode != null) {
			System.out.print(lastNode.data+" ");
			lastNode = lastNode.left;
		}
	}

	private void inOrder(MyBTNode root) {
		while (root != null) {
			System.out.print(root.data+" ");
			root = root.right;
		}
	}
}
