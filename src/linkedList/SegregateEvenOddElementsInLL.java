package linkedList;

import java.util.Scanner;

public class SegregateEvenOddElementsInLL {
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		SegregateEvenOddElementsInLL obj = new SegregateEvenOddElementsInLL();
		while (testCases-- > 0) {
			int len = scr.nextInt();
			Node head = new Node(scr.nextInt()), prev = head;
			while (--len > 0) {
				prev = prev.next = new Node(scr.nextInt());				
			}
			
			Node res = obj.doOperation(head);
			obj.printLL(res);
			System.out.println();
		}
		
	}
	
	/*public static void main(String[] args) {
		Node head = new Node(8), prev = head;
		
		prev = prev.next = new Node(12);
		prev = prev.next = new Node(10);
		prev = prev.next = new Node(5);
		prev = prev.next = new Node(4);
		prev = prev.next = new Node(1);
		prev = prev.next = new Node(6);
		
		SegregateEvenOddElementsInLL obj = new SegregateEvenOddElementsInLL();
		Node res = obj.doOperation(head);
		obj.printLL(res);
	}*/

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	private Node doOperation(Node head) {
		Node evenStart, even, oddStart, odd;
		evenStart = even = new Node(1);
		oddStart = odd = new Node(1);
		while (head != null) {
			if (head.data % 2 == 0) {
				even.next = new Node(head.data);
				even = even.next;
			} else {
				odd.next = new Node(head.data);
				odd = odd.next;
			}
			head = head.next;
		}
		even.next = oddStart.next;
		return evenStart.next;
	}
}
