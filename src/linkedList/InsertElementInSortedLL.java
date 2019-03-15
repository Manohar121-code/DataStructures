package linkedList;

public class InsertElementInSortedLL {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(6);
		head.next.next.next.next = new Node(7);
		head.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next = new Node(11);
		int k = 8;
		InsertElementInSortedLL obj = new InsertElementInSortedLL();
		obj.doOperation(head, k);
	}

	private void doOperation(Node head, int k) {
		Node prevSmall = head;
		while (head != null) {
			if () {
				
			}
			head = head.next;
		}
	}
}
