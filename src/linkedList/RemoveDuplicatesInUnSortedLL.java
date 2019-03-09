package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInUnSortedLL {
	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(2);
		
		RemoveDuplicatesInUnSortedLL obj = new RemoveDuplicatesInUnSortedLL();
		head = obj.doOperation(head);
		obj.printLL(head);
	}

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	private Node doOperation(Node head) {
		Set<Integer> setObj = new HashSet<Integer>();
		Node resNode = head;
		while (head != null && head.next != null) {
			setObj.add(head.data);
			if (setObj.contains(head.next.data))
				head.next = head.next.next;
			else
				head = head.next;
		}
		return resNode;
	}
}