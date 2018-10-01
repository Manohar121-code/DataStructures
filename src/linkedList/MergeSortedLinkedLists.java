package linkedList;

class MergeSortedLinkedLists {
	Node head;

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

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node mergeLists(Node headA, Node headB) {
		if (headA == null) return headB;
		if (headB == null) return headA;
		Node res;
		if (headA.data < headB.data) {
			res = headA;
			res.next = mergeLists(headA.next, headB);
		} else {
			res = headB;
			res.next = mergeLists(headA, headB.next);
		}
		return res;
	}

	public static void main(String args[]) {
		MergeSortedLinkedLists llist1 = new MergeSortedLinkedLists();
		llist1.addToTheLast(new Node(1));
		llist1.addToTheLast(new Node(12));
		llist1.addToTheLast(new Node(18));
		llist1.addToTheLast(new Node(34));
		llist1.addToTheLast(new Node(45));
		llist1.addToTheLast(new Node(76));
		MergeSortedLinkedLists llist2 = new MergeSortedLinkedLists();
		llist2.addToTheLast(new Node(1));
		llist2.addToTheLast(new Node(19));
		llist2.addToTheLast(new Node(26));
		llist2.addToTheLast(new Node(44));
		llist2.addToTheLast(new Node(48));
		llist2.addToTheLast(new Node(55));
		long startTime = System.nanoTime();
		llist1.head = mergeLists(llist1.head, llist2.head);
		long endTime = System.nanoTime();
		System.out.println("Total time taken : " + (endTime - startTime));
		llist1.printList();
	}

}