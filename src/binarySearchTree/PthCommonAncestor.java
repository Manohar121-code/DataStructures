package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PthCommonAncestor {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(50);
		bstObj.insert(30);
		bstObj.insert(70);
		bstObj.insert(60);
		bstObj.insert(55);
		bstObj.insert(65);
		
		int pthNumber = 3;
		
		PthCommonAncestor obj = new PthCommonAncestor();
		int n1 = 55, n2 = 65;
		if (n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
//		int count = 0;
//		count = obj.getCount(bstObj.root, n1, n2, count);
		
		List<Integer> nodesList = new ArrayList<>();
		obj.getCount(bstObj.root, n1, n2, nodesList);
		if (pthNumber < 1 || pthNumber > nodesList.size()) {
			System.out.println("Nothing found");
			return;
		}
		Integer pthNodeData = nodesList.get(nodesList.size() - pthNumber);
		System.out.println(pthNumber+" Node value : "+pthNodeData.intValue());
	}
	
	private List<Integer> getCount(MyBSTNode root, int n1, int n2, List<Integer> nodesList) {
		if (root == null)
			return null;
		nodesList.add(root.data);
		if (n2 < root.data)
			return getCount(root.left, n1, n2, nodesList);
		else if (n1 > root.data)
			return getCount(root.right, n1, n2, nodesList);
		return nodesList;
	}
	
	/*private int getCount(MyBSTNode root, int n1, int n2, int count) {
		if (root == null)
			return 0;
		count++;
		if (n2 < root.data)
			return getCount(root.left, n1, n2, count);
		else if (n1 > root.data)
			return getCount(root.right, n1, n2, count);
		return count;
	}*/
}
