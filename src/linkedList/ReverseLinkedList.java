package linkedList;

import java.io.IOException;
import java.io.PrintWriter;

public class ReverseLinkedList {
	Node head; // head of lisl
	Node lastNode;
	static PrintWriter out;

	/* Linked list Node */
	/* Utility functions */
	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			lastNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}
	}

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//  >------------------------------------------------------------------------->
	Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node temp = null;
		while (current.next != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		current.next = prev;
		return current;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) throws IOException {
		/*
		 * Constructed Linked List is 1->2->3->4->5->6->7->8->8->9->null
		 */
		ReverseLinkedList llist = new ReverseLinkedList();
		llist.addToTheLast(new Node(1));
		llist.addToTheLast(new Node(2));
		llist.addToTheLast(new Node(3));
		llist.addToTheLast(new Node(4));
		llist.addToTheLast(new Node(5));
		llist.addToTheLast(new Node(6));
		llist.addToTheLast(new Node(7));
		llist.addToTheLast(new Node(8));
		llist.addToTheLast(new Node(9));
		llist.addToTheLast(new Node(10));
		llist.addToTheLast(new Node(11));
		llist.addToTheLast(new Node(12));
		llist.addToTheLast(new Node(13));
		llist.addToTheLast(new Node(14));
		llist.addToTheLast(new Node(15));
		llist.addToTheLast(new Node(16));
		llist.addToTheLast(new Node(17));
		llist.addToTheLast(new Node(18));
		llist.printList(llist.head);
		long startTime = System.nanoTime();
		Node res = llist.reverse(llist.head);
		long endTime = System.nanoTime();
		System.out.println("Time taken : "+(endTime - startTime));
		llist.printList(res);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			ReverseLinkedList llist = new ReverseLinkedList();
			String nums[] = br.readLine().split(" ");
			if (n > 0) {
				int a1 = Integer.parseInt(nums[0]);
				Node head = new Node(a1);
				llist.addToTheLast(head);
			}
			for (int i = 1; i < n; i++) {
				int a = Integer.parseInt(nums[i]);
				llist.addToTheLast(new Node(a));
			}
			llist.head = llist.reverse(llist.head);

			llist.printList();

			t--;
		}
		out.close();*/
	}
}
