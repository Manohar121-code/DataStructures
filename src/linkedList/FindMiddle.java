package linkedList;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class FindMiddle {
	Node head; // head of list

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}
	
	static int getMiddle(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public static void main(String args[]) {
		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num of testcases : ");
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			FindMiddle llist = new FindMiddle();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			long startTime = System.nanoTime();
			System.out.println(getMiddle(llist.head));
			long endTime = System.nanoTime();
			System.out.println("Time taken : "+(endTime - startTime));
			t--;
		}
	}
}
