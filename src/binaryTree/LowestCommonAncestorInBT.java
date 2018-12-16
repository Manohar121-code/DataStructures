package binaryTree;

public class LowestCommonAncestorInBT {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
//		root.right = new MyBTNode(3);

		LowestCommonAncestorInBT obj = new LowestCommonAncestorInBT();
		MyBTNode result = obj.doOperation(root, 2, 3);
		System.out.println(result != null ? result.data : "Nothing");
	}

	private MyBTNode doOperation(MyBTNode root, int i, int j) {
		if (root == null)
			return new MyBTNode(0);
		if (/*root.data == i || root.data == j || */(root.left != null && root.left.data == i && root.right != null && root.right.data == j))
			return root;
		MyBTNode left = doOperation(root.left, i, j);
		if (left.data == 0) {
			MyBTNode right = doOperation(root.right, i, j);
			return (right.data != 0) ? right : new MyBTNode(0);
		}
		return left;
	}
	
	//By GFG
	MyBTNode LCA(MyBTNode root, int n1,int n2){
	    if(root==null){
	        return null;
	    }
	    if(root.data==n1 || root.data==n2){
	        return root;
	    }
	    
	    MyBTNode left=LCA(root.left,n1,n2);
	    MyBTNode right=LCA(root.right,n1,n2);
	    
	    if(left!=null && right!=null){
	        return root;
	    }
	    return left==null ? right : left;
	}
}
