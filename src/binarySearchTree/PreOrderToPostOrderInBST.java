package binarySearchTree;

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
			for (int i : arr) {
				LList.add(i);
			}
			Block start = obj.doByLinkedList(LList.getHead());
		} else
			System.out.println("NO");
	}

	private Block doByLinkedList(Block head) {
		if (head == null)
			return null;
		int count = 0;
		Block lastLeftBlock = head, firstRightBlock = null, lastRightBlock = null;
		head.setNext(null);
		while (lastLeftBlock != null && lastLeftBlock.getNext() != null && head.getValue() > lastLeftBlock.getNext().getValue()) {
			count++;
			lastLeftBlock = lastLeftBlock.getNext();
		}
		
		firstRightBlock = lastLeftBlock.getNext();
		lastLeftBlock.setNext(null);
		return LList;
		/*MyLinkedList left = doByLinkedList(LList);
		MyLinkedList right = doByLinkedList(LList);*/
		
		/*if (left != null && right != null) {
			left.addAll(right);
			left.addLast(root);
			return left;
		} else if (left != null && right == null) {
			left.addLast(root);
			return left
		} else if (left == null && right != null) {
			right.addLast(root);
			return right;
		} else {
			return 
		}*/
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
