package linkedList;

public class PairSwapDataInLinkedList {
	static Node head;

	public static void main(String[] args) {
		int i = 100;
		System.out.println(i/10);
		System.out.println(i%10);
		PairSwapDataInLinkedList llist = new PairSwapDataInLinkedList();
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
		long startTime = System.nanoTime();
		llist.pairwiseSwap(head);
		long endTime = System.nanoTime();
		llist.printList(head);
		System.out.println("\nTotal time taken : "+(endTime - startTime));
	}

	public static void pairwiseSwap(Node node) {
		Node temp = node;
		while (temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
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
