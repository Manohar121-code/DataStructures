package linkedList;

public class Add_1_toLLValue {
	private static int ADD_VALUE = 1;
	public static void main(String[] args) {
//		456
//		123
//		999
//		1879
		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);
		head.next.next.next = new Node(9);
		
		Add_1_toLLValue obj = new Add_1_toLLValue();
		head = obj.addOne(head);
		obj.printLL(head);
	}

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}

	private Node addOne(Node head) {
		head = reverseLL(head);
		int finalPrefix = doOperation(head);
		if (finalPrefix != 0)
			head.data = head.data + (10 * finalPrefix);
		return head;
	}
	
	private Node reverseLL(Node head) {
		Node prev = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	//getting reverse bcoz GFG need like that
	private int doOperation(Node head) {
		if (head == null)
			return -1;
		int fromNext = doOperation(head.next);
		int currPlusSum = (fromNext == -1) ? head.data + 1 : head.data + fromNext;
		head.data = currPlusSum % 10;
		return currPlusSum / 10;
	}
}
