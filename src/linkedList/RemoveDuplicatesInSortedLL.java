package linkedList;

public class RemoveDuplicatesInSortedLL {
	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		RemoveDuplicatesInSortedLL obj = new RemoveDuplicatesInSortedLL();
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
		Node resNode = head;
		while (head != null && head.next != null) {
			if (head.data == head.next.data)
				head.next = head.next.next;
			else
				head = head.next;
		}
		return resNode;
	}
}
