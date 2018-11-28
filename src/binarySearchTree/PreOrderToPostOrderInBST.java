package binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import linkedList.Block;
import linkedList.MyLinkedList;

public class PreOrderToPostOrderInBST {
	public static void main(String[] args) {
		int[] arr = {40, 30, 25, 32, 35, 80, 90, 100, 120};

		PreOrderToPostOrderInBST obj = new PreOrderToPostOrderInBST();
		if (new CheckPreOrderOrNot().checkPreOrderOrNot(arr)) {
			new MyBST().postOrder(obj.doOperation(arr));
			MyLinkedList LList = new MyLinkedList();
			System.out.println();
			for (int i : arr) {
				LList.add(i);
			}
			List<Integer> finalList = new ArrayList<Integer>();
			obj.doByLinkedList(LList.getHead(), finalList);
			System.out.println(finalList);
		} else
			System.out.println("NO");
	}

	private void doByLinkedList(Block head, List<Integer> finalList) {
		Block lastLeftBlock = head, firstLeftBlock = null, firstRightBlock = null;
		while (lastLeftBlock != null && lastLeftBlock.getNext() != null && head.getValue() > lastLeftBlock.getNext().getValue()) {
			lastLeftBlock = lastLeftBlock.getNext();
		}
		if (head != lastLeftBlock)
			firstLeftBlock = head.getNext();
		else
			firstLeftBlock = null;
		
		firstRightBlock = lastLeftBlock.getNext();
		lastLeftBlock.setNext(null);
		head.setNext(null);
		if (firstLeftBlock != null)
			doByLinkedList(firstLeftBlock, finalList);
		if (firstRightBlock != null)
			doByLinkedList(firstRightBlock, finalList);
		finalList.add(head.getValue());
	}

	//OP : 25, 35, 32, 30, 120, 100, 90, 80, 40
	private MyBSTNode doOperation(int[] arr) {
		MyBSTNode root = new MyBSTNode(arr[0]);
		Stack<MyBSTNode> stkObj = new Stack<>();
		stkObj.push(root);
		for (int i = 1; i < arr.length; i++) {
			MyBSTNode temp = null;
			while (!stkObj.isEmpty() && arr[i] > stkObj.peek().data) {
				temp = stkObj.pop();
			}
			if (temp != null) {
				temp.right = new MyBSTNode(arr[i]);
				stkObj.push(temp.right);
			} else {
				stkObj.peek().left = new MyBSTNode(arr[i]);
				stkObj.push(stkObj.peek().left);
			}
		}
		return root;
	}
}
