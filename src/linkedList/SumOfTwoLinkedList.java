package linkedList;

public class SumOfTwoLinkedList {
	Node head;

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	//llist1 : 6 5 4 3 2 1
	//llist2 : 6 8 5 3
	Node addTwoLists(Node first, Node second) {
		return doOperation(first, second, 0);
	}
	
	Node doOperation(Node first, Node second, int carry) {
		Node node = null;
		if (first != null || second != null) {
			int sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
			node = new Node(sum%10);
			node.next = doOperation(first != null ? first.next : null , second != null ? second.next : null, sum/10);
		} else {
			//node = carry != 0 ? new Node(carry) : null;
			if (carry != 0)
				node = new Node(carry);
		}
		return node;
	}
	
	public static void main(String[] args) {
		SumOfTwoLinkedList llist1 = new SumOfTwoLinkedList();
		llist1.push(1);
		llist1.push(2);
		llist1.push(3);
		llist1.push(4);
		llist1.push(5);
		llist1.push(6);
		SumOfTwoLinkedList llist2 = new SumOfTwoLinkedList();
		llist2.push(3);
		llist2.push(5);
		llist2.push(8);
		llist2.push(6);
		long startTime = System.nanoTime();
		llist1.head = llist1.addTwoLists(llist1.head, llist2.head);
		long endTime = System.nanoTime();
		System.out.println("Total time taken : " + (endTime - startTime));
		llist1.printList(llist1.head);
	}
}
