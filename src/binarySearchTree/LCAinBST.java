package binarySearchTree;

public class LCAinBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);
		
		LCAinBST obj = new LCAinBST();
		int n1 = 900, n2 = 202;
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
