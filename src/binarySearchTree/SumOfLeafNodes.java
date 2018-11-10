package binarySearchTree;

public class SumOfLeafNodes {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(20);
		bstObj.insert(8);
		bstObj.insert(22);
		bstObj.insert(4);
		bstObj.insert(12);
		bstObj.insert(10);
		bstObj.insert(14);

		SumOfLeafNodes obj = new SumOfLeafNodes();
		
		MyBSTNode lcaObj = obj.FindLCA(bstObj.root, n1, n2);
		System.out.println(lcaObj != null ? lcaObj.data : "Nothing found");
	}
}
