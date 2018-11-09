package binarySearchTree;

public class PthCommonAncestor {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(50);
		bstObj.insert(30);
		bstObj.insert(70);
		bstObj.insert(60);
		bstObj.insert(55);
		bstObj.insert(65);
		
		PthCommonAncestor obj = new PthCommonAncestor();
		int n1 = 55, n2 = 65;
		if (n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		MyBSTNode lcaObj = obj.FindLCA(bstObj.root, n1, n2);
		System.out.println(lcaObj != null ? lcaObj.data : "Nothing found");
	}

	private MyBSTNode FindLCA(MyBSTNode root, int n1, int n2) {
		if (root == null)
			return null;
		if (n2 < root.data)
			return FindLCA(root.left, n1, n2);
		else if (n1 > root.data)
			return FindLCA(root.right, n1, n2);
		return root;
	}
}
