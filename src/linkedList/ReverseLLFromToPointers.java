package linkedList;

public class ReverseLLFromToPointers {
	static Node head;

	public static void main(String args[]) {
		ReverseLLFromToPointers llist = new ReverseLLFromToPointers();
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
		Node startNode = llist.doOperation(head, 1, 6);
		long endTime = System.nanoTime();
		llist.printList(startNode);
		System.out.println("\nTotal time taken : " + (endTime - startTime));
	}

	public static Node doOperation(Node node, int i, int j) {
		Node firstEnd = node, prev = null, next = null;
		int count = -1;
		while (++count < i-1)
			firstEnd = firstEnd.next;

		Node start = firstEnd.next;
		while (start != null && count++ < j) {
			next = start.next;
			start.next = prev;
			prev = start;
			start = next;
		}
		Node middleEnd = firstEnd.next;
		firstEnd.next = prev;
		middleEnd.next = start;
		return node;
	}

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = new Node(0);
			head.next = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public static void printList(Node node) {
		node = node.next;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
