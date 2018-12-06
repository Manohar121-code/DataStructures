package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintBtInVerticalOrder {
	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.left.left = new BTNode(3);
		root.left.right = new BTNode(8);
		root.left.left.left = new BTNode(4);
		root.left.left.right = new BTNode(7);
		root.left.left.right.right = new BTNode(9);
		root.left.left.left.left = new BTNode(5);
		root.left.left.left.right = new BTNode(15);
		root.left.left.left.left.left = new BTNode(6);
		root.left.left.left.left.left.right = new BTNode(10);
		root.left.left.left.left.left.right.right = new BTNode(11);
		root.left.left.left.left.left.right.right.right = new BTNode(12);
		root.left.left.left.left.left.right.right.right.right = new BTNode(13);
		root.left.left.left.left.left.right.right.right.right.right = new BTNode(
				14);
		root.left.right.left = new BTNode(100);
		root.right = new BTNode(1000);
		root.right.right = new BTNode(1111);
		root.right.right.left = new BTNode(2222);

		PrintBtInVerticalOrder obj = new PrintBtInVerticalOrder();
		obj.printVerticalOrder(root);
	}

	private List<BTNode> nodeList = new ArrayList<>();

	private void printVerticalOrder(BTNode root) {
		doOperation(root, 1, 0);
		Collections.sort(nodeList, new ColumnComparator());
		for (BTNode btNode : nodeList) {
			System.out.print(btNode.data/*+"-"+btNode.column*/+" ");
//			System.out.println(btNode.data+"-"+btNode.row+" "+btNode.column+" ");
		}
	}

	private int doOperation(BTNode root, int rowNum, int columnNum) {
		if (root == null)
			return (columnNum < 0) ? 0 : columnNum;
		int leftColumnNum = doOperation(root.left, rowNum+1, columnNum-1);
		root.row = rowNum;
		root.column = Math.max(root.column, Math.max(leftColumnNum+1, columnNum+1));
		nodeList.add(root);
		int rightColumnNum = doOperation(root.right, rowNum+1, root.column);
		return Math.max(root.column, columnNum);
	}
}

class BTNode {
	BTNode left;
	BTNode right;
	int data;
	int row, column;

	public BTNode(int data) {
		this.data = data;
		this.row = 0;
		this.column = 0;
		this.left = this.right = null;
	}
}

class ColumnComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		BTNode s1 = (BTNode) o1;
		BTNode s2 = (BTNode) o2;

		if (s1.column == s2.column) {
			if (s1.row == s2.row)
				return 0;
			else if (s1.row > s2.row)
				return 1;
			else
				return -1;
		}
		else if (s1.column > s2.column)
			return 1;
		else
			return -1;
	}
}