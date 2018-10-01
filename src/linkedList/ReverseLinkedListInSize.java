package linkedList;

public class ReverseLinkedListInSize {
	static Node head;

	public static void main(String args[]) {
		ReverseLinkedListInSize llist = new ReverseLinkedListInSize();
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
		long startTime = System.nanoTime();
		Node startNode = llist.doOperation(head, 5);
		long endTime = System.nanoTime();
		llist.printList(startNode);
		System.out.println("\nTotal time taken : " + (endTime - startTime));
	}

	public static Node doOperation(Node node, int k) {
		Node curr = node, prev = null, next = null;
		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null)
			node.next = doOperation(next, k);
		return prev;
	}

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
