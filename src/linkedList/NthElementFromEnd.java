package linkedList;

public class NthElementFromEnd {
	static Node head;

	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

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

	int getNthFromLast(Node head, int n) {
		Node nthNode = head;
		while (n > 0 && head != null) {
			head = head.next;
			n--;
		}
		if (n > 0) {
			return -1;
		} else {
			while (head != null) {
				nthNode = nthNode.next;
				head = head.next;
			}
			return nthNode.data;
		}
	}

	public static void main(String args[]) {
		NthElementFromEnd llist = new NthElementFromEnd();
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
		int nthFromLast = llist.getNthFromLast(head, 14);
		long endTime = System.nanoTime();
		System.out.println("Nth element is : "+nthFromLast);
		System.out.println("Total time taken : "+(endTime-startTime));
	}
}
