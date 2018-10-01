package linkedList;

class RotateLinkedList {
	static Node head;

	public static void main(String[] args) {
		RotateLinkedList llist = new RotateLinkedList();
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
		rotate(head, 5);
		/*Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			head = null;
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				addToTheLast(new Node(a));
			}
			int k = sc.nextInt();
			rotate(head, k);
			System.out.println();
		}*/
	}

	public static void rotate(Node head, int k) {
		Node tailStart = head;
		Node start = null;
		Node parent = null;
		while (k > 0) {
			parent = head;
			head = head.next;
			k--;
		}
		parent.next = null;
		start = head;
		
		if (start == null) {
			head = tailStart;
		} else {
			while (start != null && start.next != null) {
				start = start.next;
			}
			start.next = tailStart;
		}
		
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
}
