package linkedList;

public class InsertElementInSortedLL {
	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(6);
		head.next.next.next.next = new Node(7);
		head.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next = new Node(11);
		int k = 12;
		InsertElementInSortedLL obj = new InsertElementInSortedLL();
		head = obj.doOperation(head, k);
		obj.printLL(head);
	}

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	private Node doOperation(Node head, int k) {
		Node prevSmall = null, start = head;
		while (start != null && k > start.data) {
			prevSmall = start;
			start = start.next;
		}
		Node obj = new Node(k);
		if (prevSmall != null) {
			Node temp = prevSmall.next;
			prevSmall.next = obj;
			prevSmall.next.next = temp;
		} else {
			obj.next = head;
			head = obj;
		}
		return head;
	}
}
