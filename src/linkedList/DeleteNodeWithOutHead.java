package linkedList;

public class DeleteNodeWithOutHead {
	Node head;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	Node addToTheLast(Node node) {
		if (head == null) {
			head = node;
			return head;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
			return node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

	void deleteNode(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public static void main(String args[]) {
		DeleteNodeWithOutHead llist = new DeleteNodeWithOutHead();
		Node first = llist.addToTheLast(new Node(1));
		Node second = llist.addToTheLast(new Node(2));
		Node third = llist.addToTheLast(new Node(3));
		Node fourth = llist.addToTheLast(new Node(4));
		Node fifth = llist.addToTheLast(new Node(5));
		Node sixth = llist.addToTheLast(new Node(6));
		Node seventh = llist.addToTheLast(new Node(7));
		long startTime = System.nanoTime();
		llist.deleteNode(third);
		long endTime = System.nanoTime();
		llist.printList(first);
		System.out.println("Total tme taken : "+(endTime - startTime));
	}
}
