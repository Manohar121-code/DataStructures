package linkedList;

import java.io.IOException;
import java.util.Scanner;

class Node2 {
	int value;
	Node2 next;

	Node2(int value) {
		this.value = value;
	}
}

public class SortLinkedListOf_012 {
	private Node2 head;

	public void addToTheLast(Node2 node) {
		if (head == null) {
			head = node;
		} else {
			Node2 temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public void printList(Node2 head) {
		Node2 temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void linksort(Node2 head) {
		Node2 zeroNode = null, firstNode = null, secondNode = null;
		while (head != null) {
			Node2 tempNext = head.next; head.next = null;
			switch (head.value) {
			case 0:
				zeroNode = (zeroNode != null) ? addToNext(zeroNode, head) : head;
				break;
			case 1:
				firstNode = (firstNode != null) ? addToNext(firstNode, head) : head;
				break;
			case 2:
				secondNode = (secondNode != null) ? addToNext(secondNode, head) : head;
				break;
			default:
				break;
			}
			head = tempNext;
		}
		while (zeroNode != null && zeroNode.next != null) {
			zeroNode = zeroNode.next;
		}
		if (zeroNode != null) {
			zeroNode.next = firstNode;
		}
		while (firstNode != null && firstNode.next != null) {
			firstNode = firstNode.next;
		}
		if (firstNode != null) {
			firstNode.next = secondNode;
		}
		head =  (zeroNode != null) ? zeroNode : (firstNode != null) ? firstNode : secondNode;
	}

	private Node2 addToNext(Node2 existedNode, Node2 addNode) {
		addNode.next = existedNode;
		return addNode;
	}

	public static void main(String[] args) throws IOException {
		SortLinkedListOf_012 obj = new SortLinkedListOf_012();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			Node2 head = new Node2(a1);
			obj.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				obj.addToTheLast(new Node2(a));
			}
			obj.linksort(head);
			obj.printList(head);
			t--;
		}
	}
}
